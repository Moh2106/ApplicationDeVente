package com.example.applicationdevente2.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DaoImpl<T> extends Serializable {
    public T add(T o) throws SQLException;
    public T update(T o) throws SQLException;
    public List<T> getAll() throws SQLException;
    public List<T> findByMotCle(String mot) throws SQLException;
    public void delete(int id) throws SQLException;

}
