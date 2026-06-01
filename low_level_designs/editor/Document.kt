package low_level_designs.editor

class Document {
    val contents: ArrayList<Content> = arrayListOf()

    fun addContent(content: Content){
        contents.add(content)
    }

    fun removeContent(content: Content){
        contents.remove(content)
    }

    fun renderDocument() {
        contents.forEach {
            it.render()
        }
    }
}