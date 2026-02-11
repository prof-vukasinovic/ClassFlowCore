package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.Position;
import com.eidd.model.Table;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    @Test
    public void testTableCreation() {
        Position p = new Position(1, 2);
        Table t = new Table(p);
        assertEquals(p, t.getPosition());
    }

    @Test
    public void testPosition() {
        Position p = new Position(3,4);
        Table t = new Table(p);
        assertEquals(p, t.getPosition());
        Position p2 = new Position(7,8);
        t.setPosition(p2);
        assertEquals(p2, t.getPosition());
    }

    @Test
    public void testSetPosition() {
        Table t = new Table(new Position(0, 0));
        Position newPos = new Position(10, 20);
        t.setPosition(newPos);
        assertEquals(newPos, t.getPosition());
        assertEquals(10, t.getPosition().getX());
        assertEquals(20, t.getPosition().getY());
    }

    @Test
    public void testTableWithDifferentPositions() {
        Position p1 = new Position(5, 5);
        Position p2 = new Position(10, 10);
        Table t1 = new Table(p1);
        Table t2 = new Table(p2);
        assertEquals(p1, t1.getPosition());
        assertEquals(p2, t2.getPosition());
    }

    @Test
    public void testTablePositionUpdate() {
        Position initial = new Position(1, 1);
        Table t = new Table(initial);
        Position updated = new Position(2, 2);
        t.setPosition(updated);
        assertEquals(updated, t.getPosition());
        assertNotEquals(initial, t.getPosition());
    }

    @Test
    public void testTableWithNegativeCoordinates() {
        Position p = new Position(-5, -5);
        Table t = new Table(p);
        assertEquals(-5, t.getPosition().getX());
        assertEquals(-5, t.getPosition().getY());
    }
}
