package dev.pstens.remindr

import android.app.Application
import dev.pstens.data.reminder.FirebaseSource
import dev.pstens.data.reminder.InMemoryDataSource
import dev.pstens.data.reminder.ReminderDatabase
import dev.pstens.data.reminder.ReminderRepositoryImpl
import dev.pstens.domain.reminder.GetReminder
import dev.pstens.domain.reminder.ReminderRepository
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ReminderApp : Application() {
    private val modules = module {
        single {
            ReminderRepositoryImpl(
                InMemoryDataSource(),
                FirebaseSource()
            ) as ReminderRepository
        }
        viewModel { StatsViewModel(GetReminder(get())) }
        factory { ReminderDatabase.instantiate(applicationContext) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            modules(modules)
        }
    }
}
