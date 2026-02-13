package com.eidd.DTO;

public class PositionExport {
    private int x;
    private int y;

    public PositionExport() {}

    public PositionExport(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionExport(com.eidd.model.Position p) {
        if (p != null) {
            this.x = p.getX();
            this.y = p.getY();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
