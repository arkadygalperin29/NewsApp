package space.arkady.myapplication.data.models

import com.google.gson.annotations.SerializedName


data class NewsResponce(
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Long?,
    @SerializedName("articles")
    val articles: List<NewsArticle>,

)
