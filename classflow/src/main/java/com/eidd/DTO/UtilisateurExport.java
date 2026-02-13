package com.eidd.DTO;

public class UtilisateurExport {
    private String nom;
    private String prenom;

    public UtilisateurExport() {}

    public UtilisateurExport(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public UtilisateurExport(com.eidd.model.Utilisateur u) {
        if (u != null) {
            this.nom = u.getNom();
            this.prenom = u.getPrenom();
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
