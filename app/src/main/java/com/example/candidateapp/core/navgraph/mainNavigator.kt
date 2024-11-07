package com.example.candidateapp.core.navgraph


import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.candidateapp.core.route.Route
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.presentation.screens.AddCandidateSceen
import com.example.candidateapp.feature.candidate.presentation.screens.CandidatInformation
import com.example.candidateapp.feature.candidate.presentation.screens.CandidateListScreen
import com.example.candidateapp.feature.candidate.presentation.screens.CandidateWishListScreen
import com.example.candidateapp.feature.candidate.presentation.screens.HomeScreen
import com.example.candidateapp.feature.candidate.presentation.viewModels.CandidateViewModel

@SuppressLint("SuspiciousIndentation")
@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
     ) {
    lateinit var candidates: Candidate


        NavHost(navController = navController, startDestination = Route.HomeScreen.route) {

           composable(route= Route.HomeScreen.route,  ) {


               HomeScreen(
                   onClick = {
                           candidate ->
                       candidates = candidate
                       navController.navigate(route = Route.CandidateInformationScreen.route)
                   },
                    onFABClick = {
                    navController.navigate(Route.AddCandidateSceen.route)
                })
            }
            composable(route= Route.ListOfCandidateScreen.route) {
                CandidateListScreen(
                    onClick = {
                            candidate ->
                        candidates = candidate
                        navController.navigate(route = Route.CandidateInformationScreen.route)
                    }
                )
            }
            composable(route= Route.AddCandidateSceen.route) {

                AddCandidateSceen(
                    candidate = null,
                    onBackClick = { navController.navigateUp() },
                    onSaveClick = { navController.navigateUp() },


                    )
            }
            composable(route= Route.CandidateInformationScreen.route) {
                CandidatInformation(
                    onEditCandidatClick = {
                            candidate ->
                        candidates = candidate
                        navController.navigate(route = Route.EditCandidateScreen.route)

                    },
                    candidat = candidates,
                    onBackClick = {
                        navController.navigate(Route.HomeScreen.route)
                    },



                )

            }

            composable(route= Route.CandidateWish.route) {
                CandidateWishListScreen(
                    onClick = {
                            candidate ->
                        candidates = candidate
                        navController.navigate(route = Route.CandidateInformationScreen.route)
                    }
                )
            }

            composable(route= Route.EditCandidateScreen.route) {
                AddCandidateSceen(
                    candidate = candidates,
                    onBackClick = { navController.navigateUp() },
                    onSaveClick = { navController.navigate(route = Route.HomeScreen.route) },
                    )
            }

        }
    }
