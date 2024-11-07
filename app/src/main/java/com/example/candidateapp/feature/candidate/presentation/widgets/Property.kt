package com.example.candidateapp.feature.candidate.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Property(painter: Painter, text:String){
    Column() {
        Image(
            modifier= Modifier.size(48.dp),
            painter = painter,
            contentDescription = null
        )
        Text(text =text )
    }
}