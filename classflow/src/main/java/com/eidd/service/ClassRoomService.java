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

    public ClassRoomExport creerClassRoom(String nom) {
        ClassRoom classRoom =new ClassRoom(nom);
        classRoomRespository.addClassRoom(classRoom);
        return new ClassRoomExport(classRoom);
    }
    public ClassRoomExport getClassRoomById(long id) {
        if(classRoomRespository.getClassRoomById(id)==null){
            return null;
        }
        return new ClassRoomExport(classRoomRespository.getClassRoomById(id));
    }

    public List<ClassRoomExport> getAllClassRooms() {
        List<ClassRoomExport> classRoomExports = new java.util.ArrayList<>();
        for (ClassRoom classRoom : classRoomRespository.getClassRooms()) {
            classRoomExports.add(new ClassRoomExport(classRoom));
        }
        return classRoomExports;
    }
    public void supprimerClassRoom(long id) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        if (classRoom != null) {
            classRoomRespository.getClassRooms().remove(classRoom);
        }
    }
    public List<EleveExport> getElevesByClassRoomId(long id) {
        ClassRoom classRoom = classRoomRespository.getClassRoomById(id);
        List<EleveExport> eleveExports = new java.util.ArrayList<>();
        for (Eleve eleve : classRoom.getEleves().getEleves()) {
            eleveExports.add(new EleveExport(eleve));
        }
        return eleveExports;
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
