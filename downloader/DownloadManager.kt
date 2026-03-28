package downloader

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DownloadManager {
    fun download(
        scope : CoroutineScope,
        request: DownloadRequest,
        listener: DownloadListener
    ) {
        try {
            request.status = Status.PENDING
            for (i in 1..100 step 10) {
                Thread.sleep(1000) // simulate network
                listener.onProgress(request.id, i)
            }

            request.status = Status.COMPLETED
            listener.onSuccess(request.id)

        } catch (e: Exception) {
            request.status = Status.FAILED
            listener.onError(request.id, e.message ?: "Error")
        }
    }
}



fun main() {
    val downloadManager = DownloadManager()
    val scope = CoroutineScope(Dispatchers.IO)
    val request = DownloadRequest(
        id = "1",
        url = "http://example.com/file.zip",
        status = Status.PENDING
    )
    downloadManager.download(scope, request, object : DownloadListener{
        override fun onProgress(id: String, progress: Int) {
            println("Downloading... $progress%")
        }

        override fun onSuccess(id: String) {
            println("Download completed")
        }

        override fun onError(id: String, error: String) {
            println("Download failed: $error")
        }
    })
}