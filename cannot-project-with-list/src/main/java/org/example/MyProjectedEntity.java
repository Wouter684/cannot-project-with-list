package org.example;

import java.util.List;

public record MyProjectedEntity(
        long id,
        String field,
        List<String> myCollection
) {
}
