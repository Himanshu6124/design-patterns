package low_level_designs.editor

interface Persistence {
    fun save(document: Document)
}


 class SaveToDB : Persistence {
     override fun save(document: Document) {
         println("saving to Database ${document.contents}")
     }
 }

class SaveToFile : Persistence {
    override fun save(document: Document) {
        println("saving to file storage ${document.contents.size}")
    }
}