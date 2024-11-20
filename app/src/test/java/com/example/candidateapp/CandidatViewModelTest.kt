package com.example.candidateapp

import com.example.candidateapp.feature.candidate.presentation.viewModels.CandidateViewModel



import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.data.repositories.CandidateRepositoryImpl
import com.example.candidateapp.feature.candidate.presentation.uiState.CandidateUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class CandidateViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher) // Configure le dispatcher
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Réinitialise le dispatcher principal
    }

    private val mockRepository = mock(CandidateRepositoryImpl::class.java)

    private val testCandidate = Candidate(id = 1, lastName = "Doe", firstName = "John", phone = "123456789", email = "john.doe@example.com", dateOfBirth = "1990-01-01", salaryClaim = "50000", information = "Experienced", isFavorite = true)





    @Test
    fun `addCandidate should call repository to add candidate`() = runBlockingTest {
        // Arrange
        val viewModel = CandidateViewModel(mockRepository)

        // Act
        viewModel.addCandidate(testCandidate)

        // Assert
        verify(mockRepository).addCandidate(testCandidate)
    }

    @Test
    fun `updateCandidate should call repository to update candidate`() = runBlockingTest {
        // Arrange
        val viewModel = CandidateViewModel(mockRepository)

        // Act
        viewModel.updateCandidate(testCandidate)

        // Assert
        verify(mockRepository).updateCandidate(testCandidate)
    }

    @Test
    fun `deleteCandidate should call repository to delete candidate`() = runBlockingTest {
        // Arrange
        val viewModel = CandidateViewModel(mockRepository)

        // Act
        viewModel.deleteCandidate(testCandidate)

        // Assert
        verify(mockRepository).deleteCandidate(testCandidate)
    }
}
