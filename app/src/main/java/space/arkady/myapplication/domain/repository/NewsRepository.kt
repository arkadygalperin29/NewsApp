package space.arkady.myapplication.domain.repository

import space.arkady.myapplication.data.models.NewsResponce

interface NewsRepository {
    suspend fun getNewsResponce(searchWord:String) : NewsResponce
}