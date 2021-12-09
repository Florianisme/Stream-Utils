package de.florianisme.streamutils.filters;

import java.util.Objects;
import java.util.function.Predicate;

public class ElementFilter {

    public static <T> Predicate<T> discardNullElements() {
        return Objects::nonNull;
    }

}
