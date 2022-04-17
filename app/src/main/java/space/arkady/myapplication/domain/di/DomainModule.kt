package space.arkady.myapplication.domain.di

import org.koin.dsl.module
import space.arkady.myapplication.data.NewsRepositoryImplement
import space.arkady.myapplication.data.RetrofitClient
import space.arkady.myapplication.domain.interactor.NewsInteractor
import space.arkady.myapplication.domain.interactor.NewsInteractorImplement
import space.arkady.myapplication.domain.repository.NewsRepository

val domainModule = module {
    single<NewsInteractor> {
        NewsInteractorImplement(
            get()
        )
    }
    single<NewsRepository> {
        NewsRepositoryImplement(
            RetrofitClient.getNewsApi()
        )
    }
}