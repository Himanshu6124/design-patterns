package low_level_designs.spotify.device

import low_level_designs.spotify.model.Song

interface AudioOutputDevice {
    fun playAudio(song: Song)
}