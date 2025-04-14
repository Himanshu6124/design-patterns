package interfaces

import kotlin.random.Random

class Downloader {

//    private var callback: DownloadListener? = null

    fun downloadData(callback: DownloadListener?) {
        val isSuccess = Random.nextBoolean()
        if (isSuccess) {
            callback?.onSuccess("Downloaded data")
        } else {
            callback?.onFailure("Download failed")
        }
    }

//    fun setCallBack(callback: DownloadListener){
//        this.callback = callback
//    }
}




fun main(){

    val downloader = Downloader()
//    downloader.setCallBack(DownloadCallback())
    downloader.downloadData(DownloadCallback())
}