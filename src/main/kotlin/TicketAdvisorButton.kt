import client.JiraClientService
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class TicketAdvisorButton : AnAction() {
    val baseUrl = ""

    override fun actionPerformed(e: AnActionEvent?) {
        try {
            val clientService = JiraClientService(baseUrl) {
                println("success $it")
            }
            clientService.fetchTickets("""query"""")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}