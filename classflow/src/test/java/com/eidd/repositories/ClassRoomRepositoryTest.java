package com.eidd.repositories;

import org.junit.jupiter.api.*;

import com.eidd.model.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomRepositoryTest {

    @BeforeEach
    public void setUp() {
        ClassRoomRespository.resetCounter();
    }

    @Test
    public void testRepositoryCreation() {
        ClassRoomRespository repo = new ClassRoomRespository();
        assertNotNull(repo);
        assertNotNull(repo.getClassRooms());
        assertEquals(0, repo.getClassRooms().size());
    }

    @Test
    public void testAddClassRoom() {
        ClassRoomRespository repo = new ClassRoomRespository();
        ClassRoom cr = new ClassRoom("Room1");
        repo.addClassRoom(cr);
        assertEquals(1, repo.getClassRooms().size());
        assertEquals(cr, repo.getClassRooms().get(0));
    }

    @Test
    public void testAddMultipleClassRooms() {
        ClassRoomRespository repo = new ClassRoomRespository();
        ClassRoom cr1 = new ClassRoom("Room1");
        ClassRoom cr2 = new ClassRoom("Room2");
        ClassRoom cr3 = new ClassRoom("Room3");
        repo.addClassRoom(cr1);
        repo.addClassRoom(cr2);
        repo.addClassRoom(cr3);
        assertEquals(3, repo.getClassRooms().size());
    }

    @Test
    public void testGetClassRoomById() {
        ClassRoomRespository repo = new ClassRoomRespository();
        ClassRoom cr1 = new ClassRoom("Room1");
        ClassRoom cr2 = new ClassRoom("Room2");
        repo.addClassRoom(cr1);
        repo.addClassRoom(cr2);
        ClassRoom found = repo.getClassRoomById(cr1.getId());
        assertEquals(cr1, found);
        assertEquals("Room1", found.getNom());
    }

    @Test
    public void testGetClassRoomByIdNotFound() {
        ClassRoomRespository repo = new ClassRoomRespository();
        ClassRoom cr = repo.getClassRoomById(999);
        assertNull(cr);
    }

    @Test
    public void testGetClassRoomsEmptyList() {
        ClassRoomRespository repo = new ClassRoomRespository();
        assertNotNull(repo.getClassRooms());
        assertEquals(0, repo.getClassRooms().size());
    }

    @Test
    public void testCounterIncrement() {
        long initialCounter = ClassRoomRespository.getCounter();
        ClassRoom cr = new ClassRoom("Room1");
        assertEquals(initialCounter, cr.getId());
        long afterCounter = ClassRoomRespository.getCounter();
        assertEquals(initialCounter + 1, afterCounter);
    }

    @Test
    public void testCounterStaticBehavior() {
        long counter1 = ClassRoomRespository.getCounter();
        ClassRoomRespository.incrementCounter();
        long counter2 = ClassRoomRespository.getCounter();
        assertEquals(counter1 + 1, counter2);
    }

    @Test
    public void testResetCounter() {
        ClassRoomRespository.incrementCounter();
        ClassRoomRespository.incrementCounter();
        ClassRoomRespository.resetCounter();
        assertEquals(0, ClassRoomRespository.getCounter());
    }

    @Test
    public void testRepositoryMultipleOperations() {
        ClassRoomRespository repo = new ClassRoomRespository();
        Groupe g = new Groupe();
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(new Position(1, 1)));
        ClassRoom cr1 = new ClassRoom(g, tables);
        ClassRoom cr2 = new ClassRoom("Room2");
        repo.addClassRoom(cr1);
        repo.addClassRoom(cr2);
        assertEquals(2, repo.getClassRooms().size());
        ClassRoom found = repo.getClassRoomById(cr1.getId());
        assertEquals(cr1, found);
    }

    @AfterEach
    public void tearDown() {
        ClassRoomRespository.resetCounter();
    }
}
