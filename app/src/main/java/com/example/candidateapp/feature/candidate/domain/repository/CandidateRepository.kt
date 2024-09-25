package com.example.candidateapp.feature.candidate.domain.repository

import com.example.candidateapp.feature.candidate.data.models.Candidate
import kotlinx.coroutines.flow.Flow

interface CandidateRepository {
    suspend fun getAllCandidate(): Flow<List<Candidate>>
    suspend fun addCandidate(candidate: Candidate)
}