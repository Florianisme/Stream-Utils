package de.florianisme.streamutils.filters;

import java.util.function.Predicate;

public class StringFilter {

    public static Predicate<String> discardNullOrEmptyValues() {
        return NonNullFilter.<String>discardNullElements()
                .and(value -> !value.isEmpty());
    }

}
