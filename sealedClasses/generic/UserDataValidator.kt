package sealedClasses.generic


class UserDataValidator {

    fun validatePassword(password: String): Result<Unit, PasswordError> {
        if (password.length < 9) {
            return Result.Error(PasswordError.TOO_SHORT)
        }

        val hasUppercaseChar = password.any { it.isUpperCase() }
        if (!hasUppercaseChar) {
            return Result.Error(PasswordError.NO_UPPERCASE)
        }

        val hasDigit = password.any { it.isDigit() }
        if (!hasDigit) {
            return Result.Error(PasswordError.NO_DIGIT)
        }

        return Result.Success(Unit)
    }

    enum class PasswordError : Error {
        TOO_SHORT,
        NO_UPPERCASE,
        NO_DIGIT
    }
}

fun onRegisterClick(password: String) {
    val userDataValidator = UserDataValidator()
    when (val result = userDataValidator.validatePassword(password)) {
        is Result.Error -> {
            when (result.error) {
                UserDataValidator.PasswordError.TOO_SHORT -> {
                    println("Password is too short")
                }
                UserDataValidator.PasswordError.NO_UPPERCASE -> {
                    println("Password must contain at least one uppercase letter")
                }
                UserDataValidator.PasswordError.NO_DIGIT -> {
                    println("Password must contain at least one digit")
                }
            }
        }

        is Result.Success -> {
            println("Password is valid")
        }
    }
}

fun main() {
    onRegisterClick("pC2asswordsss")
}



typealias RootError = Error

sealed interface Result<out D, out E: RootError> {
    data class Success<out D, out E: RootError>(val data: D): Result<D, E>
    data class Error<out D, out E: RootError>(val error: E): Result<D, E>
}