package org.example.productcatalogservice_auug2026.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    //@Fetch(FetchMode.SELECT)
    //@BatchSize(size = 10)
    private List<Product> products;
}

//1 category query
//2 + 2 + 1
//total = 4 queries