package com.eidd.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class RemarqueTest {
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
    public void testRemarqueCreatesId() {
        Cours c1 = new Cours(1, new java.util.Date());
        Remarque r1 = new Remarque("R1", c1);
        assertEquals("R1", r1.getIntitule());
        assertEquals(0, r1.getId());
        Cours c2 = new Cours(2, new java.util.Date());
        Remarque r2 = new Remarque("R2", c2);
        assertEquals(1, r2.getId());
        Remarque r1again = new Remarque("R1", c1);
        assertEquals(0, r1again.getId());
    }

    @Test
    public void testRemarqueGettersSetters() {
        Cours c = new Cours(1, new java.util.Date());
        Remarque r = new Remarque("TestRemarque", c);
        assertEquals("TestRemarque", r.getIntitule());
        r.setIntitule("NewRemarque");
        assertEquals("NewRemarque", r.getIntitule());
    }

    @Test
    public void testRemarqueIdGettersSetters() {
        Cours c = new Cours(1, new java.util.Date());
        Remarque r = new Remarque("TestId", c);
        r.setId(100);
        assertEquals(100, r.getId());
    }

    @Test
    public void testMultipleRemarques() {
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        Cours c3 = new Cours(3, new java.util.Date());
        Remarque r1 = new Remarque("Remarque1", c1);
        Remarque r2 = new Remarque("Remarque2", c2);
        Remarque r3 = new Remarque("Remarque3", c3);
        assertEquals(0, r1.getId());
        assertEquals(1, r2.getId());
        assertEquals(2, r3.getId());
    }

    @Test
    public void testRemarqueDuplicates() {
        Cours c = new Cours(1, new java.util.Date());
        Remarque r1 = new Remarque("Duplicate", c);
        Remarque r2 = new Remarque("Duplicate", c);
        assertEquals(r1.getId(), r2.getId());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
