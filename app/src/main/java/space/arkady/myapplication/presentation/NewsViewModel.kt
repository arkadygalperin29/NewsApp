package space.arkady.myapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.arkady.myapplication.domain.interactor.NewsInteractor
import space.arkady.myapplication.domain.models.NewsInfo

class NewsViewModel(private val newsInteractor: NewsInteractor) : ViewModel() {
    val news: LiveData<NewsInfo> get() = _news
    private val _news = MutableLiveData<NewsInfo>()

    fun setWord(word: String) {
        loadData(word)
    }

    private fun loadData(word: String) {
        viewModelScope.launch {
            _news.postValue(newsInteractor.getNews(word))
        }
    }
}