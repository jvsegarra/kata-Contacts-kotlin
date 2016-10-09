package Unit.Domain

import Domain.Agenda
import Domain.Contact
import io.kotlintest.specs.FlatSpec

class AgendaTest : FlatSpec() {
    init {
        "Agenda.contacts" should "return size 0 when no contacts were added" {
            Agenda("test").contacts.size shouldBe 0
        }

        "Agenda.contacts" should "return size 2 when 2 contacts were added" {
            val agenda = Agenda("test")
            agenda.addContact(Contact("First 1", "last 1", "12345678"))
            agenda.addContact(Contact("First 2", "last 2", "87654321"))

            agenda.contacts.size shouldBe 2
        }
    }
}