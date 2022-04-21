package space.arkady.myapplication.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.SearchView
import com.bumptech.glide.Glide
import space.arkady.myapplication.data.models.Article
import space.arkady.myapplication.data.models.NewsResponse
import space.arkady.myapplication.domain.models.BaseItem
import space.arkady.myapplication.domain.models.Date
import space.arkady.myapplication.domain.models.News
import space.arkady.myapplication.domain.models.NewsInfo

fun List<Article>.toBaseItem(): List<BaseItem> {
    val listBaseItem = mutableListOf<BaseItem>()

    this.forEachIndexed { index, newsArticle ->
        if (listBaseItem.isEmpty()) {
            listBaseItem.add(
                Date(
                    dateNews = newsArticle.publishedAt.toDate()
                )
            )
        } else if (newsArticle.publishedAt.toDate() != this[index - 1].publishedAt.toDate()) {
            listBaseItem.add(
                Date(
                    dateNews = newsArticle.publishedAt.toDate()
                )
            )
        }
        listBaseItem.add(
            News(
                author = newsArticle.author,
                title = newsArticle.title,
                description = newsArticle.description,
                articleUrl = newsArticle.articleUrl,
                content = newsArticle.content,
                idNews = newsArticle.source.idNews,
                nameNews = newsArticle.source.nameNews
            )
        )
    }
    return listBaseItem.toList()
}

fun NewsResponse.toNewsInfo(): NewsInfo {
    return NewsInfo(
        this.totalResults.toString(),
        this.articles.toBaseItem()
    )
}

fun String.toDate(): String {
    return this.substring(0, 10)
}

fun ImageView.setImageByUrl(url: String) {
    Glide.with(this.context).load(url).into(this)
}

fun Context.createIntentLinkNews(urlNews: String?, getSubject: String?, getTitleLinkMenu: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, getSubject)
        putExtra(Intent.EXTRA_TEXT, urlNews)
    }
    startActivity(Intent.createChooser(intent, getTitleLinkMenu))
}

fun SearchView.searchOnQueryListener(submit: (String?) -> Boolean) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(newQuery: String?): Boolean {
            return submit(newQuery)
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }
    })
}

fun Context.hideKeyboard(view: View) {
val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}