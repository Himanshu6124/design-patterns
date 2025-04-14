package interfaces

class DownloadCallback : DownloadListener {

    override fun onSuccess(data: String) {
        println("Success $data")
    }

    override fun onFailure(error: String) {
        println("Failure $error")
    }
}