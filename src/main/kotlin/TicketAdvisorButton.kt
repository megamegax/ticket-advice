import client.Client
import client.ClientService
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext

class TicketAdvisorButton : AnAction() {
    val baseUrl = "http://index.hu"
    // Koin module
    val clientModule = applicationContext {
        bean { ClientService(baseUrl) as Client }
    }

    init {
        StandAloneContext.startKoin(listOf(clientModule))

    }

    override fun actionPerformed(e: AnActionEvent?) {
        println("test")
    }
}