import client.JiraClientService
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class TicketAdvisorButton : AnAction() {
    val baseUrl = ""

    override fun actionPerformed(e: AnActionEvent?) {
        println("test")

        val clientService = JiraClientService(baseUrl)
        val tickets = clientService.fetchTickets(""""----"""")
        println(tickets)
    }
}