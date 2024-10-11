package com.example.candidateapp.feature.candidate.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.candidateapp.R
import com.example.candidateapp.feature.candidate.domain.entities.CandidateEntity
import java.text.DecimalFormat



@Composable
  fun Candidate(
  candidat: CandidateEntity

) {
    val df = DecimalFormat().apply {
        maximumFractionDigits = 2
    }

    Row(
        modifier = Modifier

            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(54.dp)
                .height(54.dp),
            painter = painterResource( R.drawable.candidate),
            contentDescription  = null
        )
        Column(
            modifier = Modifier.padding(start = 16.dp),
        ) {
            Text(
                text =  "${candidat.lastName} ${candidat.firstName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                overflow =  TextOverflow.Ellipsis,
                maxLines= 2,
                text = candidat.information,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
