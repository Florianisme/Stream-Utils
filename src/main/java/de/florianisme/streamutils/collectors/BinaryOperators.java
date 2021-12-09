package de.florianisme.streamutils.collectors;

import java.util.function.BinaryOperator;

public class BinaryOperators {

    public static <T> BinaryOperator<T> first() {
        return (first, second) -> first;
    }

    public static <T> BinaryOperator<T> second() {
        return (first, second) -> second;
    }

}
