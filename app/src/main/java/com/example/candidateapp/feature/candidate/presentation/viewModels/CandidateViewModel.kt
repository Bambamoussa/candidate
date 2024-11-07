package com.example.candidateapp.feature.candidate.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.data.repositories.CandidateRepositoryImpl

import com.example.candidateapp.feature.candidate.presentation.uiState.CandidateUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class CandidateViewModel @Inject constructor( private val  candidateRepository: CandidateRepositoryImpl):
    ViewModel() {


    var candidateState : CandidateUiState by mutableStateOf( CandidateUiState.Loading)

    init {
        fetchCandidate()

    }

    private fun fetchCandidate()
    {
        viewModelScope.launch {
            candidateState = try {
                val candidates = candidateRepository.getAllCandidate()

                val candidatesList = mutableListOf<Candidate>()

                candidates.collect { list ->
                    candidatesList.addAll(list)
                    candidateState = CandidateUiState.Success(candidates = candidatesList)
                }

                CandidateUiState.Success( candidates= candidatesList)
            } catch (iO: IOException) {
                println("error $iO")
                CandidateUiState.Error(error = iO.toString())
            }
        }
    }

      fun searchCandidate(item:String)
    {
        viewModelScope.launch {
            candidateState = try {
                val candidates = candidateRepository.SearchCandidate(item)

                val candidatesList = mutableListOf<Candidate>()

                candidates.collect { list ->
                    candidatesList.addAll(list)
                    candidateState = CandidateUiState.Success(candidates = candidatesList)
                }

                CandidateUiState.Success( candidates= candidatesList)
            } catch (iO: IOException) {
                println("error $iO")
                CandidateUiState.Error(error = iO.toString())
            }
        }
    }

    fun updateCandidate (candidate: Candidate) {
        viewModelScope.launch(IO) {
            candidateRepository.updateCandidate(candidate = candidate)
        }
    }

    fun deleteCandidate (candidate: Candidate) {
        viewModelScope.launch(IO) {
            candidateRepository.deleteCandidate(candidate = candidate)
        }
    }


    fun addCandidate(candidate: Candidate  ) {
        viewModelScope.launch(Dispatchers.IO) {
            candidateRepository.addCandidate(candidate = candidate)

        }
    }




}
