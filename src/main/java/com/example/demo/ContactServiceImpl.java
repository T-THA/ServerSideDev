package com.example.demo;

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

    @Override
    public void delete(Long id) {
        contactRepo.deleteById(id);
    }

    @Override
    public Contact get(Long id) {
        if (contactRepo.findById(id).isEmpty())
            return null;
        return contactRepo.findById(id).get();
    }
}
