package com.eidd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testGetSet() {
        Position p = new Position(1, 2);
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
        p.setX(5);
        p.setY(6);
        assertEquals(5, p.getX());
        assertEquals(6, p.getY());
    }
}
