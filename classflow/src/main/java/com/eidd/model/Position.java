package com.eidd.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Position {
    private int x;
    private int y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(com.eidd.DTO.PositionExport dto) {
        if (dto != null) {
            this.x = dto.getX();
            this.y = dto.getY();
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
