package low_level_designs.spotify.factory

import low_level_designs.spotify.device.AudioOutputDevice
import low_level_designs.spotify.device.BluetoothSpeakerAdapter
import low_level_designs.spotify.device.WiredSpeakerAdapter
import low_level_designs.spotify.enums.DeviceType
import low_level_designs.spotify.external.BluetoothSpeakerApi
import low_level_designs.spotify.external.WiredSpeakerApi

object DeviceFactory {

    fun createDevice(deviceType: DeviceType): AudioOutputDevice {
        return when (deviceType) {
            DeviceType.BLUETOOTH ->
                BluetoothSpeakerAdapter(BluetoothSpeakerApi())

            DeviceType.WIRED ->
                WiredSpeakerAdapter(WiredSpeakerApi())
        }
    }
}