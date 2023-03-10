package com.example.applicationdevente2.service;

import com.example.applicationdevente2.dao.CategoryDao;
import com.example.applicationdevente2.dao.CreateConnection;
import com.example.applicationdevente2.entities.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ServiceImpl<Category> {

    public CategoryService() {
    }


    @Override
    public Category add(Category c) throws SQLException {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.add(c);
        return c;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.getAll();
    }

    @Override
    public void deleteProd(Category o) throws SQLException {

    }

    @Override
    public List<Category> findByMotClé(String mot) throws SQLException {
        return null;
    }

    @Override
    public Category updateProd(Category o) throws SQLException {
        return null;
    }
}
