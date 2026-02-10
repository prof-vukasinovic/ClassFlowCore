package com.eidd;
import java.util.ArrayList;
import java.util.List;

public class Eleve extends Utilisateur{
    private int id;
    private List<Remarque> remarques;

    public Eleve(int id, String nom, String prenom) {
        super(nom, prenom);
        this.id = id;
        this.remarques = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
