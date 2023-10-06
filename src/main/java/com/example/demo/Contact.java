package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;

@Data
public class Contact {

    private Long id;

    @NotNull
    @Size(min=1, message="名字不能为空")
    private String firstName;

    @NotNull
    @Size(min=1, message="名字不能为空")
    private String lastName;

    @NotNull

    @Pattern(regexp = "\\d{11}",message = "必须为数字，并且长度为11")
    private String phoneNumber;

    @NotNull
    @Size(min=1, message="邮箱不能为空")
    @Email(message = "必须为邮箱格式")
    private String emailAddress;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(emailAddress, contact.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, emailAddress);
    }
}