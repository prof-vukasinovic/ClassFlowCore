package com.eidd.model;

import java.util.Date;

public class Cours {
    private int numero;
    private Date date;

    public Cours(int numero, Date date) {
        this.numero = numero;
        this.date = date;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
        
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
