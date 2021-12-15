package de.florianisme.streamutils.sorters;

import java.util.Comparator;
import java.util.Random;

public class RandomSorter {

    private final Random random;

    public RandomSorter() {
        this.random = new Random();
    }

    public RandomSorter(Random random) {
        this.random = random;
    }

    @SuppressWarnings("ComparatorMethodParameterNotUsed")
    public <T> Comparator<T> shuffle() {
        return (_object1, _object2) -> getRandomInt();
    }

    private int getRandomInt() {
        // Boundary of 3 is exclusive, so we get 0..2 back. Subtract 1 and we have our range from -1..1
        return random.nextInt(3) - 1;
    }

}
