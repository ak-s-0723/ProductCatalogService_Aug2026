package org.example.productcatalogservice_auug2026.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class Ta extends User {
    private int helpRequests;
}
