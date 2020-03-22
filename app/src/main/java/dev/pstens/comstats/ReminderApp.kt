package dev.pstens.comstats

import android.app.Application
import dev.pstens.cache.ReminderDatabase
import dev.pstens.data.ReminderRepository
import dev.pstens.framework.FirebaseSource
import dev.pstens.framework.InMemoryDataSource
import dev.pstens.usecases.GetReminder
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ReminderApp : Application() {
    private val modules = module {
        single { ReminderRepository(InMemoryDataSource(), FirebaseSource()) }
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
