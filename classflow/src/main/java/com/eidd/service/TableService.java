package com.eidd.service;

import com.eidd.model.Position;
import com.eidd.model.Table;

public class TableService {
    public void deplacerTable(Table table, Position nouvellePosition) {
        table.setPosition(nouvellePosition);
    }
    public void deplacerTable(Table table, int x,int y) {
        table.setPosition(new Position(x, y));
    }
    public Table creerTable(int x, int y) {
        return new Table(new Position(x, y));
    }
    public Table creerTable(Position p) {
        return new Table(p);
    }
}
