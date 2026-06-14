package low_level_designs.tinder.model

import low_level_designs.tinder.enums.Gender

class Preference {

    private val interestedIn = mutableListOf<Gender>()
    private val interests = mutableListOf<String>()

    var minAge: Int = 18
    var maxAge: Int = 100
    var maxDistance: Double = 100.0

    fun addGenderPreference(gender: Gender) {
        interestedIn.add(gender)
    }

    fun removeGenderPreference(gender: Gender) {
        interestedIn.remove(gender)
    }

    fun setAgeRange(min: Int, max: Int) {
        minAge = min
        maxAge = max
    }

    fun addInterest(interest: String) {
        interests.add(interest)
    }

    fun removeInterest(interest: String) {
        interests.remove(interest)
    }

    fun isInterestedInGender(gender: Gender): Boolean {
        return interestedIn.contains(gender)
    }

    fun isAgeInRange(age: Int): Boolean {
        return age in minAge..maxAge
    }

    fun isDistanceAcceptable(distance: Double): Boolean {
        return distance <= maxDistance
    }

    fun getInterests(): List<String> = interests

    fun getInterestedGenders(): List<Gender> = interestedIn
}