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
        Contact contact = new Contact();
        contact.setLastName("Doe");
        contact.setFirstName("John");
        contact.setPhoneNumber("12345678901");
        contact.setEmailAddress("22@qq.com");
        contacts.add(contact);
        return contacts;
    }

    @Override
    public void add(Contact contact) {
        contactRepo.save(contact);
    }
}
