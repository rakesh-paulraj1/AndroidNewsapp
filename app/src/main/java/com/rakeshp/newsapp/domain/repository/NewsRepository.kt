package com.rakeshp.newsapp.domain.repository
import androidx.paging.PagingData
import com.rakeshp.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources:List<String>):Flow<PagingData<Article>>
}