package com.eidd.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class DevoirTest {
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
    public void testDevoirCreation() {
        Cours c = new Cours(1, new java.util.Date());
        Devoir d = new Devoir("Devoir1", c);
        assertEquals("Devoir1", d.getIntitule());
        assertNotNull(d.getId());
    }

    @Test
    public void testDevoirInheritsFromRemarque() {
        Cours c = new Cours(1, new java.util.Date());
        Devoir d = new Devoir("TestDevoir", c);
        assertEquals("TestDevoir", d.getIntitule());
        d.setIntitule("ModifiedDevoir");
        assertEquals("ModifiedDevoir", d.getIntitule());
    }

    @Test
    public void testDevoirIdAssignment() {
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        Devoir d1 = new Devoir("Devoir1", c1);
        Devoir d2 = new Devoir("Devoir2", c2);
        assertEquals(0, d1.getId());
        assertEquals(1, d2.getId());
    }

    @Test
    public void testDevoirIdGettersSetters() {
        Cours c = new Cours(1, new java.util.Date());
        Devoir d = new Devoir("TestDevoir", c);
        d.setId(100);
        assertEquals(100, d.getId());
    }

    @Test
    public void testMultipleDevoirCreation() {
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        Cours c3 = new Cours(3, new java.util.Date());
        Devoir d1 = new Devoir("D1", c1);
        Devoir d2 = new Devoir("D2", c2);
        Devoir d3 = new Devoir("D3", c3);
        assertEquals(0, d1.getId());
        assertEquals(1, d2.getId());
        assertEquals(2, d3.getId());
    }

    @Test
    public void testDevoirDuplicates() {
        Cours c = new Cours(1, new java.util.Date());
        Devoir d1 = new Devoir("DuplicateDevoir", c);
        Devoir d2 = new Devoir("DuplicateDevoir", c);
        assertEquals(d1.getId(), d2.getId());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
