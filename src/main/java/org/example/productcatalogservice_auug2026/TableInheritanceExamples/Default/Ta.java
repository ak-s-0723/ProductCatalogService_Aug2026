package org.example.productcatalogservice_auug2026.TableInheritanceExamples.Default;

import jakarta.persistence.Entity;

@Entity(name="ta")
public class Ta extends User {
    private int helpRequests;
}
