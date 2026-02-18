package com.eidd.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class EleveTest {
    private final String dataFile = "src/test/resources/dataRemarquesTest.txt";

    @BeforeEach
    public void setUp() throws IOException {
        File f = new File(dataFile);
        if (f.exists()) f.delete();
        if (f.getParentFile() != null) f.getParentFile().mkdirs();
        try (PrintWriter writer = new PrintWriter(f)) { writer.print(""); }
        RemarqueToolKit.changeDataFile(dataFile);
        RemarqueToolKit.reinitCounter();
    }

    @Test
    public void testEleveCreation() {
        Eleve e = new Eleve(10, "Nom", "Prenom");
        assertEquals(10, e.getId());
        assertEquals("Nom", e.getNom());
        assertEquals("Prenom", e.getPrenom());
    }

    @Test
    public void testRemarquesManagement() {
        Eleve e = new Eleve(10, "Nom", "Prenom");
        assertEquals(10, e.getId());
        assertEquals("Nom", e.getNom());
        assertEquals("Prenom", e.getPrenom());
        Cours c = new Cours(1, new java.util.Date());
        Remarque r = new Remarque("TestEleve", c);
        e.addRemarque(r);
        assertEquals(1, e.getRemarques().size());
        e.removeRemarque(r);
        assertEquals(0, e.getRemarques().size());
    }

    @Test
    public void testMultipleRemarques() {
        Eleve e = new Eleve(5, "Dupont", "Jean");
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        Remarque r1 = new Remarque("Remarque1", c1);
        Remarque r2 = new Remarque("Remarque2", c2);
        e.addRemarque(r1);
        e.addRemarque(r2);
        assertEquals(2, e.getRemarques().size());
    }

    @Test
    public void testEleveIdGettersSetters() {
        Eleve e = new Eleve(1, "Test", "Test");
        e.setId(20);
        assertEquals(20, e.getId());
    }

    @Test
    public void testEleveNomPrenomGettersSetters() {
        Eleve e = new Eleve(1, "Test", "Test");
        e.setNom("NewName");
        e.setPrenom("NewFirst");
        assertEquals("NewName", e.getNom());
        assertEquals("NewFirst", e.getPrenom());
    }

    @Test
    public void testTableAssignment() {
        Eleve e = new Eleve(1, "Test", "Test");
        Table t = new Table(new Position(1, 1));
        e.setTable(t);
        assertEquals(t, e.getTable());
    }

    @Test
    public void testInitialRemarquesList() {
        Eleve e = new Eleve(1, "Test", "Test");
        assertEquals(0, e.getRemarques().size());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
