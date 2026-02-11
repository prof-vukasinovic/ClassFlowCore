package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.Eleve;
import com.eidd.model.Position;
import com.eidd.model.Remarque;
import com.eidd.model.RemarqueToolKit;
import com.eidd.model.Table;
import com.eidd.service.EleveService;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class EleveServiceTest {
    private EleveService service;
    private final String dataFile = "src/test/resources/dataRemarquesTest.txt";

    @BeforeEach
    public void setUp() throws IOException {
        service = new EleveService();
        File f = new File(dataFile);
        if (f.exists()) f.delete();
        if (f.getParentFile() != null) f.getParentFile().mkdirs();
        try (PrintWriter writer = new PrintWriter(f)) { writer.print(""); }
        RemarqueToolKit.changeDataFile(dataFile);
        RemarqueToolKit.reinitCounter();
    }

    @Test
    public void testAjouterRemarque() {
        Eleve e = new Eleve(1, "Test", "Test");
        Remarque r = service.ajouterRemarque(e, "Ma Remarque");
        assertNotNull(r);
        assertEquals(1, e.getRemarques().size());
    }

    @Test
    public void testAjouterMultipleRemarques() {
        Eleve e = new Eleve(1, "Test", "Test");
        service.ajouterRemarque(e, "Remarque1");
        service.ajouterRemarque(e, "Remarque2");
        service.ajouterRemarque(e, "Remarque3");
        assertEquals(3, e.getRemarques().size());
    }

    @Test
    public void testSupprimerRemarque() {
        Eleve e = new Eleve(1, "Test", "Test");
        Remarque r = service.ajouterRemarque(e, "TestRemarque");
        assertEquals(1, e.getRemarques().size());
        service.supprimerRemarque(e, r);
        assertEquals(0, e.getRemarques().size());
    }

    @Test
    public void testDeplacerEleve() {
        Eleve e = new Eleve(1, "Test", "Test");
        Table t1 = new Table(new Position(0, 0));
        Table t2 = new Table(new Position(1, 1));
        
        service.deplacerEleve(e, t1);
        assertEquals(t1, e.getTable());
        
        service.deplacerEleve(e, t2);
        assertEquals(t2, e.getTable());
    }

    @Test
    public void testAjouterRemarqueAndSupprimerRemarque() {
        Eleve e = new Eleve(1, "Test", "Test");
        Remarque r1 = service.ajouterRemarque(e, "Remarque1");
        Remarque r2 = service.ajouterRemarque(e, "Remarque2");
        assertEquals(2, e.getRemarques().size());
        
        service.supprimerRemarque(e, r1);
        assertEquals(1, e.getRemarques().size());
        assertTrue(e.getRemarques().contains(r2));
    }

    @Test
    public void testDeplacerEleveMultipleTimes() {
        Eleve e = new Eleve(1, "Test", "Test");
        Table t1 = new Table(new Position(0, 0));
        Table t2 = new Table(new Position(5, 5));
        Table t3 = new Table(new Position(10, 10));
        
        service.deplacerEleve(e, t1);
        assertEquals(t1, e.getTable());
        
        service.deplacerEleve(e, t2);
        assertEquals(t2, e.getTable());
        
        service.deplacerEleve(e, t3);
        assertEquals(t3, e.getTable());
    }

    @Test
    public void testAjouterRemarqueReturnsCorrectRemarque() {
        Eleve e = new Eleve(1, "Test", "Test");
        Remarque r = service.ajouterRemarque(e, "TestIntitule");
        assertEquals("TestIntitule", r.getIntitule());
    }

    @Test
    public void testSupprimerMultipleRemarques() {
        Eleve e = new Eleve(1, "Test", "Test");
        Remarque r1 = service.ajouterRemarque(e, "R1");
        Remarque r2 = service.ajouterRemarque(e, "R2");
        Remarque r3 = service.ajouterRemarque(e, "R3");
        assertEquals(3, e.getRemarques().size());
        
        service.supprimerRemarque(e, r1);
        service.supprimerRemarque(e, r2);
        assertEquals(1, e.getRemarques().size());
        assertEquals(r3, e.getRemarques().get(0));
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
