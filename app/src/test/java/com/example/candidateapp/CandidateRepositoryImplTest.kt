package com.example.candidateapp.feature.candidate.data.repositories

import com.example.candidateapp.feature.candidate.data.datasources.local.CandidateDao
import com.example.candidateapp.feature.candidate.data.models.Candidate
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CandidateRepositoryImplTest {

    private lateinit var candidateDao: CandidateDao
    private lateinit var repository: CandidateRepositoryImpl

    @Before
    fun setup() {
        candidateDao = mock<CandidateDao>()

        repository = CandidateRepositoryImpl(candidateDao)
    }

    @Test
    fun `test getAllCandidate returns list of candidates`() = runTest {
        // Arrange
        val candidates = listOf(
            Candidate(id = 1, lastName = "Doe", firstName = "John", phone = "123456789", email = "john.doe@example.com", dateOfBirth = "1990-01-01", salaryClaim = "50000", information = "Experienced", isFavorite = true),
            Candidate(id = 2, lastName = "Smith", firstName = "Jane", phone = "987654321", email = "jane.smith@example.com", dateOfBirth = "1995-05-15", salaryClaim = "60000", information = "Entry-level", isFavorite = false)
        )
        whenever(candidateDao.getAllCandidate()).thenReturn(flowOf(candidates))

        // Act
        val result = repository.getAllCandidate()

        // Assert
        result.collect {
            assert(it == candidates)
        }
    }

    @Test
    fun `test addCandidate calls dao method`() = runTest {
        // Arrange
        val candidate = Candidate(id = 1, lastName = "Doe", firstName = "John", phone = "123456789", email = "john.doe@example.com", dateOfBirth = "1990-01-01", salaryClaim = "50000", information = "Experienced", isFavorite = true)

        // Act
        repository.addCandidate(candidate)

        // Assert
        verify(candidateDao).addCandidate(candidate)
    }

    @Test
    fun `test deleteCandidate calls dao method`() = runTest {
        // Arrange
        val candidate = Candidate(id = 1, lastName = "Doe", firstName = "John", phone = "123456789", email = "john.doe@example.com", dateOfBirth = "1990-01-01", salaryClaim = "50000", information = "Experienced", isFavorite = true)

        // Act
        repository.deleteCandidate(candidate)

        // Assert
        verify(candidateDao).deleteCandidate(candidate)
    }

    @Test
    fun `test updateCandidate calls dao method`() = runTest {
        // Arrange
        val candidate = Candidate(id = 1, lastName = "Doe", firstName = "John", phone = "123456789", email = "john.doe@example.com", dateOfBirth = "1990-01-01", salaryClaim = "50000", information = "Experienced", isFavorite = true)

        // Act
        repository.updateCandidate(candidate)

        // Assert
        verify(candidateDao).updateCandidate(candidate)
    }

    @Test
    fun `test SearchCandidate calls dao method`() = runTest {
        // Arrange
        val searchQuery = "John"
        val candidates = listOf(
            Candidate(id = 1, lastName = "Doe", firstName = "John", phone = "123456789", email = "john.doe@example.com", dateOfBirth = "1990-01-01", salaryClaim = "50000", information = "Experienced", isFavorite = true)
        )
        whenever(candidateDao.SearchCandidate(searchQuery)).thenReturn(flowOf(candidates))

        // Act
        val result = repository.SearchCandidate(searchQuery)

        // Assert
        result.collect {
            assert(it == candidates)
        }
    }
}
