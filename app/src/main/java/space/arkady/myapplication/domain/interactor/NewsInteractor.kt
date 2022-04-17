package space.arkady.myapplication.domain.interactor

import space.arkady.myapplication.domain.models.NewsInfo

interface NewsInteractor {
    suspend fun getNews(searchWords:String) : NewsInfo
}

