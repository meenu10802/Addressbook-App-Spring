package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private List<AddressBook> addressList = new ArrayList<>();
    private int idCounter = 1;

    public List<AddressBook> getAllContacts() {
        return addressList;
    }

    public AddressBook getContactById(int id) {
        return addressList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Contact not found"));
    }

    public AddressBook addContact(AddressBookDTO dto) {
        AddressBook newContact = new AddressBook(
                idCounter++,
                dto.getName(),
                dto.getCity(),
                dto.getState()
        );
        addressList.add(newContact);
        return newContact;
    }

    public AddressBook updateContact(int id, AddressBookDTO dto) {
        AddressBook existing = getContactById(id);

        existing.setName(dto.getName());
        existing.setCity(dto.getCity());
        existing.setState(dto.getState());

        return existing;
    }

    public void deleteContact(int id) {
        AddressBook existing = getContactById(id);
        addressList.remove(existing);
    }
}