package patterns
interface Builder{
    fun buildCPU()
    fun buildRAM()
    fun buildHDD()
    fun getComputer() : Computer
}

class Computer {
    private var ram  : Int = 0
    private var hdd  : Int = 0
    private var cpu : Int = 0

    fun setRAM(ram : Int) {
        this.ram = ram
    }

    fun setHDD(hdd : Int) {
        this.hdd = hdd
    }

    fun setCPU(cpu : Int) {
        this.cpu = cpu
    }

    fun printSpec(){
        println("RAM $ram HDD $hdd CPU $cpu")
    }
}

class GamingComputerBuilder : Builder {
    private var computer = Computer()

    override fun buildCPU() {
        computer.setCPU(200000)
    }

    override fun buildRAM() {
        computer.setRAM(12)
    }

    override fun buildHDD() {
        computer.setHDD(2000)
    }

    override fun getComputer() : Computer {
        return computer
    }
}

class ComputerDirector{

    fun build(builder : Builder){
        builder.buildCPU()
        builder.buildHDD()
        builder.buildRAM()
    }
}


//fun main(){
//
//    val gamingComputerBuilder = GamingComputerBuilder()
//    ComputerDirector().build(gamingComputerBuilder)
//    val computer = gamingComputerBuilder.getComputer()
//    computer.printSpec()
//
//}