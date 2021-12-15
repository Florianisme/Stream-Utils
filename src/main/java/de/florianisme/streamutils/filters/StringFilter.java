package de.florianisme.streamutils.filters;

import java.util.function.Predicate;

public class StringFilter {

    /**
     * @return a Predicate which evaluates to {@code true} if the String provided is non-null and not empty, otherwise {@code false}
     * @see ElementFilter#discardNullElements()
     * @see String#isEmpty()
     */
    public static Predicate<String> discardNullOrEmptyValues() {
        return ElementFilter.<String>discardNullElements()
                .and(value -> !value.isEmpty());
    }

}
