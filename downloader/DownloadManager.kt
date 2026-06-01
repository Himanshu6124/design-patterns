package downloader

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DownloadManager(
    private val scope: CoroutineScope,
    private val listener: DownloadListener
) {

//    private val queue = DownloadQueue(scope, listener)
    fun download(
        scope : CoroutineScope,
        request: DownloadRequest,
        listener: DownloadListener
    ) {
//        queue.add(request)
    }
}



fun main() {
//    val downloadManager = DownloadManager()
    val scope = CoroutineScope(Dispatchers.IO)
    val request = DownloadRequest(
        id = "1",
        url = "http://example.com/file.zip",
        status = Status.PENDING
    )
//    downloadManager.download(scope, request, object : DownloadListener{
//        override fun onProgress(id: String, progress: Int) {
//            println("Downloading... $progress%")
//        }
//
//        override fun onSuccess(id: String) {
//            println("Download completed")
//        }
//
//        override fun onError(id: String, error: String) {
//            println("Download failed: $error")
//        }
//    })
}