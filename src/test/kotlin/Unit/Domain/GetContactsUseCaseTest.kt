package Unit.Domain

import Domain.Agenda
import Domain.AgendaRepository
import Domain.Contact
import Domain.GetContactsUseCase
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.only
import com.nhaarman.mockito_kotlin.verify
import io.kotlintest.specs.FlatSpec

class GetContactsUseCaseTest : FlatSpec() {
    init {
        "GetContactsUseCase.execute" should "return the contacts from the agenda repository" {
            val agenda = Agenda("test")
            agenda.addContact(Contact("", "", ""))
            agenda.addContact(Contact("", "", ""))

            val agendaRepositoryMock = mock<AgendaRepository>() {
                on { get() } doReturn agenda
            }

            val getContactsUseCase = GetContactsUseCase(agendaRepositoryMock)
            val result = getContactsUseCase.execute()

            verify(agendaRepositoryMock).get()
            result.contacts shouldEqual agenda.contacts
        }
    }
}