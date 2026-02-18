package com.eidd.service;
import com.eidd.model.*;

public class EleveService{

    public Remarque ajouterRemarque(Eleve eleve, String intitule,Cours cours) {
        Remarque remarque = new Remarque(intitule, cours);
        eleve.addRemarque(remarque);
        return remarque;
    }
    public void supprimerRemarque(Eleve eleve, Remarque remarque) {
        eleve.removeRemarque(remarque);
    }
    public void deplacerEleve(Eleve eleve, Table nouvelleTable) {
        eleve.setTable(nouvelleTable);
    }



}