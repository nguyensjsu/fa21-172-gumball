package com.example.candyshop;

import lombok.*;
import javax.persistence.*;
import javax.validation.*;
import java.util.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Catalog")
@Data
@RequiredArgsConstructor
public class Catalog {

    private @Id @GeneratedValue Long id;

    private String sourPatchKids;
    private String hershey;
    private String nerds;
    private String skittles;

    public String sourPatchKids() { return sourPatchKids; }
    public String hershey() { return hershey; }
    public String nerds() { return nerds; }
    public String skittles() { return skittles; }

}