package dev.pstens.remindr

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import dev.pstens.data.AppDatabase
import dev.pstens.data.reminder.FirebaseSource
import dev.pstens.data.reminder.InMemoryDataSource
import dev.pstens.data.reminder.ReminderRepositoryImpl
import dev.pstens.data.user.FirebaseStorage
import dev.pstens.data.user.RoomStorage
import dev.pstens.data.user.UserRepositoryImpl
import dev.pstens.domain.reminder.GetReminder
import dev.pstens.domain.reminder.LoginWithEmail
import dev.pstens.domain.user.UserRepository
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ReminderApp : Application() {
    private val modules = module {
        factory { AppDatabase.instantiate(applicationContext) }
        single { ReminderRepositoryImpl(InMemoryDataSource(), FirebaseSource()) }
        viewModel { StatsViewModel(GetReminder(get())) }
        single { get<AppDatabase>().userDao() }
        single {
            UserRepositoryImpl(
                RoomStorage(get()),
                FirebaseStorage(FirebaseAuth.getInstance())
            ) as UserRepository
        }
        viewModel { UserViewModel(LoginWithEmail(get())) }
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        startKoin {
            androidLogger()
            modules(modules)
        }
    }
}
