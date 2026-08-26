package org.example.productcatalogservice_auug2026.TableInheritanceExamples.Default;

import jakarta.persistence.Entity;

@Entity(name="instructor")
public class Instructor extends User {
    private String company;
}
