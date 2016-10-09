package Infrastructure

import Domain.Agenda
import Domain.AgendaRepository

class MemoryAgendaRepository : AgendaRepository {
    var agenda: Agenda = Agenda("Application Agenda")

    override fun save(agenda: Agenda) {
        this.agenda = agenda
    }

    override fun get(): Agenda = agenda
}