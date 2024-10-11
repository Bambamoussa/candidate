package com.example.candidateapp.feature.candidate.presentation.screens



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.candidateapp.R
import com.example.candidateapp.core.common.CustomAppBar
import com.example.candidateapp.core.common.CustomOutLineTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  AddCandidateSceen( ) {
    var lastName by rememberSaveable { mutableStateOf("") }
    var firstName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }

    var salairy by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var kilos by rememberSaveable { mutableStateOf(0) }
    var result by rememberSaveable { mutableStateOf(0) }
    val listCompte = listOf<String>("Sédentaire","Faible", "Actif","Sportif", "Athlete")

    val manager = LocalFocusManager.current

    Scaffold(

    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ){

            Column(
                modifier = Modifier
                    .padding(paddingValues),

                ) {
                val modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()


                CustomOutLineTextField(

                    value = lastName,
                    onValueChange = { lastName = it },
                    label = stringResource(id = R.string.last_name),
                    modifier = modifier,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    icon =  Icon(imageVector = Icons.Default.Person,contentDescription = null) ,
                    manager = manager
                )
                CustomOutLineTextField(

                value = firstName,
                onValueChange = { firstName = it },
                label = stringResource(id = R.string.last_name),
                modifier = modifier,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                icon =  Icon(imageVector = Icons.Default.Person,contentDescription = null) ,
                manager = manager
                )
            }

            }
    }
}

