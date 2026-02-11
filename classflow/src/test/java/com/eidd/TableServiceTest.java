package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.Position;
import com.eidd.model.Table;
import com.eidd.service.TableService;

import static org.junit.jupiter.api.Assertions.*;

public class TableServiceTest {
    private TableService service;

    @BeforeEach
    public void setUp() {
        service = new TableService();
    }

    @Test
    public void testCreerTableWithPosition() {
        Position p = new Position(5, 5);
        Table t = service.creerTable(p);
        assertNotNull(t);
        assertEquals(p, t.getPosition());
    }

    @Test
    public void testCreerTableWithCoordinates() {
        Table t = service.creerTable(10, 15);
        assertNotNull(t);
        assertEquals(10, t.getPosition().getX());
        assertEquals(15, t.getPosition().getY());
    }

    @Test
    public void testDeplacerTableWithPosition() {
        Table t = new Table(new Position(0, 0));
        Position newPos = new Position(5, 5);
        service.deplacerTable(t, newPos);
        assertEquals(newPos, t.getPosition());
    }

    @Test
    public void testDeplacerTableWithCoordinates() {
        Table t = new Table(new Position(0, 0));
        service.deplacerTable(t, 10, 20);
        assertEquals(10, t.getPosition().getX());
        assertEquals(20, t.getPosition().getY());
    }

    @Test
    public void testCreerMultipleTables() {
        Table t1 = service.creerTable(1, 1);
        Table t2 = service.creerTable(2, 2);
        Table t3 = service.creerTable(new Position(3, 3));
        
        assertNotNull(t1);
        assertNotNull(t2);
        assertNotNull(t3);
        
        assertEquals(1, t1.getPosition().getX());
        assertEquals(2, t2.getPosition().getY());
        assertEquals(3, t3.getPosition().getX());
    }

    @Test
    public void testDeplacerTableMultipleTimes() {
        Table t = service.creerTable(0, 0);
        
        service.deplacerTable(t, 5, 5);
        assertEquals(5, t.getPosition().getX());
        assertEquals(5, t.getPosition().getY());
        
        service.deplacerTable(t, new Position(10, 10));
        assertEquals(10, t.getPosition().getX());
        assertEquals(10, t.getPosition().getY());
    }

    @Test
    public void testCreerTableWithNegativeCoordinates() {
        Table t = service.creerTable(-5, -5);
        assertEquals(-5, t.getPosition().getX());
        assertEquals(-5, t.getPosition().getY());
    }

    @Test
    public void testCreerTableWithZeroCoordinates() {
        Table t = service.creerTable(0, 0);
        assertEquals(0, t.getPosition().getX());
        assertEquals(0, t.getPosition().getY());
    }

    @Test
    public void testDeplacerTableToNegativeCoordinates() {
        Table t = service.creerTable(5, 5);
        service.deplacerTable(t, -10, -10);
        assertEquals(-10, t.getPosition().getX());
        assertEquals(-10, t.getPosition().getY());
    }

    @Test
    public void testCreerTableAndDeplacerTableConsistency() {
        Table t = service.creerTable(1, 1);
        Position newPos = new Position(2, 2);
        service.deplacerTable(t, newPos);
        
        assertEquals(2, t.getPosition().getX());
        assertEquals(2, t.getPosition().getY());
    }

    @Test
    public void testDeplacerTableWithLargeCoordinates() {
        Table t = service.creerTable(0, 0);
        service.deplacerTable(t, 1000, 2000);
        assertEquals(1000, t.getPosition().getX());
        assertEquals(2000, t.getPosition().getY());
    }

    @Test
    public void testCreerTableVariousMethods() {
        // Test les deux façons de créer une table
        Table t1 = service.creerTable(3, 4);
        Table t2 = service.creerTable(new Position(3, 4));
        
        assertEquals(t1.getPosition().getX(), t2.getPosition().getX());
        assertEquals(t1.getPosition().getY(), t2.getPosition().getY());
    }
}
