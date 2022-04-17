package space.arkady.myapplication.presentation

import android.app.Application
import org.koin.core.context.startKoin
import space.arkady.myapplication.data.di.dataModule
import space.arkady.myapplication.domain.di.domainModule
import space.arkady.myapplication.presentation.di.viewModelModule

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    domainModule,
                    dataModule,
                )
            )
        }
    }
}