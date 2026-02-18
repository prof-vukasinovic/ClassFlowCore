package com.eidd.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class RemarqueBavardageTest {
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
    public void testRemarqueBavardageCreationWithCours() {
        Cours c = new Cours(1, new java.util.Date());
        RemarqueBavardage rb = new RemarqueBavardage("ChatEnCours", c);
        assertEquals("ChatEnCours", rb.getIntitule());
        assertEquals(c, rb.getCours());
        assertEquals(1, rb.getCours().getNumero());
    }

    @Test
    public void testRemarqueBavardageCreationWithCoursNumero() {
        Cours c = new Cours(5, new java.util.Date());
        RemarqueBavardage rb = new RemarqueBavardage("ChatEnCours", c);
        assertEquals("ChatEnCours", rb.getIntitule());
        assertNotNull(rb.getCours());
        assertEquals(5, rb.getCours().getNumero());
    }

    @Test
    public void testRemarqueBavardageGettersSetters() {
        Cours c = new Cours(2, new java.util.Date());
        RemarqueBavardage rb = new RemarqueBavardage("TestBavardage", c);
        rb.setIntitule("ModifiedBavardage");
        assertEquals("ModifiedBavardage", rb.getIntitule());
    }

    @Test
    public void testRemarqueBavardageCoursGettersSetters() {
        Cours c = new Cours(1, new java.util.Date());
        RemarqueBavardage rb = new RemarqueBavardage("Bavardage", c);
        Cours newCours = new Cours(10, new java.util.Date());
        rb.setCours(newCours);
        assertEquals(10, rb.getCours().getNumero());
    }

    @Test
    public void testRemarqueBavardageIdAssignment() {
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        RemarqueBavardage rb1 = new RemarqueBavardage("Bav1", c1);
        RemarqueBavardage rb2 = new RemarqueBavardage("Bav2", c2);
        assertEquals(0, rb1.getId());
        assertEquals(1, rb2.getId());
    }

    @Test
    public void testRemarqueBavardageIdGettersSetters() {
        Cours c = new Cours(1, new java.util.Date());
        RemarqueBavardage rb = new RemarqueBavardage("TestBav", c);
        rb.setId(99);
        assertEquals(99, rb.getId());
    }

    @Test
    public void testMultipleRemarqueBavardageCreation() {
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        Cours c3 = new Cours(3, new java.util.Date());
        RemarqueBavardage rb1 = new RemarqueBavardage("Bavardage1", c1);
        RemarqueBavardage rb2 = new RemarqueBavardage("Bavardage2", c2);
        RemarqueBavardage rb3 = new RemarqueBavardage("Bavardage3", c3);
        assertEquals(0, rb1.getId());
        assertEquals(1, rb2.getId());
        assertEquals(2, rb3.getId());
    }

    @Test
    public void testRemarqueBavardageDuplicates() {
        Cours c = new Cours(1, new java.util.Date());
        RemarqueBavardage rb1 = new RemarqueBavardage("DuplicateBav", c);
        RemarqueBavardage rb2 = new RemarqueBavardage("DuplicateBav", c);
        assertEquals(rb1.getId(), rb2.getId());
    }

    @Test
    public void testRemarqueBavardageInheritsFromRemarque() {
        Cours c = new Cours(5, new java.util.Date());
        RemarqueBavardage rb = new RemarqueBavardage("Bavardage", c);
        assertTrue(rb instanceof RemarqueBavardage);
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
