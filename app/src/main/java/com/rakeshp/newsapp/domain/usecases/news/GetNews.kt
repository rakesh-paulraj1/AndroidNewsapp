package com.rakeshp.newsapp.domain.usecases.news


import androidx.paging.PagingData

import com.rakeshp.newsapp.domain.model.Article
import com.rakeshp.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews (private val newsrepository:NewsRepository){

    operator fun invoke(sources: List<String>):Flow<PagingData<Article>>{
        return newsrepository.getNews(sources=sources)
    }
}