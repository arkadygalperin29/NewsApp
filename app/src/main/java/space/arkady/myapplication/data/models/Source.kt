package space.arkady.myapplication.data.models

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val idNews: String,
    @SerializedName("name")
    val nameNews: String?
)
