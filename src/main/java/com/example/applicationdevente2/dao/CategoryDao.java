package com.example.applicationdevente2.dao;

import com.example.applicationdevente2.entities.Category;
import com.example.applicationdevente2.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements DaoImpl<Category> {

    public CategoryDao() {
    }

    @Override
    public Category add(Category c) throws SQLException {
        Connection con = CreateConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("insert into category(nom) values (?)" );
        pst.setString(1, c.getNom());

        pst.executeUpdate();
        return c;
    }

    @Override
    public Category update(Category c) throws SQLException {
        Connection con = CreateConnection.getConnection();

        PreparedStatement pst = con.prepareStatement("update produits set nom = ? where id = ?");

        pst.setString(1, c.getNom());

        pst.setInt(2, c.getId());

        pst.executeUpdate();
        return c;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        Connection con = CreateConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from category");
        ResultSet rs = pst.executeQuery();

        List<Category> c = new ArrayList<>();

        while (rs.next()){
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setNom(rs.getString("nom"));
            //int id = rs.getInt("id");
            //String nom = rs.getString("nom");

            //Category category = new Category(nom);

            c.add(category);

        }
        return c;
    }

    @Override
    public List<Category> findByMotCle(String mot) throws SQLException {
        return null;
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
