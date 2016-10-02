package Domain

// Add contact use case
data class AddContactUseCaseInput(val contact: Contact)

class AddContactUseCase(val agendaRepository: AgendaRepository) {
    fun execute(addContactUseCaseInput: AddContactUseCaseInput) {
        val agenda = agendaRepository.get()
        agenda.addContact(addContactUseCaseInput.contact)
        agendaRepository.save(agenda)
    }
}


// Get contacts use case
data class AddContactUseCaseOutput(val contacts: List<Contact>)

class GetContactsUseCase(val agendaRepository: AgendaRepository) {
    fun execute(): AddContactUseCaseOutput {
        val agenda = agendaRepository.get()
        return AddContactUseCaseOutput(agenda.contacts)
    }
}