package low_level_designs.tinder.model

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

data class Location(
    var latitude: Double = 0.0,
    var longitude: Double = 0.0
) {

    fun distanceInKm(other: Location): Double {
        val earthRadiusKm = 6371.0

        val dLat = Math.toRadians(other.latitude - latitude)
        val dLon = Math.toRadians(other.longitude - longitude)

        val a =
            sin(dLat / 2) * sin(dLat / 2) +
                    cos(Math.toRadians(latitude)) *
                    cos(Math.toRadians(other.latitude)) *
                    sin(dLon / 2) *
                    sin(dLon / 2)

        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return earthRadiusKm * c
    }
}