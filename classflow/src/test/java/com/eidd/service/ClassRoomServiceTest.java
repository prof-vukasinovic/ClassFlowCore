package com.eidd.service;
import com.eidd.DTO.*;
import com.eidd.model.*;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import com.eidd.repositories.*;
public class ClassRoomServiceTest {
        private ClassRoomService service;

        @BeforeEach
        public void setUp() {
            service = new ClassRoomService();
            ClassRoomRespository.resetCounter();
        }

        @AfterEach
        public void tearDown() {
            ClassRoomRespository.resetCounter();
        }

        @Test
        public void creerClassRoom_returnsExportWithCorrectNameAndId() {
            ClassRoomExport exp = service.creerClassRoom("Salle 1");
            assertNotNull(exp);
            assertEquals("Salle 1", exp.getNom());
            assertTrue(exp.getId() >= 0);
        }

        @Test
        public void getClassRoomById_returnsSameExport() {
            ClassRoomExport created = service.creerClassRoom("TestRoom");
            ClassRoomExport retrieved = service.getClassRoomById(created.getId());
            assertNotNull(retrieved);
            assertEquals(created.getId(), retrieved.getId());
            assertEquals(created.getNom(), retrieved.getNom());
        }

        @Test
        public void getAllClassRooms_returnsAllCreated() {
            ClassRoomExport r1 = service.creerClassRoom("Room1");
            ClassRoomExport r2 = service.creerClassRoom("Room2");
            List<ClassRoomExport> rooms = service.getAllClassRooms();
            assertEquals(2, rooms.size());
            assertTrue(rooms.stream().anyMatch(r -> r.getId() == r1.getId()));
            assertTrue(rooms.stream().anyMatch(r -> r.getId() == r2.getId()));
        }

        @Test
        public void ajouterEtSupprimerEleve_updatesElevesList() {
            ClassRoomExport cr = service.creerClassRoom("Room");
            Eleve e1 = new Eleve(1, "E1", "P1");
            Eleve e2 = new Eleve(2, "E2", "P2");

            service.ajouterEleve(cr.getId(), e1);
            service.ajouterEleve(cr.getId(), e2);

            List<EleveExport> eleves = service.getElevesByClassRoomId(cr.getId());
            assertEquals(2, eleves.size());

            service.supprimerEleve(cr.getId(), e1);
            eleves = service.getElevesByClassRoomId(cr.getId());
            assertEquals(1, eleves.size());
            assertEquals(e2.getPrenom(), eleves.get(0).getPrenom());
        }

        @Test
        public void ajouterEtSupprimerTable_updatesTablesList() {
            ClassRoomExport cr = service.creerClassRoom("Room");
            Table t1 = new Table(new Position(1, 1));
            Table t2 = new Table(new Position(2, 2));

            service.ajouterTable(cr.getId(), t1);
            service.ajouterTable(cr.getId(), t2);

            ClassRoomExport exported = service.getClassRoomById(cr.getId());
            assertEquals(2, exported.getTables().size());

            service.supprimerTable(cr.getId(), t1);
            exported = service.getClassRoomById(cr.getId());
            assertEquals(1, exported.getTables().size());
            TableExport remaining = exported.getTables().get(0);
            assertEquals(2, remaining.getPosition().getX());
            assertEquals(2, remaining.getPosition().getY());
        }

        @Test
        public void supprimerClassRoom_removesIt() {
            ClassRoomExport cr = service.creerClassRoom("ToRemove");
            long id = cr.getId();
            service.supprimerClassRoom(id);
            ClassRoomExport retrieved = service.getClassRoomById(id);
            assertNull(retrieved);
        }

        @Test
        public void sauvegarderEtChargerClassRoom_roundTrip() {
            ClassRoomExport created = service.creerClassRoom("Original");
            service.sauvegarderClassRoom(created);
            List<ClassRoomExport> rooms = service.getAllClassRooms();
            assertTrue(rooms.size() >= 2);
        }
    }
