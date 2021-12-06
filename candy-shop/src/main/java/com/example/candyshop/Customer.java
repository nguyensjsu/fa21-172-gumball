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

// package com.example.candyshop;

// import lombok.*;
// import javax.persistence.*;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.GenerationType;
// import javax.persistence.Table;
// import javax.persistence.Index;
// import javax.persistence.Column;

// @Entity
// @Table(name = "Users") // can I use the same table?
// @Data
// @RequiredArgsConstructor
// public class Customer {

// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// private Long id;

// private String firstname, lastname;

// public String getFirstName() {
// return this.firstname;
// }

// public String getLastName() {
// return this.lastname;
// }

// public void setFirstName(String firstName) {
// this.firstname = firstName;
// }

// public void setLastName(String lastname) {
// this.lastname = lastname;
// }
// }
