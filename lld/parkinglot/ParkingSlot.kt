package lld.parkinglot

data class ParkingSlot(
    val slotNumber: Int,
    val vehicleType: VehicleType,
){
    private var vehicle: Vehicle? = null

    fun parkVehicle(vehicle: Vehicle) {
        this.vehicle = vehicle
    }

    fun isAvailable(): Boolean {
        return vehicle == null
    }

    fun freeSlot() {
        this.vehicle = null
    }
}