package com.eidd;

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
        Remarque r1 = new Remarque("R1");
        assertEquals("R1", r1.getIntitule());
        assertEquals(0, r1.getId());
        Remarque r2 = new Remarque("R2");
        assertEquals(1, r2.getId());
        Remarque r1again = new Remarque("R1");
        assertEquals(0, r1again.getId());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
