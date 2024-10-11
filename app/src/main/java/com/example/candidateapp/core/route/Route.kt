package com.example.candidateapp.core.route

sealed class Route(val route: String){

    object  HomeScreen : Route (route =  "homeScreen")
    object  AddCandidateSceen : Route (route =  "addCandidateScreen")
    object  ListOfCandidateScreen : Route (route =  "listOfCandidateScreen")
    object  CandidateWish : Route (route =  "candidateWish")


}