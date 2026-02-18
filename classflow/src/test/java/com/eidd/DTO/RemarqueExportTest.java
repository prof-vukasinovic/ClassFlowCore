package com.eidd.DTO;

import org.junit.jupiter.api.*;
import com.eidd.model.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class RemarqueExportTest {
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
    public void testRemarqueExportCreation() {
        RemarqueExport re = new RemarqueExport();
        assertNotNull(re);
        assertNull(re.getIntitule());
        assertEquals(0, re.getId());
    }

    @Test
    public void testRemarqueExportWithParameters() {
        Cours c = new Cours(1, new java.util.Date());
        CoursExport ce = new CoursExport(c);
        RemarqueExport re = new RemarqueExport("TestRemarque", 5, ce);
        assertEquals("TestRemarque", re.getIntitule());
        assertEquals(5, re.getId());
        assertEquals(ce, re.getCours());
    }

    @Test
    public void testRemarqueExportFromModel() {
        Cours c = new Cours(1, new java.util.Date());
        Remarque r = new Remarque("ModelRemarque", c);
        RemarqueExport re = new RemarqueExport(r);
        assertEquals("ModelRemarque", re.getIntitule());
        assertEquals(r.getId(), re.getId());
        assertNotNull(re.getCours());
    }

    @Test
    public void testRemarqueExportFromNullModel() {
        RemarqueExport re = new RemarqueExport(null);
        assertNull(re.getIntitule());
        assertEquals(0, re.getId());
    }

    @Test
    public void testRemarqueExportGettersSetters() {
        RemarqueExport re = new RemarqueExport();
        re.setIntitule("NewRemarque");
        re.setId(100);
        Cours c = new Cours(1, new java.util.Date());
        CoursExport ce = new CoursExport(c);
        re.setCours(ce);
        assertEquals("NewRemarque", re.getIntitule());
        assertEquals(100, re.getId());
        assertEquals(ce, re.getCours());
    }

    @Test
    public void testRemarqueExportModification() {
        Cours c = new Cours(1, new java.util.Date());
        CoursExport ce = new CoursExport(c);
        RemarqueExport re = new RemarqueExport("Original", 1, ce);
        re.setIntitule("Modified");
        assertEquals("Modified", re.getIntitule());
        assertEquals(1, re.getId());
    }

    @Test
    public void testRemarqueExportMultipleObjects() {
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        Cours c3 = new Cours(3, new java.util.Date());
        CoursExport ce1 = new CoursExport(c1);
        CoursExport ce2 = new CoursExport(c2);
        CoursExport ce3 = new CoursExport(c3);
        RemarqueExport re1 = new RemarqueExport("Remarque1", 1, ce1);
        RemarqueExport re2 = new RemarqueExport("Remarque2", 2, ce2);
        RemarqueExport re3 = new RemarqueExport("Remarque3", 3, ce3);
        assertEquals("Remarque1", re1.getIntitule());
        assertEquals("Remarque2", re2.getIntitule());
        assertEquals("Remarque3", re3.getIntitule());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
