package com.eidd;
import org.junit.jupiter.api.*;
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

   @AfterEach
    public void cleanUp() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt"); 
    }
    
}
