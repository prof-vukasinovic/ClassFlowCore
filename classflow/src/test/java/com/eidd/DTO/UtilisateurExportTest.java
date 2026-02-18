package com.eidd.DTO;

import org.junit.jupiter.api.*;
import com.eidd.model.Utilisateur;
import com.eidd.model.Eleve;

import static org.junit.jupiter.api.Assertions.*;

public class UtilisateurExportTest {

    @Test
    public void testUtilisateurExportCreation() {
        UtilisateurExport ue = new UtilisateurExport();
        assertNotNull(ue);
        assertNull(ue.getNom());
        assertNull(ue.getPrenom());
    }

    @Test
    public void testUtilisateurExportWithParameters() {
        UtilisateurExport ue = new UtilisateurExport("Dupont", "Jean");
        assertEquals("Dupont", ue.getNom());
        assertEquals("Jean", ue.getPrenom());
    }

    @Test
    public void testUtilisateurExportFromModel() {
        Utilisateur u = new Eleve(1, "Martin", "Lucie");
        UtilisateurExport ue = new UtilisateurExport(u);
        assertEquals("Martin", ue.getNom());
        assertEquals("Lucie", ue.getPrenom());
    }

    @Test
    public void testUtilisateurExportFromNullModel() {
        UtilisateurExport ue = new UtilisateurExport(null);
        assertNull(ue.getNom());
        assertNull(ue.getPrenom());
    }

    @Test
    public void testUtilisateurExportGettersSetters() {
        UtilisateurExport ue = new UtilisateurExport();
        ue.setNom("TestNom");
        ue.setPrenom("TestPrenom");
        assertEquals("TestNom", ue.getNom());
        assertEquals("TestPrenom", ue.getPrenom());
    }

    @Test
    public void testUtilisateurExportModification() {
        UtilisateurExport ue = new UtilisateurExport("Original", "Name");
        ue.setNom("Modified");
        ue.setPrenom("Changed");
        assertEquals("Modified", ue.getNom());
        assertEquals("Changed", ue.getPrenom());
    }

    @Test
    public void testUtilisateurExportMultipleObjects() {
        UtilisateurExport ue1 = new UtilisateurExport("Nom1", "Prenom1");
        UtilisateurExport ue2 = new UtilisateurExport("Nom2", "Prenom2");
        UtilisateurExport ue3 = new UtilisateurExport("Nom3", "Prenom3");
        assertEquals("Nom1", ue1.getNom());
        assertEquals("Nom2", ue2.getNom());
        assertEquals("Nom3", ue3.getNom());
    }

    @Test
    public void testUtilisateurExportNullFields() {
        UtilisateurExport ue = new UtilisateurExport("Nom", "Prenom");
        ue.setNom(null);
        ue.setPrenom(null);
        assertNull(ue.getNom());
        assertNull(ue.getPrenom());
    }
}
