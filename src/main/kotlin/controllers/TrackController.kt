package com.example.controllers
import com.example.models.Track

object TrackController {
    private val tracks = mutableListOf<Track>()

    fun getAll(): List<Track> = tracks

    fun addTrack(track: Track): Track {
        val newTrack = Track(tracks.size + 1, track.name, track.bpm)
        tracks.add(newTrack)
        return newTrack
    }

    fun updateTrack(id: Int, track: Track): Track? {
        val index = tracks.indexOfFirst { it.id == id }
        return if (index != -1) {
            tracks[index] = Track(id, track.name, track.bpm)
            tracks[index]
        } else null
    }

    fun deleteTrack(id: Int): Track? {
        val index = tracks.indexOfFirst { it.id == id }
        return if (index != -1) {
            tracks.removeAt(index)
        } else null
    }
}
