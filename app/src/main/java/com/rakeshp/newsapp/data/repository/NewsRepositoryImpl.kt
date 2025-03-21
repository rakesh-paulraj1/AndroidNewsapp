package com.rakeshp.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rakeshp.newsapp.data.remote.NewsApi
import com.rakeshp.newsapp.data.remote.NewsPagingSource
import com.rakeshp.newsapp.domain.model.Article
import com.rakeshp.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl (
    private val newsApi: NewsApi
):NewsRepository{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return  Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}