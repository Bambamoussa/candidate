package com.example.candidateapp.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.candidateapp.core.data.AppDatabase
import com.example.candidateapp.feature.candidate.data.datasources.local.CandidateDao
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.data.repositories.CandidateRepositoryImpl
import com.example.candidateapp.feature.candidate.domain.repository.CandidateRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "candidate_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCandidateDao(appDatabase: AppDatabase): CandidateDao = appDatabase.candidateDao()

    @Provides
    @Singleton
    fun provideCandidateRepository(
        candidateDao:  CandidateDao
    ):CandidateRepository=CandidateRepositoryImpl(candidateDao = candidateDao)



}