package com.eidd.model;

import java.util.ArrayList;
import java.util.List;

public class Groupe {
    private List<Eleve> eleves;

    public Groupe() {
        this.eleves = new ArrayList<>();
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
