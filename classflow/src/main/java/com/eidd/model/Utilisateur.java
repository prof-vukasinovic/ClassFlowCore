package com.eidd.model;

public abstract class Utilisateur {
    private String nom;
    private String prenom;

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
}
