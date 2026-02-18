package com.eidd.DTO;
import org.junit.jupiter.api.*;
import com.eidd.model.*;
import com.eidd.repositories.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomExportTest {

    @BeforeEach
    public void setUp() {
        ClassRoomRespository.resetCounter();
    }

    @Test
    public void testClassRoomExportCreation() {
        ClassRoomExport cre = new ClassRoomExport();
        assertNotNull(cre);
        assertNull(cre.getNom());
        assertNull(cre.getEleves());
    }

    @Test
    public void testClassRoomExportFromModel() {
        ClassRoom cr = new ClassRoom("Room1");
        ClassRoomExport cre = new ClassRoomExport(cr);
        assertEquals("Room1", cre.getNom());
        assertNotNull(cre.getId());
    }

    @Test
    public void testClassRoomExportFromModelWithEleves() {
        Groupe g = new Groupe();
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(new Position(1, 1)));
        ClassRoom cr = new ClassRoom(g, tables);
        ClassRoomExport cre = new ClassRoomExport(cr);
        assertNotNull(cre.getEleves());
    }

    @Test
    public void testClassRoomExportFromNullModel() {
        ClassRoomExport cre = new ClassRoomExport(null);
        assertNull(cre.getNom());
        assertNull(cre.getEleves());
    }

    @Test
    public void testClassRoomExportGettersSetters() {
        ClassRoomExport cre = new ClassRoomExport();
        cre.setNom("TestRoom");
        cre.setId(7);
        assertEquals("TestRoom", cre.getNom());
        assertEquals(7, cre.getId());
    }

    @Test
    public void testClassRoomExportTablesManagement() {
        ClassRoomExport cre = new ClassRoomExport();
        List<TableExport> tables = cre.getTables();
        assertNotNull(tables);
        TableExport te = new TableExport();
        te.setPosition(new PositionExport(1, 1));
        tables.add(te);
        assertEquals(1, cre.getTables().size());
    }

    @Test
    public void testClassRoomExportElevesManagement() {
        ClassRoomExport cre = new ClassRoomExport();
        GroupeExport ge = new GroupeExport();
        cre.setEleves(ge);
        assertEquals(ge, cre.getEleves());
    }

    @Test
    public void testClassRoomExportMultipleObjects() {
        ClassRoomExport cre1 = new ClassRoomExport();
        cre1.setNom("Room1");
        cre1.setId(1);
        
        ClassRoomExport cre2 = new ClassRoomExport();
        cre2.setNom("Room2");
        cre2.setId(2);
        
        assertEquals("Room1", cre1.getNom());
        assertEquals("Room2", cre2.getNom());
        assertEquals(1, cre1.getId());
        assertEquals(2, cre2.getId());
    }

    @Test
    public void testClassRoomExportIndependence() {
        ClassRoomExport cre1 = new ClassRoomExport();
        ClassRoomExport cre2 = new ClassRoomExport();
        
        cre1.setNom("Room1");
        cre1.setId(1);
        
        assertNull(cre2.getNom());
        assertEquals(0, cre2.getId());
    }

    @AfterEach
    public void tearDown() {
        ClassRoomRespository.resetCounter();
    }
}
