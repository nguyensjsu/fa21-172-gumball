package com.example.payments;

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

    private String sourPatchKids = "0";
    private String hershey = "0";
    private String nerds = "0";
    private String skittles = "0";

    public String sourPatchKids() { return sourPatchKids; }
    public String hershey() { return hershey; }
    public String nerds() { return nerds; }
    public String skittles() { return skittles; }

    public String individualCost(String item, String count) {
        int intCount = Integer.parseInt(count);
        if (item == "Sour Patch Kids") {
            intCount *= 1;
        } else if (item == "Hershey") {
            intCount *= 3;
        } else if (item == "Nerds") {
            intCount *= 2;
        } else if (item == "Skittles") {
            intCount *= 4;
        }

        return Integer.toString(intCount);
    }

    public String totalCost() {
        int sourPatchKidsCost = Integer.parseInt(individualCost("Sour Patch Kids", sourPatchKids()));
        int hersheyCost = Integer.parseInt(individualCost("Hershey", hershey()));
        int nerdsCost = Integer.parseInt(individualCost("Nerds", nerds()));
        int skittlesCost = Integer.parseInt(individualCost("Skittles", skittles()));

        return Integer.toString(sourPatchKidsCost + hersheyCost + nerdsCost + skittlesCost);
    }

}