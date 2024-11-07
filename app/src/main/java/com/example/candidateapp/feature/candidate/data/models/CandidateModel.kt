package com.example.candidateapp.feature.candidate.data.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "candidate")
data class Candidate(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "lastName")
    val lastName: String,

    @ColumnInfo(name = "firstName")
    val firstName: String,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean = false,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "dateOfBirth")
    val dateOfBirth: String,  // Représente un timestamp

    @ColumnInfo(name = "salaryClaim")
    val salaryClaim: String,

    @ColumnInfo(name = "information")
    val information: String  // Changé en String pour éviter les erreurs
)
