package com.prodyna;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    @Test
    void add_twoNumbers_returnsSum() {
        assertEquals(5, Application.add(2, 3));
    }
}
