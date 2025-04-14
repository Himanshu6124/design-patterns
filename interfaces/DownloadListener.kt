package interfaces

interface DownloadListener {
    fun onSuccess(data: String)
    fun onFailure(error: String)
}
