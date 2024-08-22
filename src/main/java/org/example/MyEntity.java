package org.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
public class MyEntity extends PanacheEntity {

    public String field;

    public String foo;

    @ElementCollection
    @CollectionTable(name = "my_collection", joinColumns = @JoinColumn(name = "my_entity_id"))
    @Column(name = "collection_item")
    public List<String> myCollection;

    @OneToMany(mappedBy = "myEntity", cascade = PERSIST, orphanRemoval = true)
    public List<MyRelatedEntity> myRelatedEntities;

}
