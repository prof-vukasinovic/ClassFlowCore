package com.eidd.model;

public class Remarque {
    private String intitule;
    private long id;

    public Remarque(String intitule) {
        this.intitule = intitule;
        try{
            this.id=RemarqueToolKit.getNewRemarqueId(intitule);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
