package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.Remarque;
import com.eidd.model.RemarqueToolKit;

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
        Remarque r1 = new Remarque("R1");
        assertEquals("R1", r1.getIntitule());
        assertEquals(0, r1.getId());
        Remarque r2 = new Remarque("R2");
        assertEquals(1, r2.getId());
        Remarque r1again = new Remarque("R1");
        assertEquals(0, r1again.getId());
    }

    @Test
    public void testRemarqueGettersSetters() {
        Remarque r = new Remarque("TestRemarque");
        assertEquals("TestRemarque", r.getIntitule());
        r.setIntitule("NewRemarque");
        assertEquals("NewRemarque", r.getIntitule());
    }

    @Test
    public void testRemarqueIdGettersSetters() {
        Remarque r = new Remarque("TestId");
        r.setId(100);
        assertEquals(100, r.getId());
    }

    @Test
    public void testMultipleRemarques() {
        Remarque r1 = new Remarque("Remarque1");
        Remarque r2 = new Remarque("Remarque2");
        Remarque r3 = new Remarque("Remarque3");
        assertEquals(0, r1.getId());
        assertEquals(1, r2.getId());
        assertEquals(2, r3.getId());
    }

    @Test
    public void testRemarqueDuplicates() {
        Remarque r1 = new Remarque("Duplicate");
        Remarque r2 = new Remarque("Duplicate");
        assertEquals(r1.getId(), r2.getId());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
