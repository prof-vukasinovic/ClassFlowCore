package com.eidd.model;
import java.util.ArrayList;
import java.util.List;

public class Eleve extends Utilisateur{
    private long id;
    private List<Remarque> remarques;
    private Table table;



    public Eleve(long id, String nom, String prenom) {
        super(nom, prenom);
        this.id = id;
        this.remarques = new ArrayList<>();
    }

    public Eleve(com.eidd.DTO.EleveExport dto) {
        super((dto != null) ? new com.eidd.DTO.UtilisateurExport(dto.getNom(), dto.getPrenom()) : null);
        this.remarques = new ArrayList<>();
        if (dto != null) {
            this.id = dto.getId();
            if (dto.getRemarques() != null) {
                for (com.eidd.DTO.RemarqueExport re : dto.getRemarques()) {
                    this.remarques.add(new Remarque(re));
                }
            }
            if (dto.getTable() != null) this.table = new Table(dto.getTable());
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Remarque> getRemarques() {
        return remarques;
    }

    public void addRemarque(Remarque remarque) {
        this.remarques.add(remarque);
    }

    public void removeRemarque(Remarque remarque) {
        this.remarques.remove(remarque);
    }
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
