package com.eidd.DTO;
public class RemarqueExport {
    private String intitule;
    private long id;
    private CoursExport cours;

    public RemarqueExport() {}

    public RemarqueExport(String intitule, long id,CoursExport cours) {
        this.intitule = intitule;
        this.id = id;
        this.cours = cours;
    }

    public RemarqueExport(com.eidd.model.Remarque r) {
        if (r != null) {
            this.intitule = r.getIntitule();
            this.id = r.getId();
            this.cours = new CoursExport(r.getCours());
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
    public CoursExport getCours() {
        return cours;
    }

    public void setCours(CoursExport cours) {
        this.cours = cours;
    }
}
