package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private List<AddressBook> list = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAll() {
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getById(@PathVariable int id) {
        return ResponseEntity.ok(list.get(id));
    }

    @PostMapping
    public ResponseEntity<AddressBook> add(@RequestBody AddressBookDTO dto) {
        AddressBook obj = new AddressBook(list.size(), dto.name, dto.city, dto.state);
        list.add(obj);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
        AddressBook obj = new AddressBook(id, dto.name, dto.city, dto.state);
        list.set(id, obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        list.remove(id);
        return ResponseEntity.ok("Deleted");
    }
}