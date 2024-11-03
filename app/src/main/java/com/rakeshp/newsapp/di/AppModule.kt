package com.rakeshp.newsapp.di

import android.app.Application
import com.rakeshp.newsapp.data.manager.LocalUserManagerImpl
import com.rakeshp.newsapp.data.remote.NewsApi
import com.rakeshp.newsapp.data.repository.NewsRepositoryImpl
import com.rakeshp.newsapp.domain.manager.LocalUserManager
import com.rakeshp.newsapp.domain.repository.NewsRepository
import com.rakeshp.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.rakeshp.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.rakeshp.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.rakeshp.newsapp.domain.usecases.news.GetNews
import com.rakeshp.newsapp.domain.usecases.news.NewsUseCases
import com.rakeshp.newsapp.utill.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)

    )
@Provides
@Singleton
fun provideNewsApi():NewsApi{
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi::class.java)
}
    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository =NewsRepositoryImpl(newsApi)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ):NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}
