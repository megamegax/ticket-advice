package client

interface Client {
    fun fetchSprints():Any
    suspend fun pullTicketsFromSprint(sprintName: String):List<Any>

}