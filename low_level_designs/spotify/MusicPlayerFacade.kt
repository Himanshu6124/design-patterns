package low_level_designs.spotify


import low_level_designs.spotify.core.AudioEngine
import low_level_designs.spotify.enums.DeviceType
import low_level_designs.spotify.enums.PlayStrategyType
import low_level_designs.spotify.manager.DeviceManager
import low_level_designs.spotify.manager.PlaylistManager
import low_level_designs.spotify.manager.StrategyManager
import low_level_designs.spotify.model.Playlist
import low_level_designs.spotify.model.Song
import low_level_designs.spotify.strategy.PlayStrategy

class MusicPlayerFacade {
    private val audioEngine = AudioEngine()
    private var loadedPlaylist: Playlist? = null
    private var playStrategy: PlayStrategy? = null

    fun connectDevice(deviceType: DeviceType) {
        DeviceManager.getInstance().connect(deviceType)
    }

    fun setPlayStrategy(strategyType: PlayStrategyType) {
        playStrategy = StrategyManager.getInstance().getStrategy(strategyType)
    }

    fun loadPlaylist(name: String) {
        loadedPlaylist = PlaylistManager.getInstance().getPlaylist(name)

        val strategy = playStrategy
            ?: throw IllegalStateException(
                "Play strategy not set before loading."
            )

        strategy.setPlaylist(loadedPlaylist!!)
    }

    fun playSong(song: Song) {
        if (!DeviceManager.getInstance().hasOutputDevice()) {
            throw IllegalStateException("No audio device connected.")
        }

        val device = DeviceManager.getInstance().getOutputDevice()
        audioEngine.play(device, song)
    }

    fun pauseSong(song: Song) {
        if (audioEngine.getCurrentSongTitle() != song.title) {
            throw IllegalStateException(
                "Cannot pause \"${song.title}\"; not currently playing."
            )
        }

        audioEngine.pause()
    }

    fun playAllTracks() {
        val playlist = loadedPlaylist
            ?: throw IllegalStateException("No playlist loaded.")

        val strategy = playStrategy
            ?: throw IllegalStateException("No play strategy set.")

        while (strategy.hasNext()) {
            val nextSong = strategy.next()

            val device = DeviceManager.getInstance().getOutputDevice()

            audioEngine.play(device, nextSong)
        }

        println("Completed playlist: ${playlist.playlistName}")
    }

    fun playNextTrack() {
        val playlist = loadedPlaylist
            ?: throw IllegalStateException("No playlist loaded.")

        val strategy = playStrategy
            ?: throw IllegalStateException("No play strategy set.")

        if (strategy.hasNext()) {
            val nextSong = strategy.next()

            val device = DeviceManager.getInstance().getOutputDevice()

            audioEngine.play(device, nextSong)
        } else {
            println("Completed playlist: ${playlist.playlistName}")
        }
    }

    fun playPreviousTrack() {
        val playlist = loadedPlaylist
            ?: throw IllegalStateException("No playlist loaded.")

        val strategy = playStrategy
            ?: throw IllegalStateException("No play strategy set.")

        if (strategy.hasPrevious()) {
            val prevSong = strategy.previous()

            val device = DeviceManager.getInstance().getOutputDevice()

            audioEngine.play(device, prevSong)
        } else {
            println("No previous track available.")
        }
    }

    fun enqueueNext(song: Song) {
        val strategy = playStrategy
            ?: throw IllegalStateException("No play strategy set.")

        strategy.addToNext(song)
    }

    companion object {
        @Volatile
        private var instance: MusicPlayerFacade? = null

        fun getInstance(): MusicPlayerFacade {
            return instance ?: synchronized(this) {
                instance ?: MusicPlayerFacade().also { instance = it }
            }
        }
    }
}