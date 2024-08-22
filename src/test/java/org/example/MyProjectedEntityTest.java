package org.example;

import io.quarkus.panache.common.Sort;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class MyProjectedEntityTest {
    @Test
    void canFindAllWithListAttribute() {
        var entityList = MyEntity.<MyEntity>findAll(Sort.by("id")).list();

        assertEquals(3, entityList.size());

        var entity1 = entityList.getFirst();
        var entity2 = entityList.get(1);
        var entity3 = entityList.getLast();

        assertEquals("field-1", entity1.field);
        assertEquals("field-2", entity2.field);
        assertEquals("field-3", entity3.field);

        assertEquals("foo-1", entity1.foo);
        assertEquals("foo-2", entity2.foo);
        assertEquals("foo-3", entity3.foo);

        assertArrayEquals(new String[] {"item1", "item2", "item3"}, entity1.myCollection.toArray());
        assertArrayEquals(new String[] {"item4", "item5", "item6"}, entity2.myCollection.toArray());
        assertArrayEquals(new String[] {"item7", "item8", "item9"}, entity3.myCollection.toArray());

        assertEquals("related-1-field-1", entity1.myRelatedEntities.getFirst().relatedField);
        assertEquals("related-1-field-2", entity1.myRelatedEntities.getLast().relatedField);
        assertEquals("related-2-field-1", entity2.myRelatedEntities.getFirst().relatedField);
        assertEquals("related-2-field-2", entity2.myRelatedEntities.getLast().relatedField);
        assertEquals("related-3-field-1", entity3.myRelatedEntities.getFirst().relatedField);
        assertEquals("related-3-field-2", entity3.myRelatedEntities.getLast().relatedField);
    }

    @Test
    void canProjectWithListAttribute() {
        var projectedEntityList = MyEntity.findAll(Sort.by("id")).project(MyProjectedEntity.class).list();

        assertEquals(3, projectedEntityList.size());

        assertEquals("field-1", projectedEntityList.getFirst().field());
        assertEquals("field-2", projectedEntityList.get(1).field());
        assertEquals("field-3", projectedEntityList.getLast().field());

        assertArrayEquals(new String[] {"item1", "item2", "item3"}, projectedEntityList.getFirst().myCollection().toArray());
        assertArrayEquals(new String[] {"item4", "item5", "item6"}, projectedEntityList.get(1).myCollection().toArray());
        assertArrayEquals(new String[] {"item7", "item8", "item9"}, projectedEntityList.getLast().myCollection().toArray());
    }

    @Test
    void canProjectWithListEntityAttribute() {
        var projectedEntityList = MyEntity.findAll(Sort.by("id")).project(MySecondProjectedEntity.class).list();

        assertEquals(3, projectedEntityList.size());

        assertEquals("field-1", projectedEntityList.getFirst().field());
        assertEquals("field-2", projectedEntityList.get(1).field());
        assertEquals("field-3", projectedEntityList.getLast().field());

        assertEquals("related-1-field-1", projectedEntityList.getFirst().myRelatedEntities().getFirst().relatedField);
        assertEquals("related-1-field-2", projectedEntityList.getFirst().myRelatedEntities().getLast().relatedField);
        assertEquals("related-2-field-1", projectedEntityList.get(1).myRelatedEntities().getFirst().relatedField);
        assertEquals("related-2-field-2", projectedEntityList.get(1).myRelatedEntities().getLast().relatedField);
        assertEquals("related-3-field-1", projectedEntityList.getLast().myRelatedEntities().getFirst().relatedField);
        assertEquals("related-3-field-2", projectedEntityList.getLast().myRelatedEntities().getLast().relatedField);
    }
}