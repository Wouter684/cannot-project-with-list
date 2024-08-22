package org.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class MyRelatedEntity extends PanacheEntity {

    public String relatedField;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "my_entity_id", nullable = false)
    public MyEntity myEntity;

}
