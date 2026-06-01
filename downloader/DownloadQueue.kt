package downloader

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DownloadQueue(
    private val scope: CoroutineScope,
    private val downloader: DownloadManager,
    private val listener: DownloadListener
) {

    private val queue: ArrayDeque<DownloadRequest> = ArrayDeque()
    private var isDownloading = false

    fun add(task: DownloadRequest) {
        queue.add(task)
        processQueue()
    }

    private fun processQueue() {
        if (isDownloading) return

        val task = queue.removeFirstOrNull() ?: return
        isDownloading = true

        scope.launch {
            downloader.download(scope,task, listener)
            isDownloading = false
            processQueue() // next task
        }
    }
}