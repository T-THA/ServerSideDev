package com.example.demo;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();

    void add(Contact contact);
}
