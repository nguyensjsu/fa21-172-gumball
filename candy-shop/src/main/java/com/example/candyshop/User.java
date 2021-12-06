
package com.example.candyshop;

import lombok.*;
import javax.persistence.*;
import javax.validation.*;
import java.util.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name ="Users")
@Data
@RequiredArgsConstructor
public class User {

    private @Id @GeneratedValue Long id;

    private String firstname ;
    private String lastname ;
    private String email ;
    private String username ; 
	private String password ;
	private String roles;

}

