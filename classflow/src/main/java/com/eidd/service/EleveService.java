package com.eidd.service;
import org.springframework.stereotype.Service;

import com.eidd.model.*;

@Service
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