package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ContactRepoImpl implements ContactRepository{
    private List<Contact> contacts;

    public ContactRepoImpl(){
        this.contacts = new ArrayList<>();
    }
    @Override
    public List<Contact> findAll() {
        return contacts;
    }

    @Override
    public void save(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void clear() {
        contacts.clear();
    }
}
