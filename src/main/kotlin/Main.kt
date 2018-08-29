import client.Client
import client.ClientService
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.startKoin

fun main(vararg args: String) {
    startKoin(listOf(ClientModule))
    println("Hello World")
}

// Koin module
val ClientModule = applicationContext {
    bean { ClientService() as Client }
}