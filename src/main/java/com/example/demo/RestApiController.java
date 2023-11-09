package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class RestApiController {

    @Autowired
    ContactServiceImpl contactService;

    @GetMapping(path="/api/contacts")
    public Iterable<Contact> getContacts(){
        return contactService.getAll();
    }

    @GetMapping(path="/api/contact/{id}")
    public Contact getContact(@PathVariable("id") Long id){
        if(contactService.get(id) == null){
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }else {
            return contactService.get(id);
        }
    }

    @PostMapping(path="/api/contact", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact addContact(@RequestBody Contact contact){
        contactService.add(contact);
        return contact;
    }

    @DeleteMapping(path="/api/contact/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") Long id){
        contactService.delete(id);
    }

    @PutMapping(path="/api/contact/{id}")
    public Contact updateContact(@PathVariable("id") Long id,
                                 @RequestBody Contact contact){
        Contact currentContact = contactService.get(id);
        currentContact.setFirstName(contact.getFirstName());
        currentContact.setLastName(contact.getLastName());
        currentContact.setEmailAddress(contact.getEmailAddress());
        currentContact.setPhoneNumber(contact.getPhoneNumber());
        contactService.add(currentContact);
        return currentContact;
    }
}
