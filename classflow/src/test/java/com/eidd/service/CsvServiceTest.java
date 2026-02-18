package com.eidd.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.eidd.DTO.ClassRoomExport;
import com.eidd.DTO.GroupeExport;
import com.eidd.DTO.EleveExport;

public class CsvServiceTest {

    @Test
    public void testExportToCsv_singleEleve() {
        ClassRoomExport cre = new ClassRoomExport();
        GroupeExport g = new GroupeExport();
        EleveExport e = new EleveExport();
        e.setId(1);
        e.setNom("Doe");
        e.setPrenom("John");
        g.addEleve(e);
        cre.setEleves(g);

        String csv = CsvService.exportToCsv(cre);
        assertNotNull(csv);
        assertTrue(csv.contains("Doe"));
        assertTrue(csv.contains("John"));
    }

    @Test
    public void testExportToCsv_multipleEleves() {
        ClassRoomExport cre = new ClassRoomExport();
        GroupeExport g = new GroupeExport();
        EleveExport e1 = new EleveExport();
        e1.setId(1);
        e1.setNom("E1");
        e1.setPrenom("P1");
        EleveExport e2 = new EleveExport();
        e2.setId(2);
        e2.setNom("E2");
        e2.setPrenom("P2");
        g.addEleve(e1);
        g.addEleve(e2);
        cre.setEleves(g);

        String csv = CsvService.exportToCsv(cre);
        assertNotNull(csv);
        assertTrue(csv.contains("E1"));
        assertTrue(csv.contains("E2"));
        String[] lines = csv.split("\\r?\\n");
        assertTrue(lines.length >= 3);
    }

    @Test
    public void testImportFromCsv_isNullByDefault() {
        ClassRoomExport cre = new ClassRoomExport();
        GroupeExport g = new GroupeExport();
        EleveExport e1 = new EleveExport();
        e1.setId(1);
        e1.setNom("E1");
        e1.setPrenom("P1");
        EleveExport e2 = new EleveExport();
        e2.setId(2);
        e2.setNom("E2");
        e2.setPrenom("P2");
        g.addEleve(e1);
        g.addEleve(e2);
        cre.setEleves(g);

        String csv = CsvService.exportToCsv(cre);
        ClassRoomExport result = CsvService.importFromCsv(csv);
        assertNotNull(result);
        assertNotNull(result.getEleves());
        assertEquals(2, result.getEleves().getEleves().size());
        EleveExport e = result.getEleves().getEleves().get(0);
        assertEquals(1, e.getId());
        assertEquals("E1", e.getNom());
        assertEquals("P1", e.getPrenom());
    }
}
