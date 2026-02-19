package com.eidd.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eidd.DTO.*;
import com.eidd.model.*;
import com.eidd.repositories.*;

@Service
public class ClassRoomService {
    private ClassRoomRepository classRoomRepository;

    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    public void ajouterEleve(long id, Eleve eleve) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        classRoom.getEleves().addEleve(eleve);
        classRoomRepository.save(classRoom);
    }

    public void supprimerEleve(long id, Eleve eleve) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        classRoom.getEleves().removeEleve(eleve);
        classRoomRepository.save(classRoom);
    }

    public void ajouterTable(long id, Table table) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        classRoom.getTables().add(table);
        classRoomRepository.save(classRoom);
    }

    public void supprimerTable(long id, Table table) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        classRoom.getTables().remove(table);
        classRoomRepository.save(classRoom);
    }

    public ClassRoomExport creerClassRoom(String nom) {
        ClassRoom classRoom =new ClassRoom(nom);
        classRoomRepository.save(classRoom);
        return new ClassRoomExport(classRoom);
    }
    public ClassRoomExport getClassRoomById(long id) {
        return new ClassRoomExport(classRoomRepository.findById(id).orElse(null));
    }

    public List<ClassRoomExport> getAllClassRooms() {
        List<ClassRoomExport> classRoomExports = new java.util.ArrayList<>();
        for (ClassRoom classRoom : classRoomRepository.findAll()) {
            classRoomExports.add(new ClassRoomExport(classRoom));
        }
        return classRoomExports;
    }
    public void supprimerClassRoom(long id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        if (classRoom != null) {
            classRoomRepository.delete(classRoom);
        }
    }
    public List<EleveExport> getElevesByClassRoomId(long id) {
        ClassRoom classRoom = classRoomRepository.findById(id).orElse(null);
        List<EleveExport> eleveExports = new java.util.ArrayList<>();
        for (Eleve eleve : classRoom.getEleves().getEleves()) {
            eleveExports.add(new EleveExport(eleve));
        }
        return eleveExports;
    }

    public ClassRoomExport chargerClassRoom(long id){
        ClassRoom c=classRoomRepository.findById(id).orElse(null);
        return(new ClassRoomExport(c));
    }

    public void sauvegarderClassRoom(ClassRoomExport classRoomExport){
        ClassRoom c=new ClassRoom(classRoomExport);
        classRoomRepository.save(c);
    }
}
