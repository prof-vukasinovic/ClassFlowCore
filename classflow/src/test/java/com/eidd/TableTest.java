package com.eidd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    @Test
    public void testPosition() {
        Position p = new Position(3,4);
        Table t = new Table(p);
        assertEquals(p, t.getPosition());
        Position p2 = new Position(7,8);
        t.setPosition(p2);
        assertEquals(p2, t.getPosition());
    }
}
