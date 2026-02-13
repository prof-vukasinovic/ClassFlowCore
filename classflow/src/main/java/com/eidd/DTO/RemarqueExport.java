package com.eidd.DTO;

public class RemarqueExport {
    private String intitule;
    private long id;

    public RemarqueExport() {}

    public RemarqueExport(String intitule, long id) {
        this.intitule = intitule;
        this.id = id;
    }

    public RemarqueExport(com.eidd.model.Remarque r) {
        if (r != null) {
            this.intitule = r.getIntitule();
            this.id = r.getId();
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
