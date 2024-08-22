package org.example;

import java.util.List;

public record MySecondProjectedEntity(
        long id,
        String field,
        List<MyRelatedEntity> myRelatedEntities
) {
}
