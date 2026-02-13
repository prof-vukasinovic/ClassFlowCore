package com.eidd.DTO;

public class TableExport {
    private PositionExport position;

    public TableExport() {}

    public TableExport(PositionExport position) {
        this.position = position;
    }

    public TableExport(com.eidd.model.Table t) {
        if (t != null && t.getPosition() != null) {
            this.position = new PositionExport(t.getPosition());
        }
    }

    public PositionExport getPosition() {
        return position;
    }

    public void setPosition(PositionExport position) {
        this.position = position;
    }
}
