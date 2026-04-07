package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressBookService {

    private List<AddressBook> list = new ArrayList<>();

    public List<AddressBook> getAll() {
        return list;
    }

    public AddressBook getById(int id) {
        return list.get(id);
    }

    public AddressBook add(AddressBookDTO dto) {
        AddressBook obj = new AddressBook(list.size(), dto.name, dto.city, dto.state);
        list.add(obj);
        return obj;
    }

    public AddressBook update(int id, AddressBookDTO dto) {
        AddressBook obj = new AddressBook(id, dto.name, dto.city, dto.state);
        list.set(id, obj);
        return obj;
    }

    public void delete(int id) {
        list.remove(id);
    }
}