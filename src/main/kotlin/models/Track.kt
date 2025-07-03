package com.example.models
import kotlinx.serialization.Serializable

@Serializable
data class Track(var id: Int, val name: String, val bpm:Int)
