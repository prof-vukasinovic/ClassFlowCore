package com.eidd.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Groupe {
    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<Eleve> eleves;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    public Groupe() {
        this.eleves = new ArrayList<>();
    }

    public Groupe(com.eidd.DTO.GroupeExport dto) {
        this.eleves = new ArrayList<>();
        if (dto != null && dto.getEleves() != null) {
            for (com.eidd.DTO.EleveExport ee : dto.getEleves()) {
                this.eleves.add(new Eleve(ee));
            }
        }
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    public void addEleve(Eleve eleve) {
        this.eleves.add(eleve);
    }

    public void removeEleve(Eleve eleve) {
        this.eleves.remove(eleve);
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
