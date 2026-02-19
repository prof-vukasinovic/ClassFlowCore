package com.eidd.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
@JsonPropertyOrder({"id", "nom", "prénom"})
public class EleveExport extends UtilisateurExport{
    @JsonIgnore 
    private List<RemarqueExport> remarques = new ArrayList<>();
    @JsonIgnore
    private TableExport table;

    public EleveExport() {}

    public EleveExport(com.eidd.model.Eleve e) {
        super(e);
        if (e != null) {
            if (e.getRemarques() != null) {
                for (com.eidd.model.Remarque r : e.getRemarques()) {
                    this.remarques.add(new RemarqueExport(r));
                }
            }
            if (e.getTable() != null) {
                this.table = new TableExport(e.getTable());
            }
        }
    }


    public List<RemarqueExport> getRemarques() {
        return remarques;
    }

    public void setRemarques(List<RemarqueExport> remarques) {
        this.remarques = remarques;
    }

    public TableExport getTable() {
        return table;
    }

    public void setTable(TableExport table) {
        this.table = table;
    }
}
