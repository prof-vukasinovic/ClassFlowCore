package com.eidd.DTO;
import org.junit.jupiter.api.*;
import com.eidd.model.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.List;

public class EleveExportTest {
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
    public void testEleveExportCreation() {
        EleveExport ee = new EleveExport();
        assertNotNull(ee);
        assertNull(ee.getNom());
        assertNull(ee.getPrenom());
        assertEquals(0, ee.getId());
        assertNotNull(ee.getRemarques());
    }

    @Test
    public void testEleveExportFromModel() {
        Eleve e = new Eleve(1, "Dupont", "Jean");
        EleveExport ee = new EleveExport(e);
        assertEquals("Dupont", ee.getNom());
        assertEquals("Jean", ee.getPrenom());
        assertEquals(1, ee.getId());
    }

    @Test
    public void testEleveExportFromModelWithRemarques() {
        Eleve e = new Eleve(1, "Dupont", "Jean");
        Cours c1 = new Cours(1, new java.util.Date());
        Cours c2 = new Cours(2, new java.util.Date());
        Remarque r1 = new Remarque("Remarque1", c1);
        Remarque r2 = new Remarque("Remarque2", c2);
        e.addRemarque(r1);
        e.addRemarque(r2);
        EleveExport ee = new EleveExport(e);
        assertEquals("Dupont", ee.getNom());
        assertEquals(1, ee.getId());
        assertEquals(2, ee.getRemarques().size());
    }

    @Test
    public void testEleveExportFromNullModel() {
        EleveExport ee = new EleveExport(null);
        assertNull(ee.getNom());
        assertNull(ee.getPrenom());
    }

    @Test
    public void testEleveExportGettersSetters() {
        EleveExport ee = new EleveExport();
        ee.setId(5);
        ee.setNom("TestNom");
        ee.setPrenom("TestPrenom");
        assertEquals(5, ee.getId());
        assertEquals("TestNom", ee.getNom());
        assertEquals("TestPrenom", ee.getPrenom());
    }

    @Test
    public void testEleveExportRemarquesManagement() {
        EleveExport ee = new EleveExport();
        List<RemarqueExport> remarques = ee.getRemarques();
        assertEquals(0, remarques.size());
        Cours c = new Cours(1, new java.util.Date());
        CoursExport ce = new CoursExport(c);
        RemarqueExport re = new RemarqueExport("NewRemarque", 1, ce);
        remarques.add(re);
        assertEquals(1, ee.getRemarques().size());
    }

    @Test
    public void testEleveExportTableAssignment() {
        EleveExport ee = new EleveExport();
        TableExport te = new TableExport();
        ee.setTable(te);
        assertEquals(te, ee.getTable());
    }

    @Test
    public void testEleveExportMultipleObjects() {
        EleveExport ee1 = new EleveExport();
        ee1.setId(1);
        ee1.setNom("Nom1");
        ee1.setPrenom("Prenom1");
        
        EleveExport ee2 = new EleveExport();
        ee2.setId(2);
        ee2.setNom("Nom2");
        ee2.setPrenom("Prenom2");
        
        assertEquals(1, ee1.getId());
        assertEquals(2, ee2.getId());
        assertEquals("Nom1", ee1.getNom());
        assertEquals("Nom2", ee2.getNom());
    }

    @AfterEach
    public void tearDown() {
        RemarqueToolKit.changeDataFile("src/main/resources/dataRemarques.txt");
        File f = new File(dataFile);
        if (f.exists()) f.delete();
    }
}
