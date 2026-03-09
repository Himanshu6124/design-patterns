package lld.parkinglot

class ParkingManager(
    private val parkingLot: List<ParkingSlot>
) {

    fun parkVehicle(vehicle: Vehicle): Boolean {
        for (slot in parkingLot) {
            if (slot.isAvailable() && slot.vehicleType == vehicle.vehicleType) {
                slot.parkVehicle(vehicle)
                return true
            }
        }
        return false
    }
}

fun main() {
    val parkingLot =
        listOf(
            ParkingSlot(1, VehicleType.BIKE),
            ParkingSlot(2, VehicleType.CAR),
            ParkingSlot(3, VehicleType.BIKE)
        )

    val parkingManager = ParkingManager(parkingLot)
    val car1 = Car("KA-01-HH-1234")
    val car2 = Car("KA-02-HH-1234")

    val parked1 = parkingManager.parkVehicle(car1)
    println("Vehicle parked: $parked1")

    val parked2 = parkingManager.parkVehicle(car2)
    println("Vehicle parked: $parked2")
}