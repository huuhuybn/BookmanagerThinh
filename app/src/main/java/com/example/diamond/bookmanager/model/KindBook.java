package com.example.diamond.bookmanager.model;

public class KindBook {
    String id;
    String kindname;
    String mota;
    String vitri;

    public KindBook(String id, String kindname, String mota, String vitri) {
        this.id = id;
        this.kindname = kindname;
        this.mota = mota;
        this.vitri = vitri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
}
