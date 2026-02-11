package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.Eleve;
import com.eidd.model.Groupe;
import com.eidd.service.GroupeService;

import static org.junit.jupiter.api.Assertions.*;

public class GroupeServiceTest {
    private GroupeService service;

    @BeforeEach
    public void setUp() {
        service = new GroupeService();
    }

    @Test
    public void testAjouterEleve() {
        Groupe g = new Groupe();
        Eleve e = new Eleve(1, "Test", "Test");
        service.ajouterEleve(g, e);
        assertEquals(1, g.getEleves().size());
        assertTrue(g.getEleves().contains(e));
    }

    @Test
    public void testAjouterMultipleEleves() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        Eleve e3 = new Eleve(3, "E3", "E3");
        
        service.ajouterEleve(g, e1);
        service.ajouterEleve(g, e2);
        service.ajouterEleve(g, e3);
        
        assertEquals(3, g.getEleves().size());
    }

    @Test
    public void testSupprimerEleve() {
        Groupe g = new Groupe();
        Eleve e = new Eleve(1, "Test", "Test");
        service.ajouterEleve(g, e);
        assertEquals(1, g.getEleves().size());
        
        service.supprimerEleve(g, e);
        assertEquals(0, g.getEleves().size());
    }

    @Test
    public void testTirerEleveAuSortWithOneEleve() {
        Groupe g = new Groupe();
        Eleve e = new Eleve(1, "Test", "Test");
        service.ajouterEleve(g, e);
        
        Eleve tiré = service.tirerEleveAuSort(g);
        assertNotNull(tiré);
        assertEquals(e, tiré);
    }

    @Test
    public void testTirerEleveAuSortWithMultipleEleves() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        Eleve e3 = new Eleve(3, "E3", "E3");
        
        service.ajouterEleve(g, e1);
        service.ajouterEleve(g, e2);
        service.ajouterEleve(g, e3);
        
        Eleve tiré = service.tirerEleveAuSort(g);
        assertNotNull(tiré);
        assertTrue(g.getEleves().contains(tiré));
    }

    @Test
    public void testTirerEleveAuSortWithEmptyGroupe() {
        Groupe g = new Groupe();
        Eleve tiré = service.tirerEleveAuSort(g);
        assertNull(tiré);
    }

    @Test
    public void testAjouterEtSupprimerEleve() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        Eleve e3 = new Eleve(3, "E3", "E3");
        
        service.ajouterEleve(g, e1);
        service.ajouterEleve(g, e2);
        service.ajouterEleve(g, e3);
        assertEquals(3, g.getEleves().size());
        
        service.supprimerEleve(g, e2);
        assertEquals(2, g.getEleves().size());
        assertTrue(g.getEleves().contains(e1));
        assertTrue(g.getEleves().contains(e3));
        assertFalse(g.getEleves().contains(e2));
    }

    @Test
    public void testTirerEleveAuSortMultipleTimes() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        
        service.ajouterEleve(g, e1);
        service.ajouterEleve(g, e2);
        
        // Tire plusieurs fois et vérifie que les élèves tirés sont dans le groupe
        for (int i = 0; i < 10; i++) {
            Eleve tiré = service.tirerEleveAuSort(g);
            assertNotNull(tiré);
            assertTrue(g.getEleves().contains(tiré));
        }
    }

    @Test
    public void testAjouterEleveMultipleFois() {
        Groupe g = new Groupe();
        Eleve e = new Eleve(1, "Test", "Test");
        service.ajouterEleve(g, e);
        service.ajouterEleve(g, e);
        // Ajoute deux fois le même élève
        assertEquals(2, g.getEleves().size());
    }

    @Test
    public void testSupprimerEleveNotInGroupe() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        
        service.ajouterEleve(g, e1);
        service.supprimerEleve(g, e2);
        // e2 n'était pas dans le groupe, le groupe doit toujours contenir e1
        assertEquals(1, g.getEleves().size());
        assertTrue(g.getEleves().contains(e1));
    }
}
