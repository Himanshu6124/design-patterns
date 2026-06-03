package low_level_designs.spotify.device

import low_level_designs.spotify.external.WiredSpeakerApi
import low_level_designs.spotify.model.Song

class WiredSpeakerAdapter(
    private val wiredSpeakerApi: WiredSpeakerApi
) : AudioOutputDevice {
    override fun playAudio(song: Song) {
        wiredSpeakerApi.playViaWired()
    }
}