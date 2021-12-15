package de.florianisme.streamutils.sorters;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RandomSorterTest {

    @Test
    public void testShuffle_withRandomKeepsOrder() {
        List<String> values = Lists.newArrayList("test0", "test1", "test2");
        Random random = mock(Random.class);

        // Translates to 0, 0, 0. The order of items will be kept the same
        when(random.nextInt(anyInt())).thenReturn(1, 1, 1);

        List<String> collect = values.stream()
                .sorted(new RandomSorter(random).shuffle())
                .collect(Collectors.toList());

        assertEquals(3, collect.size());
        assertEquals("test0", collect.get(0));
        assertEquals("test1", collect.get(1));
        assertEquals("test2", collect.get(2));
    }

    @Test
    public void testShuffle_withRandomMixesOrder() {
        List<String> values = Lists.newArrayList("test0", "test1", "test2");
        Random random = mock(Random.class);

        // Translates to 0, -1, -1
        when(random.nextInt(anyInt())).thenReturn(1, 0, 0);

        List<String> collect = values.stream()
                .sorted(new RandomSorter(random).shuffle())
                .collect(Collectors.toList());

        assertEquals(3, collect.size());
        assertEquals("test2", collect.get(0));
        assertEquals("test0", collect.get(1));
        assertEquals("test1", collect.get(2));
    }

    @Test
    public void testShuffle_withNullValues() {
        List<String> values = Lists.newArrayList(null, null, null);

        List<String> collect = values.stream()
                .sorted(new RandomSorter().shuffle())
                .collect(Collectors.toList());

        assertEquals(3, collect.size());
        assertTrue(collect.contains(null));
    }
}