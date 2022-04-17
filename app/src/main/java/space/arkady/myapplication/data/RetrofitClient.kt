package space.arkady.myapplication.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_KEY = "https://newsapi.org/v2/"
    const val BASE_API_KEY = "9459ca3c16c041bb9967793106de817f"

    private var qson: Gson = GsonBuilder().setLenient().create()

    private fun getClient() = Retrofit.Builder().baseUrl(BASE_KEY).addConverterFactory(
        GsonConverterFactory.create(
            qson
        )
    ).build()

    fun getNewsApi(): NewsAPI = getClient().create(NewsAPI::class.java)


}