package low_level_designs.spotify.strategy

import low_level_designs.spotify.model.Playlist
import low_level_designs.spotify.model.Song

interface PlayStrategy {

    fun setPlaylist(playlist: Playlist)

    fun next(): Song

    fun hasNext(): Boolean

    fun previous(): Song

    fun hasPrevious(): Boolean

    fun addToNext(song: Song) {
        // default implementation
    }
}