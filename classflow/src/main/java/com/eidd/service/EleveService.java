package com.eidd.service;

import com.eidd.model.Eleve;
import com.eidd.model.Remarque;
import com.eidd.model.Table;

public class EleveService{

    public Remarque ajouterRemarque(Eleve eleve, String intitule) {
        Remarque remarque = new Remarque(intitule);
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