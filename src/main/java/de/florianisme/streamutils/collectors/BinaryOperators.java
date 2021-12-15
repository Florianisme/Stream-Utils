package de.florianisme.streamutils.collectors;

import java.util.function.BinaryOperator;

public class BinaryOperators {

    /**
     * @return a BinaryOperator which always returns the first object supplied to it
     */
    public static <T> BinaryOperator<T> first() {
        return (first, second) -> first;
    }

    /**
     * @return a BinaryOperator which always returns the second object supplied to it
     */
    public static <T> BinaryOperator<T> second() {
        return (first, second) -> second;
    }

}
