package com.eidd;

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
    public void testRemarquesManagement() {
        Eleve e = new Eleve(10, "Nom", "Prenom");
        assertEquals(10, e.getId());
        assertEquals("Nom", e.getNom());
        assertEquals("Prenom", e.getPrenom());
        Remarque r = new Remarque("TestEleve");
        e.addRemarque(r);
        assertEquals(1, e.getRemarques().size());
        e.removeRemarque(r);
        assertEquals(0, e.getRemarques().size());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
