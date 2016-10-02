package Domain

data class Contact(val firstName: String, val lastName: String, val phone: String)

class Agenda(val name: String) {
    var contacts: MutableList<Contact> = mutableListOf()

    fun addContact(contact: Contact) = contacts.add(contact)
}
