package com.example.candidateapp.feature.candidate.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.candidateapp.R
import com.example.candidateapp.core.common.CustomBox
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.presentation.viewModels.CandidateViewModel
import com.example.candidateapp.feature.candidate.presentation.widgets.Property

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandidatInformation(

     candidat: Candidate,
     onEditCandidatClick: (Candidate) -> Unit  ,
    onBackClick: () -> Unit,

     candidateViewModel: CandidateViewModel = hiltViewModel()
){

    var starColor by rememberSaveable { mutableStateOf(candidat.isFavorite) }
    var showDialog by rememberSaveable { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = colorResource(id = R.color.search_color), // Change la couleur de fond

                ),
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                },
                title = {

                        Text(text =candidat.firstName)

                },
                actions = {
                    Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                            candidateViewModel.updateCandidate(
                                candidat.copy(
                                    lastName = candidat.lastName,
                                    firstName = candidat.firstName,
                                    email = candidat.email,
                                    phone = candidat.phone,
                                    dateOfBirth = candidat.dateOfBirth,
                                    salaryClaim = candidat.salaryClaim,
                                    information = candidat.information,
                                    isFavorite = !candidat.isFavorite
                                )
                            )
                            starColor = !candidat.isFavorite
                        }) {
                            Icon(
                                tint= if (starColor) Color.Yellow else Color.Black,
                                modifier= Modifier.size(48.dp),
                                painter = painterResource(id = R.drawable.trailing_icon_1),
                                contentDescription = "Star"
                            )
                        }

                            IconButton(onClick = { onEditCandidatClick(candidat)}) {
                                Icon(
                                    modifier= Modifier.size(48.dp),
                                    painter = painterResource(id = R.drawable.trailing_icon_2),
                                    contentDescription = "edit"
                                )
                            }
                        IconButton(onClick = {
                            showDialog = true

                        }) {
                            Icon(
                                tint= Color.Black,
                                modifier= Modifier.size(48.dp),
                                painter = painterResource(id = R.drawable.trailing_icon_3),
                                contentDescription = "delete"
                            )
                        }

                    }
                }

            )
        }


    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),

            ) {
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Suppression") },
                    text = { Text("This is a sample popup message.") },

                    dismissButton = {
                        Button(onClick = { showDialog = false }) {

                            Text("Annuler")
                        }
                    },
                    confirmButton = {
                        Button(onClick = {
                            showDialog = false
                             candidateViewModel.deleteCandidate(candidat)
                            onBackClick()

                        }) {

                            Text("Confirmer")
                        }
                    },
                )
            }
            Image(
                modifier =
                Modifier
                    .padding(top = 15.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(195.dp),
                painter = painterResource(R.drawable.add_candidat),
                contentDescription = null
            )
            Row(
                modifier = Modifier.padding(start = 80.dp, bottom = 20.dp),

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(50.dp),
            ) {
                Property(painter = painterResource(R.drawable.icon_button), text = "Appel")
                Property(painter = painterResource(R.drawable.icon_button__1_), text = "SmS")
                Property(painter = painterResource(R.drawable.icon_button__2_), text = "E-mail")


            }

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, start = 8.dp, bottom = 10.dp)
                    .height(159.dp)
                    .border(
                        2.dp,
                        Color.Gray,
                        shape = RoundedCornerShape(16.dp)
                    ) // Bordure avec coins arrondis
                    .clip(RoundedCornerShape(16.dp)) // Clip pour les coins arrondis
                    .background(color = colorResource(id = R.color.search_color)) // Couleur de fond


            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = stringResource(id = R.string.about),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.padding(20.dp))

                    Text(text = candidat.dateOfBirth, style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Anniversaire", style = MaterialTheme.typography.bodyLarge)


                }


            }

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, start = 8.dp, bottom = 10.dp)
                    .height(183.dp)
                    .border(
                        2.dp,
                        Color.Gray,
                        shape = RoundedCornerShape(16.dp)
                    ) // Bordure avec coins arrondis
                    .clip(RoundedCornerShape(16.dp)) // Clip pour les coins arrondis
                    .background(color = colorResource(id = R.color.search_color)) // Couleur de fond


            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = stringResource(id = R.string.salaire),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.padding(20.dp))

                    Text(text = candidat.salaryClaim, style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(text = "soit £ 3026,99", style = MaterialTheme.typography.bodyLarge)


                }


            }

            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, start = 8.dp, bottom = 10.dp)

                    .border(
                        2.dp,
                        Color.Gray,
                        shape = RoundedCornerShape(16.dp)
                    ) // Bordure avec coins arrondis
                    .clip(RoundedCornerShape(16.dp)) // Clip pour les coins arrondis
                    .background(color = colorResource(id = R.color.search_color)) // Couleur de fond


            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = stringResource(id = R.string.note),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.padding(20.dp))

                    Text(text = candidat.information, style = MaterialTheme.typography.bodyLarge)


                }


            }

        }

    }
}


