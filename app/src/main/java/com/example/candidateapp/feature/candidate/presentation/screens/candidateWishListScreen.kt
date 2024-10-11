package com.example.candidateapp.feature.candidate.presentation.screens




import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.candidateapp.feature.candidate.domain.entities.CandidateEntity
import com.example.candidateapp.feature.candidate.presentation.widgets.Candidate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  CandidateWishListScreen() {

    val wishList= listOf<CandidateEntity>( CandidateEntity(1,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",),
        CandidateEntity(1,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",),
        CandidateEntity(2,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",),
        CandidateEntity(3,"Bamba","Moussa","email@gmail;com","0605599077","16-01-1998","10000","5 ans d'expérience en développement mobile, avec une expertise dans les environnements Android et iOS. Jean a travaillé sur plusieurs applications mobiles, allant de petites startups à des applications à grande échelle utilisées par des milliers d'utilisateurs",)
    )
    LazyColumn( ) {
        items(wishList) { candidat ->
            Candidate(candidat = candidat)

        }
    }
}

