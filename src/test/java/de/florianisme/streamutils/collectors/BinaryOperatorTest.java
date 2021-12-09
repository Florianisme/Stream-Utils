package de.florianisme.streamutils.collectors;

import com.google.common.collect.Lists;
import de.florianisme.streamutils.util.StringTuple;
import de.florianisme.streamutils.util.Tuple;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinaryOperatorTest {

    @Test
    public void testFirst_withSingleValues() {
        List<StringTuple> keys = Lists.newArrayList(
                new StringTuple("key0", "value0"),
                new StringTuple("key1", "value1"),
                new StringTuple("key2", "value2"));

        Map<String, String> collect = keys.stream()
                .collect(Collectors.toMap(Tuple::getX, Tuple::getY, BinaryOperators.first()));

        assertEquals(3, collect.size());
        assertEquals("value0", collect.get("key0"));
        assertEquals("value1", collect.get("key1"));
        assertEquals("value2", collect.get("key2"));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void test_withDuplicateValues_expectsException() {
        List<StringTuple> keys = Lists.newArrayList(
                new StringTuple("key0", "value0"),
                new StringTuple("key0", "value00"),
                new StringTuple("key1", "value1"),
                new StringTuple("key2", "value2"),
                new StringTuple("key2", "value20"));

        assertThrows(IllegalStateException.class, () -> keys.stream()
                .collect(Collectors.toMap(Tuple::getX, Tuple::getY)));
    }

    @Test
    public void testFirst_withDuplicateValues() {
        List<StringTuple> keys = Lists.newArrayList(
                new StringTuple("key0", "value0"),
                new StringTuple("key0", "value00"),
                new StringTuple("key1", "value1"),
                new StringTuple("key2", "value2"),
                new StringTuple("key2", "value20"));

        Map<String, String> collect = keys.stream()
                .collect(Collectors.toMap(Tuple::getX, Tuple::getY, BinaryOperators.first()));

        assertEquals(3, collect.size());
        assertEquals("value0", collect.get("key0"));
        assertEquals("value1", collect.get("key1"));
        assertEquals("value2", collect.get("key2"));
    }

    @Test
    public void testSecond_withDuplicateValues() {
        List<StringTuple> keys = Lists.newArrayList(
                new StringTuple("key0", "value0"),
                new StringTuple("key0", "value00"),
                new StringTuple("key1", "value1"),
                new StringTuple("key2", "value2"),
                new StringTuple("key2", "value20"));

        Map<String, String> collect = keys.stream()
                .collect(Collectors.toMap(Tuple::getX, Tuple::getY, BinaryOperators.second()));

        assertEquals(3, collect.size());
        assertEquals("value00", collect.get("key0"));
        assertEquals("value1", collect.get("key1"));
        assertEquals("value20", collect.get("key2"));
    }
}