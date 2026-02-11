package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.ClassRoom;
import com.eidd.model.Eleve;
import com.eidd.model.Groupe;
import com.eidd.model.Position;
import com.eidd.model.Table;
import com.eidd.repositories.ClassRoomRespository;
import com.eidd.service.ClassRoomService;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomServiceTest {
    private ClassRoomService service;

    @BeforeEach
    public void setUp() {
        service = new ClassRoomService();
        ClassRoomRespository.resetCounter();
    }

    @Test
    public void testCreerClassRoom() {
        ClassRoom cr = service.creerClassRoom("Salle 1");
        assertNotNull(cr);
        assertEquals("Salle 1", cr.getNom());
    }

    @Test
    public void testGetClassRoomById() {
        ClassRoom cr = service.creerClassRoom("TestRoom");
        ClassRoom retrieved = service.getClassRoomById(cr.getId());
        assertNotNull(retrieved);
        assertEquals(cr.getId(), retrieved.getId());
    }

    @Test
    public void testGetAllClassRooms() {
        service.creerClassRoom("Room1");
        service.creerClassRoom("Room2");
        List<ClassRoom> rooms = service.getAllClassRooms();
        assertEquals(2, rooms.size());
    }

    @Test
    public void testAjouterEleve() {
        ClassRoom cr = service.creerClassRoom("Room");
        Groupe g = new Groupe();
        cr.setEleves(g);
        Eleve e = new Eleve(1, "Test", "Test");
        service.ajouterEleve(cr.getId(), e);
        assertEquals(1, cr.getEleves().getEleves().size());
    }

    @Test
    public void testSupprimerEleve() {
        ClassRoom cr = service.creerClassRoom("Room");
        Groupe g = new Groupe();
        Eleve e = new Eleve(1, "Test", "Test");
        g.addEleve(e);
        cr.setEleves(g);
        service.supprimerEleve(cr.getId(), e);
        assertEquals(0, cr.getEleves().getEleves().size());
    }

    @Test
    public void testAjouterTable() {
        ClassRoom cr = service.creerClassRoom("Room");
        List<Table> tables = new ArrayList<>();
        cr.setTables(tables);
        Table t = new Table(new Position(1, 1));
        service.ajouterTable(cr.getId(), t);
        assertEquals(1, cr.getTables().size());
    }

    @Test
    public void testSupprimerTable() {
        ClassRoom cr = service.creerClassRoom("Room");
        List<Table> tables = new ArrayList<>();
        Table t = new Table(new Position(1, 1));
        tables.add(t);
        cr.setTables(tables);
        service.supprimerTable(cr.getId(), t);
        assertEquals(0, cr.getTables().size());
    }

    @Test
    public void testSupprimerClassRoom() {
        ClassRoom cr = service.creerClassRoom("Room");
        long id = cr.getId();
        service.supprimerClassRoom(id);
        ClassRoom retrieved = service.getClassRoomById(id);
        assertNull(retrieved);
    }

    @Test
    public void testGetElevesByClassRoomId() {
        ClassRoom cr = service.creerClassRoom("Room");
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        g.addEleve(e1);
        g.addEleve(e2);
        cr.setEleves(g);
        List<Eleve> eleves = service.getElevesByClassRoomId(cr.getId());
        assertEquals(2, eleves.size());
    }

    @Test
    public void testMultipleClassRooms() {
        ClassRoom cr1 = service.creerClassRoom("Room1");
        ClassRoom cr2 = service.creerClassRoom("Room2");
        List<ClassRoom> rooms = service.getAllClassRooms();
        assertTrue(rooms.contains(cr1));
        assertTrue(rooms.contains(cr2));
    }

    @Test
    public void testAjouterMultipleEleves() {
        ClassRoom cr = service.creerClassRoom("Room");
        Groupe g = new Groupe();
        cr.setEleves(g);
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        service.ajouterEleve(cr.getId(), e1);
        service.ajouterEleve(cr.getId(), e2);
        assertEquals(2, cr.getEleves().getEleves().size());
    }

    @Test
    public void testAjouterMultipleTables() {
        ClassRoom cr = service.creerClassRoom("Room");
        List<Table> tables = new ArrayList<>();
        cr.setTables(tables);
        service.ajouterTable(cr.getId(), new Table(new Position(1, 1)));
        service.ajouterTable(cr.getId(), new Table(new Position(2, 2)));
        assertEquals(2, cr.getTables().size());
    }

    @AfterEach
    public void tearDown() {
        ClassRoomRespository.resetCounter();
    }
}
