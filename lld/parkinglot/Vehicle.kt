package lld.parkinglot


enum class VehicleType{
    CAR, BIKE
}
abstract class Vehicle(
    val licensePlate: String,
    val vehicleType: VehicleType
)

class Car(licensePlate: String) : Vehicle(licensePlate, VehicleType.CAR)

class Bike(licensePlate: String) : Vehicle(licensePlate, VehicleType.BIKE)
