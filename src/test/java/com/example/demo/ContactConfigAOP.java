package com.example.demo;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.Target;

@EnableAspectJAutoProxy
public class ContactConfigAOP {


    @Bean
    public ContactService contactService() {
        return new ContactServiceImpl(new ContactRepoImpl());
    }

    @Bean
    public CacheContact cacheContact() {
        return new CacheContact();
    }
}
