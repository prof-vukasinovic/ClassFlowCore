package com.eidd.DTO;

import java.util.List;
import java.util.ArrayList;

public class GroupeExport {
    private List<EleveExport> eleves = new ArrayList<>();

    public GroupeExport() {}

    public GroupeExport(com.eidd.model.Groupe g) {
        if (g != null && g.getEleves() != null) {
            for (com.eidd.model.Eleve e : g.getEleves()) {
                this.eleves.add(new EleveExport(e));
            }
        }
    }

    public List<EleveExport> getEleves() {
        return eleves;
    }

    public void setEleves(List<EleveExport> eleves) {
        this.eleves = eleves;
    }

    public void addEleve(EleveExport eleve) {
        this.eleves.add(eleve);
    }

    public void removeEleve(EleveExport eleve) {
        this.eleves.remove(eleve);
    }
}
