package low_level_designs.spotify.strategy


import low_level_designs.spotify.model.Playlist
import low_level_designs.spotify.model.Song
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

class CustomQueueStrategy : PlayStrategy {

    private var currentPlaylist: Playlist? = null
    private var currentIndex = -1

    private val nextQueue: Queue<Song> = LinkedList()
    private val prevStack = Stack<Song>()

    private fun nextSequential(): Song {
        val playlist = currentPlaylist
            ?: throw IllegalStateException("Playlist is empty.")

        if (playlist.songs.isEmpty()) {
            throw IllegalStateException("Playlist is empty.")
        }

        currentIndex++
        return playlist.songs[currentIndex]
    }

    private fun previousSequential(): Song {
        val playlist = currentPlaylist
            ?: throw IllegalStateException("Playlist is empty.")

        if (playlist.songs.isEmpty()) {
            throw IllegalStateException("Playlist is empty.")
        }

        currentIndex--
        return playlist.songs[currentIndex]
    }

    override fun setPlaylist(playlist: Playlist) {
        currentPlaylist = playlist
        currentIndex = -1

        nextQueue.clear()
        prevStack.clear()
    }

    override fun hasNext(): Boolean {
        val playlist = currentPlaylist ?: return false

        return nextQueue.isNotEmpty() ||
                (currentIndex + 1 < playlist.songs.size)
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

        if (nextQueue.isNotEmpty()) {
            val song = nextQueue.remove()
            prevStack.push(song)

            currentIndex = playlist.songs.indexOf(song)

            return song
        }

        return nextSequential()
    }

    override fun hasPrevious(): Boolean {
        return prevStack.isNotEmpty() || currentIndex - 1 >= 0
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

        if (prevStack.isNotEmpty()) {
            val song = prevStack.pop()

            currentIndex = playlist.songs.indexOf(song)

            return song
        }

        return previousSequential()
    }

    override fun addToNext(song: Song) {
        nextQueue.add(song)
    }
}