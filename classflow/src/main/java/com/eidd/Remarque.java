package com.eidd;

public class Remarque {
    private String intitule;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
