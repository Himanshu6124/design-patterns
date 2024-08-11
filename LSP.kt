import java.util.logging.Logger

open class Rectangle {

    open var width = 0.0
    open var height = 0.0

    open fun setWidths(width: Double) {
        this.width = width
    }

    open fun setHeights(height: Double) {
        this.height = height
    }

    fun calculateArea() {
        val area = width * height
        println("Area is $area")
    }
}


class Square : Rectangle() {

//    override var width: Double
//        get() = super.width
//        set(value) {
//            print("setting value")
//            super.width = value
//            super.height = value
//        }
//
//    override var height: Double
//        get() = super.height
//        set(value) {
//            super.width = value
//            super.height = value
//        }

    override fun setWidths(width: Double) {
        this.width = width
        this.height = width
    }

    override fun setHeights(height: Double) {
        this.width = height
        this.height = height
    }

}


fun main() {

    val rect: Rectangle = Square()  /* according to LSP it should behave like rectangle and produce output 50, but it will produce output 100 */
    rect.setWidths(5.0)
    rect.setHeights(10.0)
    rect.calculateArea()
}