package com.eidd.model;

import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private List<Eleve> eleves;

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

}
