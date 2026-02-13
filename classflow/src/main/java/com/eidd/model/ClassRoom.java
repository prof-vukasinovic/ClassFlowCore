package com.eidd.model;
import java.util.List;

import com.eidd.repositories.ClassRoomRespository;

public class ClassRoom {
    private Groupe eleves;
    private List<Table> tables;
    private long id;
    private String nom;

    
    public ClassRoom(String nom) {
        this.id = ClassRoomRespository.getCounter();
        ClassRoomRespository.incrementCounter();
        this.nom = nom;
    }

    public ClassRoom(Groupe eleves, List<Table> tables) {
        this.eleves = eleves;
        this.tables = tables;
        this.id = ClassRoomRespository.getCounter();
        ClassRoomRespository.incrementCounter();
    }

    public ClassRoom(com.eidd.DTO.ClassRoomExport dto) {
        if (dto != null) {
            this.id = dto.getId();
            this.nom = dto.getNom();
            if (dto.getEleves() != null) this.eleves = new Groupe(dto.getEleves());
            if (dto.getTables() != null) {
                this.tables = new java.util.ArrayList<>();
                for (com.eidd.DTO.TableExport te : dto.getTables()) {
                    this.tables.add(new Table(te));
                }
            }
        }
    }

    public Groupe getEleves() {
        return eleves;
    }

    public void setEleves(Groupe eleves) {
        this.eleves = eleves;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
