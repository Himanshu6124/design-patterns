/* At its core, the Factory Pattern is a creational design pattern that abstracts 
* the process ofobject creation. It allows you to create objects without specifying 
* their exact types, delegating the responsibility to subclasses or specialized factory classes.
* This abstraction promotes flexibility and code maintainability. */

abstract class Employee{
    abstract fun printEmployeeName()
}

class AndroidDeveloper : Employee() {
    override fun printEmployeeName() {
        println("I am android developer")
    }
}

class WebDeveloper : Employee() {
    override fun printEmployeeName() {
        println("I am web developer")
    }
}

abstract class EmployeeFactory{
     abstract fun createEmployee() : Employee
}


class AndroidDeveloperFactory : EmployeeFactory() {
    override fun createEmployee() : Employee {
        return AndroidDeveloper()
    }
}
class WebDeveloperFactory : EmployeeFactory() {
    override fun createEmployee() : Employee {
        return WebDeveloper()
    }
}

class CreateEmployeeFactory(private val employeeFactory: EmployeeFactory){

    fun createEmployee() : Employee {
       return employeeFactory.createEmployee()
    }
}


//class EmployeeFactory(private val type : String){
//
//    fun createEmployee() : Employee?{
//        if(type == "Android") return AndroidDeveloper()
//        else if(type == "Web") return WebDeveloper()
//        return null
//    }
//
//}


fun main(){

    // without factory pattern
//    val developer : Employee = AndroidDeveloper()
//    println(developer.printEmployeeName())

    // with factory pattern
//    val empFactory = EmployeeFactory("Web")
//    val createEmp = empFactory.createEmployee()
//    createEmp?.printEmployeeName()

    // with abstract factory pattern
    val androidFactory = AndroidDeveloperFactory()
    val employeeFactory = CreateEmployeeFactory(androidFactory)

    val emp = employeeFactory.createEmployee()
    emp.printEmployeeName()


}
