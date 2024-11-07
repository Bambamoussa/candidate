package com.example.candidateapp.core.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.candidateapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutLineTextField(
    value:String,
    painter: Painter? = null,
    modifier:Modifier?=null,
    onValueChange:(String)->Unit,
    label:String,
    keyboardOptions: KeyboardOptions,
    manager: FocusManager
){


    Row(

        verticalAlignment = Alignment.CenterVertically, // Aligne verticalement au centre
          ) {
        val space=   if (painter != null)  2 else  52
        if (painter != null) {
            Image(
                painter=painter, // Remplacez par votre icône
                contentDescription = "Icon",
                modifier = Modifier.size(48.dp),

            )

        }
        Spacer(modifier = Modifier.width(space.dp))
        OutlinedTextField(
            value =value ,
            modifier = modifier ?: Modifier.fillMaxWidth().padding(  end = 8.dp, bottom = 30.dp),
            onValueChange = onValueChange,
            label = { Text(text = label, ) },

            keyboardOptions = keyboardOptions,
            colors  = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                disabledBorderColor = Color.Gray,
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Gray,


            ),
            keyboardActions = KeyboardActions(
                onDone  = {
                    manager.clearFocus()

                }
            )

        )


    }
}