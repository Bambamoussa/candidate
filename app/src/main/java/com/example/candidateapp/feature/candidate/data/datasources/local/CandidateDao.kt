package com.example.candidateapp.feature.candidate.data.datasources.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.candidateapp.feature.candidate.data.models.Candidate
import kotlinx.coroutines.flow.Flow

@Dao
interface CandidateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCandidate(candidate: Candidate)

    @Query("SELECT * FROM Candidate")
    fun getAllCandidate():Flow<List<Candidate>>

    @Delete
    suspend fun deleteCandidate(candidate: Candidate)

    @Update
    suspend fun updateCandidate(candidate: Candidate)


    @Query("SELECT * FROM candidate WHERE lastName LIKE '%' || :item || '%' OR firstName LIKE '%' || :item || '%'")
    fun SearchCandidate(item:String) :Flow<List<Candidate>>

}