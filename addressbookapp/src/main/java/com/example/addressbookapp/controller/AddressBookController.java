package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.service.AddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {

    @Autowired
    private AddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAll() {
        log.info("Fetching all contacts");
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getById(@PathVariable int id) {
        log.info("Fetching contact with ID: {}", id);
        return ResponseEntity.ok(service.getContactById(id));
    }

    @PostMapping
    public ResponseEntity<AddressBook> add(@Valid @RequestBody AddressBookDTO dto) {
        log.info("Adding new contact: {}", dto);
        return ResponseEntity.ok(service.addContact(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> update(@PathVariable int id,
                                              @Valid @RequestBody AddressBookDTO dto) {
        log.info("Updating contact with ID: {}", id);
        return ResponseEntity.ok(service.updateContact(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        log.info("Deleting contact with ID: {}", id);
        service.deleteContact(id);
        return ResponseEntity.ok("Deleted");
    }
}