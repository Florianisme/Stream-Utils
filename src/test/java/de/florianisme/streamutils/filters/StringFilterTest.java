package de.florianisme.streamutils.filters;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringFilterTest {

    @Test
    public void testDiscardNullOrEmptyValues_withNoEmptyOrNullValues() {
        List<String> values = Lists.newArrayList("test0", "test1", "test2");

        List<String> collect = values.stream()
                .filter(StringFilter.discardNullOrEmptyValues())
                .collect(Collectors.toList());

        assertEquals(3, collect.size());
        assertTrue(collect.contains("test0"));
        assertTrue(collect.contains("test1"));
        assertTrue(collect.contains("test2"));
    }

    @Test
    public void testDiscardNullOrEmptyValues_withSingleEmptyValue() {
        List<String> values = Lists.newArrayList("test0", "", "test2");

        List<String> collect = values.stream()
                .filter(StringFilter.discardNullOrEmptyValues())
                .collect(Collectors.toList());

        assertEquals(2, collect.size());
        assertTrue(collect.contains("test0"));
        assertTrue(collect.contains("test2"));
    }

    @Test
    public void testDiscardNullOrEmptyValues_withSingleEmptyAndNullValues() {
        List<String> values = Lists.newArrayList("test0", "", null, "test2");

        List<String> collect = values.stream()
                .filter(StringFilter.discardNullOrEmptyValues())
                .collect(Collectors.toList());

        assertEquals(2, collect.size());
        assertTrue(collect.contains("test0"));
        assertTrue(collect.contains("test2"));
    }
}