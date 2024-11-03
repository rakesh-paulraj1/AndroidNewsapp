package com.rakeshp.newsapp.data.remote
import com.rakeshp.newsapp.data.remote.dto.NewsResponse
import com.rakeshp.newsapp.utill.Constants.API_KEY
import retrofit2.http.GET;
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query ("page") page:Int,
        @Query("Sources") sources:String,
        @Query("apikey") apikey:String=API_KEY
    ): NewsResponse

}