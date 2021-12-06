package com.example.backoffice;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name ="Admin")
@Data
@RequiredArgsConstructor
public class Admin {

    private @Id @GeneratedValue Long id;

    private String firstname ;
    private String lastname ;
    private String email ;
    private String username ;
    private String password ;
    private String roles;
}