package low_level_designs.spotify.manager

import low_level_designs.spotify.device.AudioOutputDevice
import low_level_designs.spotify.enums.DeviceType
import low_level_designs.spotify.factory.DeviceFactory

class DeviceManager private constructor() {

    private var currentOutputDevice: AudioOutputDevice? = null


    fun connect(deviceType: DeviceType) {
        currentOutputDevice = DeviceFactory.createDevice(deviceType)

        when (deviceType) {
            DeviceType.BLUETOOTH ->
                println("Bluetooth device connected")

            DeviceType.WIRED ->
                println("Wired device connected")

        }
    }

        fun getOutputDevice(): AudioOutputDevice {
            return currentOutputDevice
                ?: throw IllegalStateException("No output device is connected.")
        }

        fun hasOutputDevice(): Boolean {
            return currentOutputDevice != null
        }

    companion object {
        @Volatile
        private var instance: DeviceManager? = null

        fun getInstance(): DeviceManager {
            return instance ?: synchronized(this) {
                instance ?: DeviceManager().also { instance = it }
            }
        }
    }

}