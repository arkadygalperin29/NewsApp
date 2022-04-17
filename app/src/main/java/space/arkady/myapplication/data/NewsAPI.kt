package space.arkady.myapplication.data

import retrofit2.http.GET
import retrofit2.http.Query
import space.arkady.myapplication.data.models.NewsResponse

interface NewsAPI {

    @GET("everything")
    suspend fun getEverything(
        @Query("q") query: String?,
        @Query("apiKey") apiKey: String = RetrofitClient.BASE_API_KEY,
        @Query("domains") domains: String?,
        @Query("language") language: String?,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("page") pageNumber: Int = 1,
        @Query("pageSize") pageSize: Int = 20,
        @Query("sources") sources: String = "The Wall Street Journal"
    ): NewsResponse
}