package com.eidd.model;

import jakarta.persistence.*;
@Entity
public class RemarqueBavardage extends Remarque {
    public RemarqueBavardage() {
        super();
    }

    public RemarqueBavardage(String intitule,Cours cours) {
        super(intitule, cours);
    }
}
