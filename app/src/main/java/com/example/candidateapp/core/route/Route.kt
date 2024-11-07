package com.example.candidateapp.core.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Route(val route: String,

                   val navArguments: List<NamedNavArgument> = emptyList()
                   ){

    object  HomeScreen : Route (route =  "homeScreen")
    object  AddCandidateSceen : Route (route =  "addCandidateScreen")
    object  CandidateInformationScreen : Route (route =  "candidatInformationScreen"){

    }
    object  ListOfCandidateScreen : Route (route =  "listOfCandidateScreen",

        )

    object  EditCandidateScreen : Route (route =  "editCandidateScreen",

        )
    object  CandidateWish : Route (route =  "candidateWish")


}