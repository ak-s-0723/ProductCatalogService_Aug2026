package org.example.productcatalogservice_auug2026.TableInheritanceExamples.Default;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.UUID;

@Entity(name="user")
public class User {

    @Id
    private UUID id;
    private String name;
}
