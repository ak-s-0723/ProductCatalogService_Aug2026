package org.example.productcatalogservice_auug2026.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto {
    private String name;
    private Long id;
    private String description;
}
