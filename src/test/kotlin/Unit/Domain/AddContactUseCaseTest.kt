package Unit.Domain

import Domain.*
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.kotlintest.specs.FlatSpec

class AddContactUseCaseTest : FlatSpec() {
    init {
        "GetContactsUseCase.execute" should "return the contacts from the agenda repository" {
            val agenda = Agenda("test")
            agenda.addContact(Contact("", "", ""))
            agenda.addContact(Contact("", "", ""))

            val agendaRepositoryMock = mock<AgendaRepository>() {
                on { get() } doReturn agenda
            }

            val addContactUseCase = AddContactUseCase(agendaRepositoryMock)
            addContactUseCase.execute(AddContactUseCaseInput(Contact("", "", "")))

            verify(agendaRepositoryMock).get()
            verify(agendaRepositoryMock).save(agenda)
        }
    }
}