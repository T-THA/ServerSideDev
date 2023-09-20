package com.example.demo;

import org.springframework.context.annotation.Bean;

public class ContactConfig {

    private ContactRepository contactRepository;
    @Bean
    public ContactRepository contactRepository() {
        contactRepository = new ContactRepoImpl();
        return contactRepository;
    }

    @Bean
    public ContactService contactService() {
        return new ContactServiceImpl(contactRepository);
    }
}
