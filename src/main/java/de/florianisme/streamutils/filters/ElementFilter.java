package de.florianisme.streamutils.filters;

import java.util.Objects;
import java.util.function.Predicate;

public class ElementFilter {

    /**
     * @return a Predicate which evaluates to {@code true} if the object supplied to it is non-null, otherwise {@code false}
     * @see Objects#nonNull(Object)
     */
    public static <T> Predicate<T> discardNullElements() {
        return Objects::nonNull;
    }

}
