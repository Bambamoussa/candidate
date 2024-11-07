package com.example.candidateapp.feature.candidate.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.candidateapp.R
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.domain.entities.CandidateEntity
import com.example.candidateapp.feature.candidate.presentation.viewModels.CandidateViewModel

import com.example.candidateapp.feature.candidate.presentation.widgets.TabView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onFABClick: () -> Unit = {},
    onClick: (Candidate) -> Unit,
    candidateViewModel: CandidateViewModel = hiltViewModel(),
) {
    val searchQuery = remember { mutableStateOf("") }
    val manager = LocalFocusManager.current
    Scaffold(
        modifier = Modifier

            .clickable { manager.clearFocus() },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                containerColor = colorResource(id = R.color.search_color),
                onClick =  {
                    onFABClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)

                .clickable { manager.clearFocus() },

        ){
            OutlinedTextField(
                value = searchQuery.value,
                onValueChange = {
                    searchQuery.value = it
                    candidateViewModel.searchCandidate(it)
                },
                placeholder = { Text(stringResource(id = R.string.search_candidate)) },
                trailingIcon = {
                    IconButton(onClick = { /* Action de recherche */ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                    }
                },
                modifier = Modifier
                    .padding(20.dp)
                    .width(380.dp)
                    .height(56.dp)
                

                ,
                shape = CircleShape,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.search_color),
                    unfocusedBorderColor = Color.Gray
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.None // Ajuste pour l'action finale
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Empêche la touche "Entrée" d'agir en supprimant le focus
                        manager.clearFocus()
                    }
                )
            )
            TabView(onClick = onClick,)
        }



    }
}