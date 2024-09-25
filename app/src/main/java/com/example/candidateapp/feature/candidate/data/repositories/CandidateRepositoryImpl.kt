package com.example.candidateapp.feature.candidate.data.repositories

import com.example.candidateapp.feature.candidate.data.datasources.local.CandidateDao
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.domain.repository.CandidateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CandidateRepositoryImpl @Inject constructor(
    private  val candidateDao:CandidateDao
): CandidateRepository {
    override suspend fun getAllCandidate(): Flow<List<Candidate>> {
         return candidateDao.getAllCandidate()
    }

    override suspend fun addCandidate(candidate: Candidate) {
         candidateDao.addCandidate(candidate)
    }
}