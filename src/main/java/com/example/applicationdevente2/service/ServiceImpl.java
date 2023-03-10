package com.example.applicationdevente2.service;

import com.example.applicationdevente2.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ServiceImpl<T> {
    public T add(T o) throws SQLException;
    public List<T> getAll() throws SQLException;
    public void deleteProd(T o) throws SQLException;
    public List<T> findByMotClé(String mot) throws SQLException;
    public T updateProd(T o) throws SQLException;
}
