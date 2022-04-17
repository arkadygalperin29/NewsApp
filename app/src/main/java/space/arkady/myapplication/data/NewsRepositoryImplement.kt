package space.arkady.myapplication.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import space.arkady.myapplication.data.models.NewsResponse
import space.arkady.myapplication.domain.repository.NewsRepository

class NewsRepositoryImplement(private val api: NewsAPI) : NewsRepository {
    override suspend fun getNewsResponse(searchWord: String): NewsResponse {
        return withContext(Dispatchers.IO) {
            return@withContext api.getEverything(
                query = searchWord,
                language = "en"
            )
        }
    }
}