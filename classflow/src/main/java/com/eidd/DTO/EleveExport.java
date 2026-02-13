package com.eidd.DTO;

import java.util.List;
import java.util.ArrayList;

public class EleveExport extends UtilisateurExport{
    private long id;
    private List<RemarqueExport> remarques = new ArrayList<>();
    private TableExport table;

    public EleveExport() {}

    public EleveExport(com.eidd.model.Eleve e) {
        super(e);
        if (e != null) {
            this.id = e.getId();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
