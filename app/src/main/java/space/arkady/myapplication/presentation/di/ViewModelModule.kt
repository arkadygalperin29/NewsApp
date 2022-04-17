package space.arkady.myapplication.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import space.arkady.myapplication.presentation.NewsViewModel

val viewModelModule = module {
    viewModel {
        NewsViewModel(
            get()
        )
    }
}