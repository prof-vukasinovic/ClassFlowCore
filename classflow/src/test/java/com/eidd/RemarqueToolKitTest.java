package com.eidd;
import org.junit.jupiter.api.*;

import com.eidd.model.RemarqueToolKit;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;


public class RemarqueToolKitTest{

    @BeforeEach
    public void setUp() {
        try (PrintWriter writer = new PrintWriter("src/test/resources/dataRemarquesTest.txt")) {
            writer.print("");
            RemarqueToolKit.changeDataFile("src/test/resources/dataRemarquesTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetNewRemarqueId() throws IOException {
        int id1 = RemarqueToolKit.getNewRemarqueId("Mon Intitulé");
        assertEquals(0, id1);

        int id2 = RemarqueToolKit.getNewRemarqueId("Mon Intitulé");
        assertEquals(0, id2);

        int id3 = RemarqueToolKit.getNewRemarqueId("Autre");
        assertEquals(1, id3);
    }

    @Test
    public void testConsecutiveIds() throws IOException {
        int id1 = RemarqueToolKit.getNewRemarqueId("First");
        int id2 = RemarqueToolKit.getNewRemarqueId("Second");
        int id3 = RemarqueToolKit.getNewRemarqueId("Third");
        assertEquals(0, id1);
        assertEquals(1, id2);
        assertEquals(2, id3);
    }

    @Test
    public void testSameRemarqueReturnsSameId() throws IOException {
        int id1 = RemarqueToolKit.getNewRemarqueId("TestRemarque");
        int id2 = RemarqueToolKit.getNewRemarqueId("TestRemarque");
        assertEquals(id1, id2);
    }

    @Test
    public void testDifferentRemarques() throws IOException {
        int id1 = RemarqueToolKit.getNewRemarqueId("Remarque1");
        int id2 = RemarqueToolKit.getNewRemarqueId("Remarque2");
        int id3 = RemarqueToolKit.getNewRemarqueId("Remarque3");
        assertNotEquals(id1, id2);
        assertNotEquals(id2, id3);
        assertNotEquals(id1, id3);
    }

    @Test
    public void testNormalization() throws IOException {
        int id1 = RemarqueToolKit.getNewRemarqueId("Café");
        int id2 = RemarqueToolKit.getNewRemarqueId("cafe");
        assertEquals(id1, id2);
    }

    @Test
    public void testSpecialCharactersNormalization() throws IOException {
        int id1 = RemarqueToolKit.getNewRemarqueId("Test_123");
        int id2 = RemarqueToolKit.getNewRemarqueId("Test-123");
        assertEquals(id1, id2);
    }

   @AfterEach
    public void cleanUp() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt"); 
    }
    
}
