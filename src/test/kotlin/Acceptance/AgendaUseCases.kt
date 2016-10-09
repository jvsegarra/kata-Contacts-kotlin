package Acceptance

import Domain.AddContactUseCase
import Domain.AddContactUseCaseInput
import Domain.Contact
import Domain.GetContactsUseCase
import Infrastructure.MemoryAgendaRepository
import io.kotlintest.specs.FeatureSpec

class AgendaUseCases : FeatureSpec() {
    init {
        feature("Get contacts use case") {
            scenario("should return no contacts initially") {
                val getContactsUseCase = GetContactsUseCase(MemoryAgendaRepository())
                getContactsUseCase.execute().contacts.size shouldBe 0
            }
            scenario("should return the contacts added to the agenda") {
                val memoryAgendaRepository = MemoryAgendaRepository()
                val contact1 = Contact("first name 1", "last name 1", "1234")
                val contact2 = Contact("first name 2", "last name 2", "5678")
                addContact(contact1, memoryAgendaRepository)
                addContact(contact2, memoryAgendaRepository)

                val getContactsUseCase = GetContactsUseCase(memoryAgendaRepository)
                val contacts = getContactsUseCase.execute().contacts
                contacts.size shouldBe 2
                contacts[0] shouldEqual contact1
                contacts[1] shouldEqual contact2
            }
        }
    }

    private fun addContact(contact: Contact, memoryAgendaRepository: MemoryAgendaRepository) {
        val addContactUseCaseInput = AddContactUseCaseInput(contact)
        AddContactUseCase(memoryAgendaRepository).execute(addContactUseCaseInput)
    }
}