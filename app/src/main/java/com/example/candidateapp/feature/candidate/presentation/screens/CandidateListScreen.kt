package com.example.candidateapp.feature.candidate.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.candidateapp.feature.candidate.domain.entities.CandidateEntity
import com.example.candidateapp.feature.candidate.presentation.widgets.Candidate

import com.example.candidateapp.feature.candidate.presentation.widgets.TabView


@Composable
fun CandidateListScreen( ) {
  val candidats= listOf<CandidateEntity>( CandidateEntity(1,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",),
   CandidateEntity(1,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",),
   CandidateEntity(2,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",),
   CandidateEntity(3,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",)
   )
 LazyColumn( ) {
  items(candidats) { candidat ->
     Candidate(candidat = candidat)

  }
 }

}