package com.example.demo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/home")
@Controller
@SessionAttributes("contacts")
public class ContactController {

    @Autowired
    ContactServiceImpl contactService;

    @ModelAttribute(name = "contact")
    public Contact getContact(){
        return new Contact();
    }

    @ModelAttribute(name = "contacts")
    public List<Contact> getContacts(){
        return contactService.getAll();
    }

    @PostMapping
    public String processContact(@Valid Contact contact,
                                 Errors errors){
        if (errors.hasErrors()) {
            return "home";
        }

        contactService.add(contact);
        return "redirect:/home";
    }

    @GetMapping
    public String home(){
        return "home";
    }
}
