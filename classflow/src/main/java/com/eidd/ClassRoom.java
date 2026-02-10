package com.eidd;

import java.util.List;

public class ClassRoom {
    private Groupe eleves;
    private List<Table> tables;
    private int id;

    public ClassRoom(int id) {
        this.id = id;
    }

    public ClassRoom(Groupe eleves, List<Table> tables,int id) {
        this.eleves = eleves;
        this.tables = tables;
        this.id = id;
    }

    public Groupe getEleves() {
        return eleves;
    }

    public void setEleves(Groupe eleves) {
        this.eleves = eleves;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
