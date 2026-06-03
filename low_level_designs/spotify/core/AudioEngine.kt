package low_level_designs.spotify.core

import low_level_designs.spotify.device.AudioOutputDevice
import low_level_designs.spotify.model.Song

class AudioEngine {
    private var currentSong: Song? = null
    private var songIsPaused: Boolean = false

    fun getCurrentSongTitle(): String {
        return currentSong?.title ?: ""
    }

    fun isPaused(): Boolean {
        return songIsPaused
    }

    fun play(
        audioOutputDevice: AudioOutputDevice,
        song: Song?
    ) {
        requireNotNull(song) {
            "Cannot play a null song."
        }

        // Resume if same song was paused
        if (songIsPaused && song == currentSong) {
            songIsPaused = false
            println("Resuming song: ${song.title}")
            audioOutputDevice.playAudio(song)
            return
        }

        currentSong = song
        songIsPaused = false

        println("Playing song: ${song.title}")
        audioOutputDevice.playAudio(song)
    }

    fun pause() {
        val song = currentSong
            ?: throw IllegalStateException("No song is currently playing to pause.")

        if (songIsPaused) {
            throw IllegalStateException("Song is already paused.")
        }

        songIsPaused = true
        println("Pausing song: ${song.title}")
    }
}