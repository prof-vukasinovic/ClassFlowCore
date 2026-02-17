package com.eidd.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoursTest {

    @Test
    public void testCoursCreation() {
        Cours c = new Cours(1);
        assertEquals(1, c.getNumero());
    }

    @Test
    public void testCoursGettersSetters() {
        Cours c = new Cours(5);
        assertEquals(5, c.getNumero());
        c.setNumero(10);
        assertEquals(10, c.getNumero());
    }

    @Test
    public void testCoursMultipleNumbers() {
        Cours c1 = new Cours(1);
        Cours c2 = new Cours(2);
        Cours c3 = new Cours(3);
        assertEquals(1, c1.getNumero());
        assertEquals(2, c2.getNumero());
        assertEquals(3, c3.getNumero());
    }

    @Test
    public void testCoursNumberModification() {
        Cours c = new Cours(0);
        c.setNumero(7);
        assertEquals(7, c.getNumero());
    }

    @Test
    public void testCoursLargeNumbers() {
        Cours c = new Cours(999);
        assertEquals(999, c.getNumero());
        c.setNumero(10000);
        assertEquals(10000, c.getNumero());
    }

    @Test
    public void testCoursNegativeNumbers() {
        Cours c = new Cours(-1);
        assertEquals(-1, c.getNumero());
    }
}
