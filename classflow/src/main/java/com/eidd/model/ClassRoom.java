package com.eidd.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class ClassRoom {
    @OneToOne(cascade = CascadeType.ALL)
    private Groupe eleves;
    @ElementCollection
    private List<Table> tables;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    @Column(name = "owner")
    private String owner;

    
    public ClassRoom() {
        this.eleves = new Groupe();
        this.tables = new java.util.ArrayList<>();
    }

    public ClassRoom(String nom) {
        this.nom = nom;
        this.eleves = new Groupe();
        this.tables = new java.util.ArrayList<>();
    }

    public ClassRoom(Groupe eleves, List<Table> tables) {
        this.eleves = eleves;
        this.tables = tables;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
