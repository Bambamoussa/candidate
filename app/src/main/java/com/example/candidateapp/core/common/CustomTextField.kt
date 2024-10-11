package com.example.candidateapp.core.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutLineTextField(
    value:String,
    icon: Unit,
    onValueChange:(String)->Unit,
    label:String, modifier: Modifier,
    keyboardOptions: KeyboardOptions,
    manager: FocusManager
){


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp), // Ajout de marges autour de la Row
        verticalAlignment = Alignment.CenterVertically ) {

           icon

        OutlinedTextField(
            value =value ,

            onValueChange = onValueChange,
            label = { Text(text = label, ) },
            modifier = modifier,
            keyboardOptions = keyboardOptions,
            colors  = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray
            ),
            keyboardActions = KeyboardActions(
                onDone  = {
                    manager.clearFocus()
                }
            )

        )

    }
}