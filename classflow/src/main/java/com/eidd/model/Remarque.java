package com.eidd.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Remarque {

    private String intitule;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Embedded
    private Cours cours;
    public Remarque() {
    }

    public Remarque(String intitule, Cours cours) {
        this.intitule = intitule;
        this.cours = cours;
    }

    public Remarque(com.eidd.DTO.RemarqueExport dto) {
        if (dto != null) {
            this.intitule = dto.getIntitule();
            this.id = dto.getId();
        }
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cours getCours() {
        return cours;
    }
    public void setCours(Cours cours) {
        this.cours = cours;
    }

}
