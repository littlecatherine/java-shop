package com.joecui.web.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void testGetId() throws Exception {

        Integer expectedValue = 5;
        Cart cart = new Cart();
        Integer actualValue = cart.getId();
        assertEquals(expectedValue, actualValue);

    }
}