package com.example.applicationdevente2.service;

import com.example.applicationdevente2.dao.ProduitDao;
import com.example.applicationdevente2.entities.Produit;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProduitService implements ServiceImpl<Produit>{

    public ProduitService() {
    }

    @Override
    public Produit add(Produit p) throws SQLException {
        ProduitDao produitDao = new ProduitDao();
        produitDao.add(p);
        return p;
    }

    @Override
    public List<Produit> getAll() throws SQLException {
        ProduitDao produitDao = new ProduitDao();
        List<Produit> prod = new ArrayList<>();
        Produit p = new Produit();
        prod = produitDao.getAll();
        return prod;
    }

    @Override
    public void deleteProd(Produit p) throws SQLException {
        ProduitDao produitDao = new ProduitDao();
        produitDao.delete(p.getId());
    }

    @Override
    public List<Produit> findByMotClé(String mot) throws SQLException {
        ProduitDao produitDao = new ProduitDao();
        List<Produit> prod = new ArrayList<>();
        prod = produitDao.findByMotCle(mot);
        return prod;
    }

    @Override
    public Produit updateProd(Produit p) throws SQLException {
        new ProduitDao().update(p);

        return p;
    }

}