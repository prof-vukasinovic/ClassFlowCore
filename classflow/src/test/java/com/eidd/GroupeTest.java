package com.eidd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class GroupeTest {

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
}
