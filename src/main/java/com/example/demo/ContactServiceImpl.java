package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
ContactServiceImpl implements ContactService{

    
    private ContactRepository contactRepo;

    public ContactServiceImpl(ContactRepository contactRepo){
        this.contactRepo = contactRepo;
    }
    @Override
    public List<Contact> getAll() {

        return contactRepo.findAll();
    }

    @Override
    public void add(Contact contact) {
        contactRepo.save(contact);
    }
}
