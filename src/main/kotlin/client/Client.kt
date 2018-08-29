package client

interface Client {
    fun fetchSprints():Any
    fun pullTicketsFromSprint(sprintName: String):List<Any>

}