package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.Position;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testPositionCreation() {
        Position p = new Position(3, 4);
        assertEquals(3, p.getX());
        assertEquals(4, p.getY());
    }

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

    @Test
    public void testSetXOnly() {
        Position p = new Position(1, 2);
        p.setX(10);
        assertEquals(10, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void testSetYOnly() {
        Position p = new Position(1, 2);
        p.setY(20);
        assertEquals(1, p.getX());
        assertEquals(20, p.getY());
    }

    @Test
    public void testNegativeCoordinates() {
        Position p = new Position(-5, -10);
        assertEquals(-5, p.getX());
        assertEquals(-10, p.getY());
    }

    @Test
    public void testZeroCoordinates() {
        Position p = new Position(0, 0);
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
    }

    @Test
    public void testLargeCoordinates() {
        Position p = new Position(1000, 2000);
        assertEquals(1000, p.getX());
        assertEquals(2000, p.getY());
    }
}
