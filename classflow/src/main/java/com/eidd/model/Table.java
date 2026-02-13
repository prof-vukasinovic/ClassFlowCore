package com.eidd.model;

public class Table {
    private Position position;

    public Table(Position position) {
        this.position = position;
    }

    public Table(com.eidd.DTO.TableExport dto) {
        if (dto != null && dto.getPosition() != null) {
            this.position = new Position(dto.getPosition());
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    

}
