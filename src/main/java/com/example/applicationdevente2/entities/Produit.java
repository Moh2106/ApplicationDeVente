package com.example.applicationdevente2.entities;

public class Produit {
    private int id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombre_en_stock;

    private Category category;
    public Produit() {
    }

    public Produit(int id, String nom, String marque, double prix, String description, int nombre_en_stock, Category category) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombre_en_stock = nombre_en_stock;
        this.category = category;
    }

    public Produit(String nom, String marque, double prix, String description, int nombre_en_stock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombre_en_stock = nombre_en_stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombre_en_stock() {
        return nombre_en_stock;
    }

    public void setNombre_en_stock(int nombre_en_stock) {
        this.nombre_en_stock = nombre_en_stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
