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
        Cours c = new Cours(1);
        RemarqueBavardage rb = new RemarqueBavardage("ChatEnCours", c);
        assertEquals("ChatEnCours", rb.getIntitule());
        assertEquals(c, rb.getCours());
        assertEquals(1, rb.getCours().getNumero());
    }

    @Test
    public void testRemarqueBavardageCreationWithCoursNumero() {
        RemarqueBavardage rb = new RemarqueBavardage("ChatEnCours", 5);
        assertEquals("ChatEnCours", rb.getIntitule());
        assertNotNull(rb.getCours());
        assertEquals(5, rb.getCours().getNumero());
    }

    @Test
    public void testRemarqueBavardageGettersSetters() {
        Cours c = new Cours(2);
        RemarqueBavardage rb = new RemarqueBavardage("TestBavardage", c);
        rb.setIntitule("ModifiedBavardage");
        assertEquals("ModifiedBavardage", rb.getIntitule());
    }

    @Test
    public void testRemarqueBavardageCoursGettersSetters() {
        RemarqueBavardage rb = new RemarqueBavardage("Bavardage", 1);
        Cours newCours = new Cours(10);
        rb.setCours(newCours);
        assertEquals(10, rb.getCours().getNumero());
    }

    @Test
    public void testRemarqueBavardageIdAssignment() {
        RemarqueBavardage rb1 = new RemarqueBavardage("Bav1", 1);
        RemarqueBavardage rb2 = new RemarqueBavardage("Bav2", 2);
        assertEquals(0, rb1.getId());
        assertEquals(1, rb2.getId());
    }

    @Test
    public void testRemarqueBavardageIdGettersSetters() {
        RemarqueBavardage rb = new RemarqueBavardage("TestBav", 1);
        rb.setId(99);
        assertEquals(99, rb.getId());
    }

    @Test
    public void testMultipleRemarqueBavardageCreation() {
        RemarqueBavardage rb1 = new RemarqueBavardage("Bavardage1", 1);
        RemarqueBavardage rb2 = new RemarqueBavardage("Bavardage2", 2);
        RemarqueBavardage rb3 = new RemarqueBavardage("Bavardage3", 3);
        assertEquals(0, rb1.getId());
        assertEquals(1, rb2.getId());
        assertEquals(2, rb3.getId());
    }

    @Test
    public void testRemarqueBavardageDuplicates() {
        RemarqueBavardage rb1 = new RemarqueBavardage("DuplicateBav", 1);
        RemarqueBavardage rb2 = new RemarqueBavardage("DuplicateBav", 1);
        assertEquals(rb1.getId(), rb2.getId());
    }

    @Test
    public void testRemarqueBavardageInheritsFromRemarque() {
        RemarqueBavardage rb = new RemarqueBavardage("Bavardage", 5);
        assertTrue(rb instanceof RemarqueBavardage);
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
