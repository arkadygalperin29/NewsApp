package space.arkady.myapplication.data.di

import org.koin.dsl.module
import space.arkady.myapplication.data.RetrofitClient

val dataModule = module {
    single {
        RetrofitClient.getNewsApi()
    }
}
