package org.example.productcatalogservice_auug2026.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_ta")
@DiscriminatorValue(value = "TA")
public class Ta extends User {
    private int helpRequests;
}
