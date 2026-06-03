package low_level_designs.spotify.model

data class Playlist(
    var playlistName: String,
    val songs: MutableList<Song> = mutableListOf()
) {

    fun addSongToPlaylist(song: Song) {
        songs.add(song)
    }
}