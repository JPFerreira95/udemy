package com.in28minutes.junit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    public void test() {

        boolean test1 = todos.contains("AWS");
        boolean test2 = todos.contains("GCP");

        //assertEquals(true, test)
        assertTrue(test1);
        assertFalse(test2);
        // assertNull, assertNotNull
        assertArrayEquals(new int[] {1,2}, new int[] {1,2});

        assertEquals(3, todos.size());
    }
}
