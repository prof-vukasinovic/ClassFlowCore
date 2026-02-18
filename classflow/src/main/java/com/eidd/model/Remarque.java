package com.eidd.model;

public class Remarque {
    private String intitule;
    private long id;
    private Cours cours;
    public Remarque(String intitule, Cours cours) {
        this.intitule = intitule;
        this.cours = cours;
        try{
            this.id=RemarqueToolKit.getNewRemarqueId(intitule);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Remarque(com.eidd.DTO.RemarqueExport dto) {
        if (dto != null) {
            this.intitule = dto.getIntitule();
            this.id = dto.getId();
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

    public Cours getCours() {
        return cours;
    }
    public void setCours(Cours cours) {
        this.cours = cours;
    }

}
