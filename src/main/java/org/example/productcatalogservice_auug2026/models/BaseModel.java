package org.example.productcatalogservice_auug2026.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;

    public BaseModel() {
        this.createdAt = new Date();
        this.lastUpdatedAt = new Date();
        this.state = State.ACTIVE;
    }
}


