package low_level_designs.spotify.strategy


import low_level_designs.spotify.model.Playlist
import low_level_designs.spotify.model.Song
import java.util.Stack
import kotlin.random.Random

class RandomPlayStrategy : PlayStrategy {

    private var currentPlaylist: Playlist? = null
    private val remainingSongs = mutableListOf<Song>()
    private val history = Stack<Song>()

    override fun setPlaylist(playlist: Playlist) {
        currentPlaylist = playlist

        remainingSongs.clear()
        remainingSongs.addAll(playlist.songs)

        history.clear()
    }

    override fun hasNext(): Boolean {
        return currentPlaylist != null && remainingSongs.isNotEmpty()
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

        if (remainingSongs.isEmpty()) {
            throw IllegalStateException(
                "No songs left to play."
            )
        }

        val idx = Random.nextInt(remainingSongs.size)

        val selectedSong = remainingSongs[idx]

        // Swap with last and remove (similar to C++ swap + pop_back)
        remainingSongs[idx] = remainingSongs.last()
        remainingSongs.removeAt(remainingSongs.lastIndex)

        history.push(selectedSong)

        return selectedSong
    }

    override fun hasPrevious(): Boolean {
        return history.isNotEmpty()
    }

    override fun previous(): Song {
        if (history.isEmpty()) {
            throw IllegalStateException(
                "No previous song available."
            )
        }

        return history.pop()
    }
}