package Domain

interface AgendaRepository {
    fun save(agenda: Agenda)
    fun get(): Agenda
}
