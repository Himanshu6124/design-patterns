package low_level_designs.spotify.manager

import low_level_designs.spotify.model.Playlist
import low_level_designs.spotify.model.Song

class PlaylistManager private constructor() {

    private val playlists = mutableMapOf<String, Playlist>()

    companion object {
        @Volatile
        private var instance: PlaylistManager? = null

        fun getInstance(): PlaylistManager {
            return instance ?: synchronized(this) {
                instance ?: PlaylistManager().also {
                    instance = it
                }
            }
        }
    }

    fun createPlaylist(name: String) {
        if (playlists.containsKey(name)) {
            throw IllegalArgumentException("Playlist \"$name\" already exists.")
        }

        playlists[name] = Playlist(name)
    }

    fun addSongToPlaylist(
        playlistName: String,
        song: Song
    ) {
        val playlist = playlists[playlistName]
            ?: throw IllegalArgumentException(
                "Playlist \"$playlistName\" not found."
            )

        playlist.addSongToPlaylist(song)
    }

    fun getPlaylist(name: String): Playlist {
        return playlists[name]
            ?: throw IllegalArgumentException(
                "Playlist \"$name\" not found."
            )
    }
}