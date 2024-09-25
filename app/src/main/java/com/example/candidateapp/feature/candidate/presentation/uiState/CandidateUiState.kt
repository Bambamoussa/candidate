package com.example.candidateapp.feature.candidate.presentation.uiState

import com.example.candidateapp.feature.candidate.data.models.Candidate

sealed class CandidateUiState {
    object Loading : CandidateUiState()
    data class Success(val candidates: List<Candidate>) : CandidateUiState()
    data class Error(val error: String) : CandidateUiState()
}
