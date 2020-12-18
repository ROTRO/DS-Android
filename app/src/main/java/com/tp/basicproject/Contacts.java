package com.tp.basicproject;


public class Contacts {

    private String nom;
    private String tel;
    private int image;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Contacts(String nom, String tel, int image) {
        this.nom = nom;
        this.tel = tel;
        this.image = image;
    }
}



