package com.example.candidateapp.core.data

import android.content.ClipData
import com.example.candidateapp.feature.candidate.data.datasources.local.CandidateDao


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.candidateapp.feature.candidate.data.models.Candidate

@Database(entities = [Candidate::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun  candidateDao(): CandidateDao
}