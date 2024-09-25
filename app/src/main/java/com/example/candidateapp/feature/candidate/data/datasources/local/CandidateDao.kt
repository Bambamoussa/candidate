package com.example.candidateapp.feature.candidate.data.datasources.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.candidateapp.feature.candidate.data.models.Candidate
import kotlinx.coroutines.flow.Flow

interface CandidateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCandidate(candidate: Candidate)

    @Query("SELECT * FROM Candidate")
    fun getAllCandidate():Flow<List<Candidate>>
}