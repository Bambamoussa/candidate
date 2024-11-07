package com.example.candidateapp.feature.candidate.presentation.screens



import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.material3.Divider

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.candidateapp.R
import com.example.candidateapp.core.common.CustomAppBar
import com.example.candidateapp.core.common.CustomButton
import com.example.candidateapp.core.common.CustomOutLineTextField
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.domain.entities.CandidateEntity
import com.example.candidateapp.feature.candidate.presentation.viewModels.CandidateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.UUID

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  AddCandidateSceen(
    candidate: Candidate?,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    candidateViewModel: CandidateViewModel= hiltViewModel()

) {

    var lastName by rememberSaveable { mutableStateOf(candidate?.lastName?:"") }
    var firstName by rememberSaveable { mutableStateOf(candidate?.firstName?:"") }
    var email by rememberSaveable { mutableStateOf(candidate?.email?:"") }

    var salary by rememberSaveable { mutableStateOf(candidate?.salaryClaim?:"") }
    var phone by rememberSaveable { mutableStateOf(candidate?.phone?:"") }
    var date by rememberSaveable { mutableStateOf(candidate?.dateOfBirth?:"") }
    var note by rememberSaveable { mutableStateOf(candidate?.information?:"") }

    val manager = LocalFocusManager.current
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {

            FloatingActionButton(
                shape = RoundedCornerShape(30.dp),
                containerColor = Color.Blue,
                contentColor = Color.White,
                content= { Text(text = "Sauvegarder",
                    style =  MaterialTheme.typography.labelLarge,
                    color = Color.White)
                         },
                 modifier = Modifier
                     .fillMaxWidth()

                     .padding(8.dp),
                onClick =  {
                    if (verifyAndCreateCandidate(firstName = firstName,
                            lastName = lastName  ,
                            email = email  ,
                            salary = salary,
                            date = date ,
                            note = note,
                            phone=phone,
                            snackbarHostState = snackbarHostState,
                            scope = scope,
                             context = context,
                        )) {

                      if (candidate==null) candidateViewModel.addCandidate(
                            Candidate(lastName = lastName, firstName = firstName,
                                email =email,
                                phone = phone,
                                dateOfBirth = date,
                                salaryClaim = salary,
                                information = note,



                            )
                        )else candidateViewModel.updateCandidate(
                          candidate.copy(
                              lastName = lastName,
                              firstName = firstName,
                              email = email,
                              phone = phone,
                              dateOfBirth = date,
                              salaryClaim = salary,
                              information = note
                          )
                      )

                        onSaveClick()
                    }
                }
            )
        },
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
                title = { Text(text = stringResource(id = if (candidate== null) ( R.string.add_candidate) else(R.string.editCandidate) )) })
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .clickable { manager.clearFocus() },

            ) {

            Image(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp)
                    .fillMaxWidth()
                    .height(195.dp),
                painter = painterResource(R.drawable.add_candidat),
                contentDescription = null
            )

            CustomOutLineTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = stringResource(id = R.string.last_name),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                manager = manager,
                painter = painterResource(R.drawable.person_icon),
            )
            CustomOutLineTextField(

                value = firstName,
                onValueChange = { firstName = it },
                label = stringResource(id = R.string.first_name),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),

                manager = manager,

                )
            CustomOutLineTextField(

                value = phone,
                onValueChange = {

                    phone = it },
                label = stringResource(id = R.string.phone),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),

                manager = manager,
                painter = painterResource(R.drawable.phone_icon),
            )
            CustomOutLineTextField(

                value = email,
                onValueChange = { email = it },
                label = stringResource(id = R.string.email),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),

                manager = manager,
                painter = painterResource(R.drawable.email_icon),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.birth_icon), // Remplacez par votre icône
                    contentDescription = "Icon",
                    modifier = Modifier.size(48.dp),

                    )


                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp,)
                        .height(218.dp)
                        .border(
                            2.dp,
                            Color.Gray,
                            shape = RoundedCornerShape(16.dp)
                        ) // Bordure avec coins arrondis
                        .clip(RoundedCornerShape(16.dp)) // Clip pour les coins arrondis
                        .background(color = colorResource(id = R.color.search_color)) // Couleur de fond
                ){
                    Column(modifier = Modifier.padding(24.dp)) {
                        Text(text = stringResource(id = R.string.select_date),
                            style = MaterialTheme.typography.labelMedium )
                        Spacer(modifier = Modifier.height( 24.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Text(text = stringResource(id = R.string.enter_date),
                                style = MaterialTheme.typography.headlineLarge)
                            Image(
                                painter = painterResource(R.drawable.date_icon), // Remplacez par votre icône
                                contentDescription = "date",
                                modifier = Modifier.size(48.dp),

                                )

                        }
                        Spacer(modifier = Modifier.height( 12.dp))
                        Divider(thickness = 2.dp)
                        Spacer(modifier = Modifier.height( 12.dp))
                        OutlinedTextField(
                            value =date ,
                            placeholder = { Text(text = " (jj/mm/aaaa)", ) },
                            onValueChange =  {date= it},
                            label = { Text(stringResource(id = R.string.date))},


                            colors  = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Blue,
                                disabledBorderColor = Color.Gray,
                                focusedBorderColor = Color.Blue,
                                focusedLabelColor = Color.Gray,

                                ),
                            keyboardActions = KeyboardActions(
                                onDone  = {
                                    manager.clearFocus()

                                }
                            )

                        )

                    }
                }
            }
            CustomOutLineTextField(

                value = salary,
                onValueChange = { salary = it },
                label = stringResource(id = R.string.salaire),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),

                manager = manager,
                painter = painterResource(R.drawable.salary_icon),
            )


            CustomOutLineTextField(
                value =note ,
                onValueChange = { note= it },
                label = stringResource(id = R.string.note),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, bottom = 30.dp)
                    .height(150.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),

                manager = manager,
                painter = painterResource(R.drawable.note_icon),
            )
        }

    }

}


fun verifyAndCreateCandidate(

    firstName: String,
    lastName:String,
    email: String,
    salary: String,
    phone:String,
    date:String,
    note: String,
    snackbarHostState: SnackbarHostState,
    scope: CoroutineScope,
    context: Context
): Boolean
{
    if (lastName.isBlank() ||
        firstName.isBlank() ||
        email.isBlank() ||
        salary.isBlank() ||
        phone.isBlank() ||
        date.isBlank() || note
            .isBlank()) {
        scope.launch {
            snackbarHostState.showSnackbar(context.getString(R.string.issue_name_empty))
        }

        return false;
    }
    return true
}
