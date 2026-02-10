package com.eidd;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomTest {

    @Test
    public void testGettersSetters() {
        Groupe g = new Groupe();
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(new Position(1,1)));
        ClassRoom cr = new ClassRoom(g, tables, 42);
        assertEquals(g, cr.getEleves());
        assertEquals(tables, cr.getTables());
        assertEquals(42, cr.getId());
        cr.setId(7);
        assertEquals(7, cr.getId());
    }
}
