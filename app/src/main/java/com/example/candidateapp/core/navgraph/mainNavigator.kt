package com.example.candidateapp.core.navgraph


import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.candidateapp.core.route.Route
import com.example.candidateapp.feature.candidate.presentation.screens.AddCandidateSceen
import com.example.candidateapp.feature.candidate.presentation.screens.CandidateListScreen
import com.example.candidateapp.feature.candidate.presentation.screens.CandidateWishListScreen
import com.example.candidateapp.feature.candidate.presentation.screens.HomeScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
     ) {


        NavHost(navController = navController, startDestination = Route.HomeScreen.route) {

            composable(route= Route.HomeScreen.route) {
                HomeScreen()
            }
            composable(route= Route.ListOfCandidateScreen.route) {
                CandidateListScreen()
            }
            composable(route= Route.AddCandidateSceen.route) {
                AddCandidateSceen()
            }
            composable(route= Route.CandidateWish.route) {
                CandidateWishListScreen()
            }

        }
    }
