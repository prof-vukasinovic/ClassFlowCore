package com.eidd.DTO;

import org.junit.jupiter.api.*;
import com.eidd.model.Table;
import com.eidd.model.Position;

import static org.junit.jupiter.api.Assertions.*;

public class TableExportTest {

    @Test
    public void testTableExportCreation() {
        TableExport te = new TableExport();
        assertNotNull(te);
        assertNull(te.getPosition());
    }

    @Test
    public void testTableExportFromModel() {
        Position p = new Position(1, 1);
        Table t = new Table(p);
        TableExport te = new TableExport(t);
        assertNotNull(te.getPosition());
        assertEquals(1, te.getPosition().getX());
        assertEquals(1, te.getPosition().getY());
    }

    @Test
    public void testTableExportFromNullModel() {
        TableExport te = new TableExport();
        assertNull(te.getPosition());
    }

    @Test
    public void testTableExportGettersSetters() {
        TableExport te = new TableExport();
        PositionExport pe = new PositionExport(5, 5);
        te.setPosition(pe);
        assertEquals(pe, te.getPosition());
        assertEquals(5, te.getPosition().getX());
    }

    @Test
    public void testTableExportPositionModification() {
        TableExport te = new TableExport();
        PositionExport pe1 = new PositionExport(1, 1);
        te.setPosition(pe1);
        assertEquals(pe1, te.getPosition());
        
        PositionExport pe2 = new PositionExport(10, 10);
        te.setPosition(pe2);
        assertEquals(pe2, te.getPosition());
        assertEquals(10, te.getPosition().getX());
    }

    @Test
    public void testTableExportMultipleObjects() {
        TableExport te1 = new TableExport();
        te1.setPosition(new PositionExport(1, 1));
        
        TableExport te2 = new TableExport();
        te2.setPosition(new PositionExport(2, 2));
        
        assertEquals(1, te1.getPosition().getX());
        assertEquals(2, te2.getPosition().getX());
    }

    @Test
    public void testTableExportIndependence() {
        TableExport te1 = new TableExport();
        TableExport te2 = new TableExport();
        
        PositionExport pe = new PositionExport(5, 5);
        te1.setPosition(pe);
        
        assertNotNull(te1.getPosition());
        assertNull(te2.getPosition());
    }
}
