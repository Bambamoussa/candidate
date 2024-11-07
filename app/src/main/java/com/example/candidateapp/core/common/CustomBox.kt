package com.example.candidateapp.core.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.candidateapp.R

@Composable
fun CustomBox(height: Int, function: () -> Unit){
    Box(

        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp, start = 8.dp)
            .height(height.dp)
            .border(
                2.dp,
                Color.Gray,
                shape = RoundedCornerShape(16.dp)
            ) // Bordure avec coins arrondis
            .clip(RoundedCornerShape(16.dp)) // Clip pour les coins arrondis
            .background(color = colorResource(id = R.color.search_color)) // Couleur de fond


    ) {


    }
}