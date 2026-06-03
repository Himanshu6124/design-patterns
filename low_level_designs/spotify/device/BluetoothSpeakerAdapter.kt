package low_level_designs.spotify.device

import low_level_designs.spotify.external.BluetoothSpeakerApi
import low_level_designs.spotify.model.Song

class BluetoothSpeakerAdapter(
    private val bluetoothSpeakerApi: BluetoothSpeakerApi
) : AudioOutputDevice {
    override fun playAudio(song: Song) {
        bluetoothSpeakerApi.playViaBluetooth()
    }
}