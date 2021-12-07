package com.example.candyshop;

import lombok.*;
import javax.persistence.*;
import javax.validation.*;
import java.util.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Users")
@Data
@RequiredArgsConstructor
public class Customer {

    private @Id Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String roles;

    public String firstname() {
        return firstname;
    }

    public String lastname() {
        return lastname;
    }

    public String email() {
        return email;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String roles() {
        return roles;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public String getLastName() {
        return this.lastname;
    }

    public String getCustomerEmail() {
        return this.email;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setCustomerEmail(String email) {
        this.email = email;
    }

}
