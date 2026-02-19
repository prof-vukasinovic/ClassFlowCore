package com.eidd.model;
import jakarta.persistence.*;
@Entity
public class Devoir extends Remarque {
    public Devoir() {
        super();
    }

    public Devoir(String intitule, Cours cours) {
        super(intitule, cours);
    }
}
