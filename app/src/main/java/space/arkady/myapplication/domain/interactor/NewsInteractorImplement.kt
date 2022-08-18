package space.arkady.myapplication.domain.interactor

import space.arkady.myapplication.domain.models.NewsInfo
import space.arkady.myapplication.domain.repository.NewsRepository
import space.arkady.myapplication.utils.toNewsInfo

class NewsInteractorImplement(
    private val repository: NewsRepository
) : NewsInteractor {
    override suspend fun getNews(searchWords: String): NewsInfo {
        return repository.getNewsResponse(searchWords).toNewsInfo()
    }
}
