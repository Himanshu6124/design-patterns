package low_level_designs.spotify.strategy

import low_level_designs.spotify.model.Playlist
import low_level_designs.spotify.model.Song

class SequentialPlayStrategy : PlayStrategy {

    private var currentPlaylist: Playlist? = null
    private var currentIndex = -1

    override fun setPlaylist(playlist: Playlist) {
        currentPlaylist = playlist
        currentIndex = -1
    }

    override fun hasNext(): Boolean {
        val playlist = currentPlaylist ?: return false
        return currentIndex + 1 < playlist.songs.size
    }

    override fun next(): Song {
        val playlist = currentPlaylist
            ?: throw IllegalStateException(
                "No playlist loaded or playlist is empty."
            )

        if (playlist.songs.isEmpty()) {
            throw IllegalStateException(
                "No playlist loaded or playlist is empty."
            )
        }

        currentIndex++
        return playlist.songs[currentIndex]
    }

    override fun hasPrevious(): Boolean {
        return currentIndex - 1 >= 0
    }

    override fun previous(): Song {
        val playlist = currentPlaylist
            ?: throw IllegalStateException(
                "No playlist loaded or playlist is empty."
            )

        if (playlist.songs.isEmpty()) {
            throw IllegalStateException(
                "No playlist loaded or playlist is empty."
            )
        }

        currentIndex--
        return playlist.songs[currentIndex]
    }
}