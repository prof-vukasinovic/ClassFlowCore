package com.eidd.DTO;

import org.junit.jupiter.api.*;
import com.eidd.model.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GroupeExportTest {

    @Test
    public void testGroupeExportCreation() {
        GroupeExport ge = new GroupeExport();
        assertNotNull(ge);
        assertNotNull(ge.getEleves());
        assertEquals(0, ge.getEleves().size());
    }

    @Test
    public void testGroupeExportFromModel() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "Dupont", "Jean");
        Eleve e2 = new Eleve(2, "Martin", "Lucie");
        g.addEleve(e1);
        g.addEleve(e2);
        GroupeExport ge = new GroupeExport(g);
        assertEquals(2, ge.getEleves().size());
    }

    @Test
    public void testGroupeExportGettersSetters() {
        GroupeExport ge = new GroupeExport();
        List<EleveExport> eleves = ge.getEleves();
        assertNotNull(eleves);
        assertEquals(0, eleves.size());
    }

    @Test
    public void testGroupeExportElevesManagement() {
        GroupeExport ge = new GroupeExport();
        EleveExport ee1 = new EleveExport();
        ee1.setId(1);
        ee1.setNom("Nom1");
        ee1.setPrenom("Prenom1");
        
        ge.getEleves().add(ee1);
        assertEquals(1, ge.getEleves().size());
    }

    @Test
    public void testGroupeExportMultipleEleves() {
        GroupeExport ge = new GroupeExport();
        EleveExport ee1 = new EleveExport();
        ee1.setId(1);
        EleveExport ee2 = new EleveExport();
        ee2.setId(2);
        EleveExport ee3 = new EleveExport();
        ee3.setId(3);
        
        ge.getEleves().add(ee1);
        ge.getEleves().add(ee2);
        ge.getEleves().add(ee3);
        
        assertEquals(3, ge.getEleves().size());
    }

    @Test
    public void testGroupeExportElevesListIndependence() {
        GroupeExport ge1 = new GroupeExport();
        GroupeExport ge2 = new GroupeExport();
        
        EleveExport ee1 = new EleveExport();
        ee1.setId(1);
        ge1.getEleves().add(ee1);
        
        assertEquals(1, ge1.getEleves().size());
        assertEquals(0, ge2.getEleves().size());
    }
}
