package com.eidd.DTO;
import com.eidd.model.*;
import java.util.Date;

public class CoursExport {
    private Date date;
    private int numero;
    public CoursExport() {}
    public CoursExport(Cours cours) {
        this.numero = cours.getNumero();
        this.date = cours.getDate();
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getNumero() {
        return numero;  
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
