package com.eidd.service;

import com.eidd.model.Eleve;
import com.eidd.model.Groupe;

public class GroupeService {
    

    public Eleve tirerEleveAuSort(Groupe groupe) {
        if (groupe.getEleves().isEmpty()) {
            return null;
        }
        int index = (int) (Math.random() * groupe.getEleves().size());
        return groupe.getEleves().get(index);
    }

    public void ajouterEleve(Groupe groupe, Eleve eleve) {
        groupe.addEleve(eleve);
    }
    public void supprimerEleve(Groupe groupe, Eleve eleve) {
        groupe.removeEleve(eleve);
    }

}
