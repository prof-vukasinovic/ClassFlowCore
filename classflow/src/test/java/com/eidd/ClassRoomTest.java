package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.ClassRoom;
import com.eidd.model.Groupe;
import com.eidd.model.Position;
import com.eidd.model.Table;
import com.eidd.repositories.ClassRoomRespository;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomTest {

    @BeforeEach
    public void setUp() {
        ClassRoomRespository.resetCounter();
    }

    @Test
    public void testClassRoomCreation() {
        ClassRoom cr = new ClassRoom("Salle 1");
        assertEquals("Salle 1", cr.getNom());
        assertNotNull(cr.getId());
    }

    @Test
    public void testClassRoomConstructorWithGroupeAndTables() {
        Groupe g = new Groupe();
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(new Position(1, 1)));
        ClassRoom cr = new ClassRoom(g, tables);
        assertEquals(g, cr.getEleves());
        assertEquals(tables, cr.getTables());
    }

    @Test
    public void testGettersSetters() {
        Groupe g = new Groupe();
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(new Position(1,1)));
        ClassRoom cr = new ClassRoom(g, tables);
        assertEquals(g, cr.getEleves());
        assertEquals(tables, cr.getTables());
        assertEquals(ClassRoomRespository.getCounter()-1, cr.getId());
        cr.setId(7);
        assertEquals(7, cr.getId());
    }

    @Test
    public void testClassRoomNomGettersSetters() {
        ClassRoom cr = new ClassRoom("TestRoom");
        cr.setNom("NewName");
        assertEquals("NewName", cr.getNom());
    }

    @Test
    public void testElevesGettersSetters() {
        ClassRoom cr = new ClassRoom("Test");
        Groupe g = new Groupe();
        cr.setEleves(g);
        assertEquals(g, cr.getEleves());
    }

    @Test
    public void testTablesGettersSetters() {
        ClassRoom cr = new ClassRoom("Test");
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(new Position(1, 1)));
        cr.setTables(tables);
        assertEquals(tables, cr.getTables());
    }

    @Test
    public void testIdGettersSetters() {
        ClassRoom cr = new ClassRoom("Test");
        long newId = 999;
        cr.setId(newId);
        assertEquals(newId, cr.getId());
    }

    @Test
    public void testClassRoomIncrementingIds() {
        long currentCounter = ClassRoomRespository.getCounter();
        ClassRoom cr1 = new ClassRoom("Room1");
        ClassRoom cr2 = new ClassRoom("Room2");
        assertEquals(currentCounter, cr1.getId());
        assertEquals(currentCounter + 1, cr2.getId());
    }

    @AfterEach
    public void tearDown() {
        ClassRoomRespository.resetCounter();
    }
}
