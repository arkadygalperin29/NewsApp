package space.arkady.myapplication.data.models

import com.google.gson.annotations.SerializedName


data class NewsResponse(
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Long,
    @SerializedName("articles")
    val articles: List<Article>,

    )
