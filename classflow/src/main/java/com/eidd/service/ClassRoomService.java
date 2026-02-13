package com.eidd.service;
import java.util.List;

import com.eidd.DTO.*;
import com.eidd.model.*;
import com.eidd.repositories.*;

public class ClassRoomService {
    private ClassRoomRespository classRoomRespository=new ClassRoomRespository();

    public void ajouterEleve(long id, Eleve eleve) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        classRoom.getEleves().addEleve(eleve);
    }


    public void supprimerEleve(long id, Eleve eleve) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        classRoom.getEleves().removeEleve(eleve);
    }

    public void ajouterTable(long id, Table table) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        classRoom.getTables().add(table);
    }

    public void supprimerTable(long id, Table table) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        classRoom.getTables().remove(table);
    }

    public ClassRoom creerClassRoom(String nom) {
        ClassRoom classRoom =new ClassRoom(nom);
        classRoomRespository.addClassRoom(classRoom);
        return classRoom;
    }
    public ClassRoom getClassRoomById(long id) {
        return classRoomRespository.getClassRoomById(id);
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRespository.getClassRooms();
    }
    public void supprimerClassRoom(long id) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        if (classRoom != null) {
            classRoomRespository.getClassRooms().remove(classRoom);
        }
    }
    public List<Eleve> getElevesByClassRoomId(long id) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        return classRoom.getEleves().getEleves();
    }

    public ClassRoomExport chargerClassRoom(long id){
        ClassRoom c=classRoomRespository.getClassRoomById(id);
        return(new ClassRoomExport(c));
    }

    public void sauvegarderClassRoom(ClassRoomExport classRoomExport){
        ClassRoom c=new ClassRoom(classRoomExport);
        classRoomRespository.addClassRoom(c);
    }
}
