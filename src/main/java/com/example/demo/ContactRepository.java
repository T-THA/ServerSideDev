package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
