package com.example.applicationdevente2.dao;

import com.example.applicationdevente2.entities.Category;
import com.example.applicationdevente2.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDao implements DaoImpl<Produit>{

    public ProduitDao() {
    }

    @Override
    public Produit add(Produit produit) throws SQLException {
        Connection con = CreateConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("insert into produits(nom, marque, prix, description, nombre_en_stock,id_cat) values (?,?,?,?,?,?,?)" );
        pst.setString(1, produit.getNom());
        pst.setString(2,produit.getMarque());
        pst.setDouble(3, produit.getPrix());
        pst.setString(4,produit.getDescription());
        pst.setInt(5, produit.getNombre_en_stock());
        pst.setInt(6, produit.getNombre_en_stock());
        pst.setInt(7,produit.getCategory().getId());

        pst.executeUpdate();
        return produit;
    }

    @Override
    public Produit update(Produit p) throws SQLException {
        Connection con = CreateConnection.getConnection();

        PreparedStatement pst = con.prepareStatement("update produits set nom = ?, marque = ?, prix = ?, description = ?, nombre_en_Stock = ? where id = ?");

        pst.setString(1, p.getNom());
        pst.setString(2,p.getMarque());
        pst.setDouble(3, p.getPrix());
        pst.setString(4,p.getDescription());
        pst.setInt(5, p.getNombre_en_stock());
        pst.setInt(6, p.getId());

        pst.executeUpdate();
        return p;

    }

    @Override
    public List<Produit> getAll() throws SQLException {
        Connection con = CreateConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from produits");
        ResultSet rs = pst.executeQuery();

        List<Produit> p = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String marque = rs.getString("marque");
            double prix = rs.getDouble("prix");
            String description = rs.getString("description");
            int nombre_en_stock = rs.getInt("nombre_en_stock");
            Category c = new Category();
            PreparedStatement pst1 = con.prepareStatement("select * from category where id = ?");
            pst1.setInt(1, rs.getInt("id_cat"));
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                c.setId(rs1.getInt("id"));
                c.setNom(rs1.getString("nom"));
            }

            Produit produit = new Produit(id,nom,marque,prix,description,nombre_en_stock, c);
            p.add(produit);

        }
        return p;
    }


    @Override
    public List<Produit> findByMotCle(String mot) throws SQLException {
        Connection con = CreateConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("select * from produits where nom like ? or marque like ?");
        pst.setString(1, "%"+mot+"%");
        pst.setString(2, "%"+mot+"%");

        ResultSet rs = pst.executeQuery();
        Produit p = new Produit();

        List<Produit> prod = new ArrayList<>();

        while (rs.next()){
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String marque = rs.getString("marque");
            double prix = rs.getDouble("prix");
            String description = rs.getString("description");
            int nombre_en_stock = rs.getInt("nombre_en_stock");

            Category c = new Category();
            PreparedStatement pst1 = con.prepareStatement("select * from category where id = ?");
            pst1.setInt(1, rs.getInt("id_cat"));
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                c.setId(rs1.getInt("id"));
                c.setNom(rs1.getString("nom"));
            }

            Produit produit = new Produit(id,nom,marque,prix,description,nombre_en_stock,c);
            prod.add(produit);

        }
        return prod;
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con = CreateConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("delete from produits where id=?");
        pst.setInt(1, id);
        pst.executeUpdate();
    }
}
