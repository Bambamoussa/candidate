package com.example.candidateapp.feature.candidate.domain.entities

import androidx.room.ColumnInfo

data class CandidateEntity(
val id: Int,

val lastName: String,

val firstName: String,

val phone: String,

val empEmail: String,

val dateOfBirth: String,  // Représente un timestamp

val salaryClaim: String,

val information: String
)