package com.example.candidateapp.feature.candidate.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.candidateapp.R

import com.example.candidateapp.feature.candidate.presentation.widgets.TabView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen( ) {

    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                containerColor = colorResource(id = R.color.search_color),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
        }

    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)){
            OutlinedTextField(
                shape = CircleShape ,
                trailingIcon = { IconButton(onClick = { /*TODO*/ }) { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                }},
                modifier = Modifier
                    .padding(20.dp)
                    .width(380.dp)
                    .height(56.dp),

                placeholder ={ Text(stringResource(id = R.string.search_candidate))},
                value = "",

                onValueChange = {},


                colors  = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = colorResource(id = R.color.search_color),
                    unfocusedBorderColor = Color.Gray
                ),


                )
            TabView()
        }



    }
}