package de.florianisme.streamutils.filters;

import java.util.function.Predicate;

public class StringFilter {

    public static Predicate<String> discardNullOrEmptyValues() {
        return ElementFilter.<String>discardNullElements()
                .and(value -> !value.isEmpty());
    }

}
