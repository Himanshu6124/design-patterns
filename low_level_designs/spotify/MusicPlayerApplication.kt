package low_level_designs.spotify

import low_level_designs.spotify.enums.DeviceType
import low_level_designs.spotify.enums.PlayStrategyType
import low_level_designs.spotify.manager.PlaylistManager
import low_level_designs.spotify.model.Song

object MusicPlayerApplication {

    private val songLibrary = mutableListOf<Song>()

    fun createSongInLibrary(
        title: String,
        artist: String,
        path: String
    ) {
        val song = Song(
            title = title,
            artist = artist,
            filePath = path
        )

        songLibrary.add(song)
    }

    fun findSongByTitle(title: String): Song? {
        return songLibrary.find { it.title == title }
    }

    fun createPlaylist(playlistName: String) {
        PlaylistManager.getInstance().createPlaylist(playlistName)
    }

    fun addSongToPlaylist(
        playlistName: String,
        songTitle: String
    ) {
        val song = findSongByTitle(songTitle)
            ?: throw IllegalArgumentException(
                "Song \"$songTitle\" not found in library."
            )

        PlaylistManager.getInstance().addSongToPlaylist(
            playlistName = playlistName,
            song = song
        )
    }

    fun connectAudioDevice(deviceType: DeviceType) {
        MusicPlayerFacade.getInstance().connectDevice(deviceType)
    }

    fun selectPlayStrategy(
        strategyType: PlayStrategyType
    ) {
        MusicPlayerFacade.getInstance().setPlayStrategy(strategyType)
    }

    fun loadPlaylist(playlistName: String) {
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName)
    }

    fun playSingleSong(songTitle: String) {
        val song = findSongByTitle(songTitle)
            ?: throw IllegalArgumentException(
                "Song \"$songTitle\" not found."
            )

        MusicPlayerFacade.getInstance().playSong(song)
    }

    fun pauseCurrentSong(songTitle: String) {
        val song = findSongByTitle(songTitle)
            ?: throw IllegalArgumentException(
                "Song \"$songTitle\" not found."
            )

        MusicPlayerFacade.getInstance().pauseSong(song)
    }

    fun playAllTracksInPlaylist() {
        MusicPlayerFacade.getInstance().playAllTracks()
    }

    fun playNextTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playNextTrack()
    }

    fun playPreviousTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playPreviousTrack()
    }

    fun queueSongNext(songTitle: String) {
        val song = findSongByTitle(songTitle)
            ?: throw IllegalArgumentException(
                "Song \"$songTitle\" not found."
            )

        MusicPlayerFacade.getInstance().enqueueNext(song)
    }
}


fun main() {
    try {
        // Populate library
        MusicPlayerApplication.createSongInLibrary(
            "Kesariya",
            "Arijit Singh",
            "/music/kesariya.mp3"
        )

        MusicPlayerApplication.createSongInLibrary(
            "Chaiyya Chaiyya",
            "Sukhwinder Singh",
            "/music/chaiyya_chaiyya.mp3"
        )

        MusicPlayerApplication.createSongInLibrary(
            "Tum Hi Ho",
            "Arijit Singh",
            "/music/tum_hi_ho.mp3"
        )

        MusicPlayerApplication.createSongInLibrary(
            "Jai Ho",
            "A. R. Rahman",
            "/music/jai_ho.mp3"
        )

        MusicPlayerApplication.createSongInLibrary(
            "Zinda",
            "Siddharth Mahadevan",
            "/music/zinda.mp3"
        )

        // Create playlist and add songs
        MusicPlayerApplication.createPlaylist("Bollywood Vibes")

        MusicPlayerApplication.addSongToPlaylist(
            "Bollywood Vibes",
            "Kesariya"
        )

        MusicPlayerApplication.addSongToPlaylist(
            "Bollywood Vibes",
            "Chaiyya Chaiyya"
        )

        MusicPlayerApplication.addSongToPlaylist(
            "Bollywood Vibes",
            "Tum Hi Ho"
        )

        MusicPlayerApplication.addSongToPlaylist(
            "Bollywood Vibes",
            "Jai Ho"
        )

        // Connect device
        MusicPlayerApplication.connectAudioDevice(
            DeviceType.BLUETOOTH
        )

        // Play/Pause a single song
        MusicPlayerApplication.playSingleSong("Zinda")
        MusicPlayerApplication.pauseCurrentSong("Zinda")
        MusicPlayerApplication.playSingleSong("Zinda") // Resume

        println("\n-- Sequential Playback --")

        MusicPlayerApplication.selectPlayStrategy(
            PlayStrategyType.SEQUENTIAL
        )

        MusicPlayerApplication.loadPlaylist(
            "Bollywood Vibes"
        )

        MusicPlayerApplication.playAllTracksInPlaylist()

        println("\n-- Random Playback --")

        MusicPlayerApplication.selectPlayStrategy(
            PlayStrategyType.RANDOM
        )

        MusicPlayerApplication.loadPlaylist(
            "Bollywood Vibes"
        )

        MusicPlayerApplication.playAllTracksInPlaylist()

        println("\n-- Custom Queue Playback --")

        MusicPlayerApplication.selectPlayStrategy(
            PlayStrategyType.CUSTOM_QUEUE
        )

        MusicPlayerApplication.loadPlaylist(
            "Bollywood Vibes"
        )

        MusicPlayerApplication.queueSongNext("Kesariya")
        MusicPlayerApplication.queueSongNext("Tum Hi Ho")

        MusicPlayerApplication.playAllTracksInPlaylist()

        println("\n-- Play Previous in Sequential --")

        MusicPlayerApplication.selectPlayStrategy(
            PlayStrategyType.SEQUENTIAL
        )

        MusicPlayerApplication.loadPlaylist(
            "Bollywood Vibes"
        )

        MusicPlayerApplication.playAllTracksInPlaylist()

        MusicPlayerApplication.playPreviousTrackInPlaylist()
        MusicPlayerApplication.playPreviousTrackInPlaylist()

    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}