package com.example.candidateapp.feature.candidate.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.data.repositories.CandidateRepositoryImpl
import com.example.candidateapp.feature.candidate.presentation.uiState.CandidateUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class CandidateViewModel @Inject constructor( private val  candidateRepository: CandidateRepositoryImpl):
    ViewModel() {


    var candidateState : CandidateUiState by mutableStateOf(CandidateUiState.Loading)
    init {
        fetchCandidate()
    }

    private fun fetchCandidate()
    {
        viewModelScope.launch {
            candidateState = try {
                val candidates = candidateRepository.getAllCandidate()
                val candidatesFlow: Flow<List<Candidate>> =  candidates

                // Collecte les données émises par le Flow
                val candidatesList = mutableListOf<Candidate>()

                candidatesFlow.collect { list ->
                    candidatesList.addAll(list) // Ajoute les éléments de la liste émise à la liste mutable
                }

                CandidateUiState.Success( candidates= candidatesList)
            } catch (iO: IOException) {
                println("error $iO")
                CandidateUiState.Error(error = iO.toString())
            }
        }
    }
}
