package space.arkady.myapplication.domain.models

sealed class BaseItem

data class Date(
val dateNews: String
): BaseItem()

data class News(
val author: String?,
val title: String,
val description: String,
val articleToUrl: String?,
val urlToImage: String,
val publishedAt: String?,
val content: String?,
val idNews: String?,
val nameNews: String?
) : BaseItem()
