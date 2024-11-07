package com.example.candidateapp.feature.candidate.presentation.screens




import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.domain.entities.CandidateEntity
import com.example.candidateapp.feature.candidate.presentation.uiState.CandidateUiState
import com.example.candidateapp.feature.candidate.presentation.viewModels.CandidateViewModel
import com.example.candidateapp.feature.candidate.presentation.widgets.Candidate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  CandidateWishListScreen(
    candidateViewModel: CandidateViewModel = hiltViewModel(),
    onClick: (Candidate) -> Unit
) {


    when(candidateViewModel.candidateState){
        is  CandidateUiState.Loading -> Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()

        ) {
            CircularProgressIndicator()
        }
        is CandidateUiState.Success->LazyColumn( ) {
            val candidates = (candidateViewModel.candidateState as CandidateUiState.Success).candidates
            val favoriteCandidates =  candidates.filter { it.isFavorite }

            items(favoriteCandidates) { candidate ->
                Candidate(candidat = candidate,onClick = { onClick(it) })

            }
        }

        is CandidateUiState.Error-> Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()

        ) {
            val error = (candidateViewModel.candidateState as CandidateUiState.Error).error
            Text(text = error)
        }

        else -> {
            Text(text = "error")
        }
    }
}

/*
when(candidateViewModel.favoriteState){
        is  FavoriteUiState.Loading -> Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()

        ) {
            CircularProgressIndicator()
        }
        is FavoriteUiState.Success->LazyColumn( ) {
            val favorites = (candidateViewModel.favoriteState as FavoriteUiState.Success).favorites

            items(favorites) { favorite ->
                Candidate(candidat = favorite,onClick = { onClick(it) })

            }
        }

        is FavoriteUiState.Error-> Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()

        ) {
            val error = (candidateViewModel.candidateState as CandidateUiState.Error).error
            Text(text = error)
        }

        else -> {
            Text(text = "error")
        }
    }*/