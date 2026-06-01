package di

import di.DIContainer.resolve

object DIContainer {

    private val providers = mutableMapOf<Class<*>, () -> Any>()

    fun <T : Any> register(
        clazz: Class<T>,
        provider: () -> T
    ) {
        providers[clazz] = provider
    }

    fun <T : Any> resolve(clazz: Class<T>): T {
        val provider = providers[clazz]
            ?: throw IllegalArgumentException("No provider for ${clazz.simpleName}")

        return provider.invoke() as T
    }
}

interface UserRepository {
    fun getUser(): String
}

class ApiUserRepository : UserRepository {
    override fun getUser() = "User from API"
}

fun registerModules() {
    DIContainer.register(UserRepository::class.java) {
        ApiUserRepository()
    }
}

@Target(AnnotationTarget.CONSTRUCTOR)
annotation class Inject

fun <T : Any> create(clazz: Class<T>): T {

    val constructor = clazz.constructors.firstOrNull {
        it.isAnnotationPresent(Inject::class.java)
    } ?: throw IllegalArgumentException("No @Inject constructor")

    val params = constructor.parameterTypes.map {
        resolve(it)
    }.toTypedArray()

    return constructor.newInstance(*params) as T
}

class UserViewModel @Inject constructor(
    private val repo: UserRepository
){

    fun getUser() {
        val res = repo.getUser()
        println("User is $res")
    }

}

fun main(){
    registerModules()
    val viewModel = create(UserViewModel::class.java)
    viewModel.getUser()
}