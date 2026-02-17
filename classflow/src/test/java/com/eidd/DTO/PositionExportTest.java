package com.eidd.DTO;

import org.junit.jupiter.api.*;
import com.eidd.model.Position;
import static org.junit.jupiter.api.Assertions.*;

public class PositionExportTest {

    @Test
    public void testPositionExportCreation() {
        PositionExport pe = new PositionExport();
        assertNotNull(pe);
        assertEquals(0, pe.getX());
        assertEquals(0, pe.getY());
    }

    @Test
    public void testPositionExportWithParameters() {
        PositionExport pe = new PositionExport(5, 10);
        assertEquals(5, pe.getX());
        assertEquals(10, pe.getY());
    }

    @Test
    public void testPositionExportFromModel() {
        Position p = new Position(3, 7);
        PositionExport pe = new PositionExport(p);
        assertEquals(3, pe.getX());
        assertEquals(7, pe.getY());
    }

    @Test
    public void testPositionExportFromNullModel() {
        PositionExport pe = new PositionExport(null);
        assertEquals(0, pe.getX());
        assertEquals(0, pe.getY());
    }

    @Test
    public void testPositionExportGettersSetters() {
        PositionExport pe = new PositionExport();
        pe.setX(15);
        pe.setY(20);
        assertEquals(15, pe.getX());
        assertEquals(20, pe.getY());
    }

    @Test
    public void testPositionExportModification() {
        PositionExport pe = new PositionExport(1, 1);
        pe.setX(100);
        pe.setY(200);
        assertEquals(100, pe.getX());
        assertEquals(200, pe.getY());
    }

    @Test
    public void testPositionExportMultipleObjects() {
        PositionExport pe1 = new PositionExport(1, 2);
        PositionExport pe2 = new PositionExport(3, 4);
        PositionExport pe3 = new PositionExport(5, 6);
        assertEquals(1, pe1.getX());
        assertEquals(3, pe2.getX());
        assertEquals(5, pe3.getX());
    }

    @Test
    public void testPositionExportLargeCoordinates() {
        PositionExport pe = new PositionExport(99999, 88888);
        assertEquals(99999, pe.getX());
        assertEquals(88888, pe.getY());
    }

    @Test
    public void testPositionExportNegativeCoordinates() {
        PositionExport pe = new PositionExport(-10, -20);
        assertEquals(-10, pe.getX());
        assertEquals(-20, pe.getY());
    }
}
