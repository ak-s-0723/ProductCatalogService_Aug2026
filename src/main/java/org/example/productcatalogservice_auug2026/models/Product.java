package org.example.productcatalogservice_auug2026.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    @ManyToOne //(cascade = CascadeType.ALL)
    private Category category;
    private Boolean isSaleEligible;  //This is why we require dto
}
