package com.example.candidateapp.feature.candidate.presentation.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.candidateapp.feature.candidate.data.models.Candidate
import com.example.candidateapp.feature.candidate.presentation.screens.CandidateListScreen
import com.example.candidateapp.feature.candidate.presentation.screens.CandidateWishListScreen

@Composable
fun TabView(
    onClick: (Candidate) -> Unit
) {
    val tabs = listOf(
         "Tous","Favoris"
    )
    var selectedTabIndex by remember { mutableStateOf(0) }


    Column {

        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            edgePadding = 50.dp,

            contentColor = Color.Gray,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.Black,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .fillMaxWidth()
                )
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    modifier = Modifier.width(150.dp),
                    content = {

                            Text(
                                text = tab,
                                modifier = Modifier
                                    .padding(8.dp),
                                color = if (selectedTabIndex == index) Color.Black else Color.Gray
                            )

                    }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> {
                 CandidateListScreen(onClick = onClick)
            }
            1 -> {
                CandidateWishListScreen(onClick=onClick)
            }

        }
    }
}
