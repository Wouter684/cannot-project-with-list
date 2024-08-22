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
        List<MyEntity> entityList = MyEntity.findAll(Sort.by("id")).list();

        assertEquals(3, entityList.size());

        assertEquals("field-1", entityList.getFirst().field);
        assertEquals("field-2", entityList.get(1).field);
        assertEquals("field-3", entityList.getLast().field);

        assertEquals("foo-1", entityList.getFirst().foo);
        assertEquals("foo-2", entityList.get(1).foo);
        assertEquals("foo-3", entityList.getLast().foo);

        assertArrayEquals(new String[] {"item1", "item2", "item3"}, entityList.getFirst().myCollection.toArray());
        assertArrayEquals(new String[] {"item4", "item5", "item6"}, entityList.get(1).myCollection.toArray());
        assertArrayEquals(new String[] {"item7", "item8", "item9"}, entityList.getLast().myCollection.toArray());
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
}