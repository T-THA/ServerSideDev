package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepo;

    public ContactServiceImpl(ContactRepository contactRepo){
        this.contactRepo = contactRepo;
    }
    @Override
    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();
        contactRepo.findAll().forEach(contacts::add);
        return contacts;
    }

    @Override
    public void add(Contact contact) {
        contactRepo.save(contact);
    }
}
