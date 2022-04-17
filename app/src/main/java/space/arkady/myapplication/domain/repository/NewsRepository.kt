package space.arkady.myapplication.domain.repository

import space.arkady.myapplication.data.models.NewsResponse

interface NewsRepository {
    suspend fun getNewsResponse(searchWord:String) : NewsResponse
}