package low_level_designs.editor

interface Content {
    fun render()
}


class TextContent(val text: String) : Content {
    override fun render() {
        println("rendering text $text")
    }
}

class NumberContent(val num: Int) : Content {
    override fun render() {
        println("rendering number $num")
    }
}

class ImageContent(val path: String) : Content {
    override fun render() {
        println("rendering image $path")
    }
}


class DocumentEditor(
    private val document: Document,
    val persistence: Persistence,
    ) {

    fun addContent(content: Content) {
        document.addContent(content)
    }

    fun removeContent(content: Content){
        document.removeContent(content )
    }

    fun renderDocument() {
        document.renderDocument()
    }

    fun saveDocument(){
        persistence.save(document)
    }
}


fun main() {

    val document = Document()

    val editor = DocumentEditor(
        document = document,
        persistence = SaveToFile()
    )

    editor.addContent(TextContent("himanshu"))
    editor.addContent(ImageContent("/image"))
    editor.saveDocument()

    editor.addContent(NumberContent(12))
    editor.saveDocument()


    editor.renderDocument()
}