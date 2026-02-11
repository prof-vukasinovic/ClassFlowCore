package com.eidd;

import org.junit.jupiter.api.*;

import com.eidd.model.Eleve;
import com.eidd.model.Groupe;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class GroupeTest {

    @Test
    public void testGroupeCreation() {
        Groupe g = new Groupe();
        assertNotNull(g.getEleves());
        assertEquals(0, g.getEleves().size());
    }

    @Test
    public void testAddRemoveEleve() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "Dupont", "Jean");
        Eleve e2 = new Eleve(2, "Martin", "Lucie");
        g.addEleve(e1);
        g.addEleve(e2);
        List<Eleve> list = g.getEleves();
        assertEquals(2, list.size());
        g.removeEleve(e1);
        assertEquals(1, g.getEleves().size());
        List<Eleve> newList = new ArrayList<>();
        newList.add(e1);
        g.setEleves(newList);
        assertEquals(1, g.getEleves().size());
    }

    @Test
    public void testAddSingleEleve() {
        Groupe g = new Groupe();
        Eleve e = new Eleve(1, "Test", "Test");
        g.addEleve(e);
        assertEquals(1, g.getEleves().size());
        assertEquals(e, g.getEleves().get(0));
    }

    @Test
    public void testRemoveSingleEleve() {
        Groupe g = new Groupe();
        Eleve e = new Eleve(1, "Test", "Test");
        g.addEleve(e);
        g.removeEleve(e);
        assertEquals(0, g.getEleves().size());
    }

    @Test
    public void testSetEleves() {
        Groupe g = new Groupe();
        List<Eleve> eleves = new ArrayList<>();
        eleves.add(new Eleve(1, "Test1", "Test1"));
        eleves.add(new Eleve(2, "Test2", "Test2"));
        g.setEleves(eleves);
        assertEquals(2, g.getEleves().size());
    }

    @Test
    public void testMultipleAddAndRemove() {
        Groupe g = new Groupe();
        Eleve e1 = new Eleve(1, "E1", "E1");
        Eleve e2 = new Eleve(2, "E2", "E2");
        Eleve e3 = new Eleve(3, "E3", "E3");
        g.addEleve(e1);
        g.addEleve(e2);
        g.addEleve(e3);
        assertEquals(3, g.getEleves().size());
        g.removeEleve(e2);
        assertEquals(2, g.getEleves().size());
        assertEquals(e1, g.getEleves().get(0));
        assertEquals(e3, g.getEleves().get(1));
    }
}
