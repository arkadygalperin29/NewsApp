package space.arkady.myapplication.domain.interactor

import space.arkady.myapplication.data.models.NewsResponce
import space.arkady.myapplication.domain.models.NewsInfo
import space.arkady.myapplication.utils.toBaseItem

interface NewsInteractor {
    suspend fun getNews(searchWords:String) : NewsInfo
}

