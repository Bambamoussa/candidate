package com.example.candidateapp.feature.candidate.data.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "candidate")
data class Candidate(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "email")
    val empEmail: String,
    @ColumnInfo(name = "dateOfBirth")
    val dateOfBirth: Date,
    @ColumnInfo(name = "salaryClaim")
    val salaryClaim: Double,
    @ColumnInfo(name = "information")
    val information: Double,

)