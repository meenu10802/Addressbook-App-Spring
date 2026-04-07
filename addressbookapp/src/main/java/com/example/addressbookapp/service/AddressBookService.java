package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private List<AddressBook> list = new ArrayList<>();
    private int idCounter = 1;

    public List<AddressBook> getAllContacts() {
        return list;
    }

    public AddressBook getContactById(int id) {
        Optional<AddressBook> contact = list.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        return contact.orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public AddressBook addContact(AddressBookDTO dto) {
        AddressBook obj = new AddressBook(idCounter++, dto.name, dto.city, dto.state);
        list.add(obj);
        return obj;
    }

    public AddressBook updateContact(int id, AddressBookDTO dto) {
        AddressBook existing = getContactById(id);

        existing.setName(dto.name);
        existing.setCity(dto.city);
        existing.setState(dto.state);

        return existing;
    }

    public void deleteContact(int id) {
        AddressBook existing = getContactById(id);
        list.remove(existing);
    }
}