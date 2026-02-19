package com.eidd.model;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Utilisateur {
    private String nom;
    private String prenom;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Utilisateur(com.eidd.DTO.UtilisateurExport dto) {
        if (dto != null) {
            this.nom = dto.getNom();
            this.prenom = dto.getPrenom();
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
