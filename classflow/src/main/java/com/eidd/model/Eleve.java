package com.eidd.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Eleve extends Utilisateur{
    @OneToMany(cascade = CascadeType.ALL)
    private List<Remarque> remarques;
    @Embedded    
    private Table table;



    public Eleve() {
        super();
        this.remarques = new ArrayList<>();
    }

    public Eleve(String nom, String prenom) {
        super(nom, prenom);
        this.remarques = new ArrayList<>();
    }

    public Eleve(com.eidd.DTO.EleveExport dto) {
        super((dto != null) ? new com.eidd.DTO.UtilisateurExport(dto.getNom(), dto.getPrenom()) : null);
        this.remarques = new ArrayList<>();
        if (dto != null) {
            if (dto.getRemarques() != null) {
                for (com.eidd.DTO.RemarqueExport re : dto.getRemarques()) {
                    this.remarques.add(new Remarque(re));
                }
            }
            if (dto.getTable() != null) this.table = new Table(dto.getTable());
        }
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
    public long getId() {
        return super.getId();
    }
    public void setId(long id) {
        super.setId(id);
    }
}
