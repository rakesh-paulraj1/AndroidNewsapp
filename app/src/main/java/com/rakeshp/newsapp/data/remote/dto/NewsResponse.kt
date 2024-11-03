package com.rakeshp.newsapp.data.remote.dto

import com.rakeshp.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)