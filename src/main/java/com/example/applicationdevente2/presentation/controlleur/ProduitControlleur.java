package com.example.applicationdevente2.presentation.controlleur;

import com.example.applicationdevente2.entities.Category;
import com.example.applicationdevente2.entities.Produit;
import com.example.applicationdevente2.service.CategoryService;
import com.example.applicationdevente2.service.ProduitService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProduitControlleur implements Initializable {

    public ComboBox categoryCombo;
    @FXML
    private TextField nom;

    @FXML
    private TextField marque;

    @FXML
    private TextField prix;

    @FXML
    private TextField description;

    @FXML
    private TextField nombre_en_stock;

    @FXML
    private TableView<Produit> produitTableView;

    @FXML
    private TableColumn<Produit, Integer> colId;

    @FXML
    private TableColumn<Produit, String> colNom;

    @FXML
    private TableColumn<Produit, String> colMarque;

    @FXML
    private TableColumn<Produit, Double> colPrix;

    @FXML
    private TableColumn<Produit, String> colDescription;

    @FXML
    private TableColumn<Produit, Integer> colNombreEnStock;

    @FXML
    private TextField search;

    @FXML
    public ComboBox<Category> categoryComboBox;

    ObservableList<Produit> produitObservableList = FXCollections.observableArrayList();

    private ProduitService produitService = new ProduitService();
    private CategoryService categoryService = new CategoryService();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        produitTableView.setItems(produitObservableList);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colNombreEnStock.setCellValueFactory(new PropertyValueFactory<>("nombre_en_stock"));

        search.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try {
                    new ProduitService().findByMotClé(t1);
                    produitObservableList.clear();
                    produitObservableList.addAll(new ProduitService().findByMotClé(t1));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        try {
            categoryCombo.getItems().addAll(categoryService.getAll());
           // categoryCombo.getItems().add(categoryService.getAll().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            loadProduit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void Ajouter(ActionEvent actionEvent) throws SQLException {
        String nom_text = nom.getText();
        String marque_text = marque.getText();
        double prix_text = Double.parseDouble(prix.getText()) ;
        String description_text = description.getText();
        int nombre_en_stock_text = Integer.parseInt(nombre_en_stock.getText());

        Produit produit = new Produit(nom_text, marque_text, prix_text,description_text,nombre_en_stock_text);
        ProduitService produitService = new ProduitService();
        produitService.add(produit);
        loadProduit();

        nom.setText(" ");
        marque.setText(" ");
        prix.setText(" ");
        description.setText(" ");
        nombre_en_stock.setText(" ");
    }

    public void Supprimer(ActionEvent actionEvent) throws SQLException {
        Produit p = produitTableView.getSelectionModel().getSelectedItem();
        ProduitService produitService = new ProduitService();
        produitService.deleteProd(p);
        loadProduit();
    }


    public int Modifier(ActionEvent actionEvent) throws SQLException {
        Produit p = produitTableView.getSelectionModel().getSelectedItem();
        nom.setText(p.getNom());
        marque.setText(p.getMarque());
        prix.setText(String.valueOf(p.getPrix()));
        description.setText(p.getDescription());
        nombre_en_stock.setText(String.valueOf(p.getNombre_en_stock()));

        return p.getId();

    }

    private void loadProduit() throws SQLException {
        produitObservableList.clear();
        produitObservableList.addAll(produitService.getAll());
    }


    public void Enregistrer(ActionEvent actionEvent) throws SQLException {

        String nom_text = nom.getText();
        String marque_text = marque.getText();
        double prix_text = Double.parseDouble(prix.getText()) ;
        String description_text = description.getText();
        int nombre_en_stock_text = Integer.parseInt(nombre_en_stock.getText());

        Produit produit = new Produit(nom_text, marque_text, prix_text,description_text,nombre_en_stock_text);
        int new_id = Modifier(actionEvent);
        produit.setId(new_id);

        new ProduitService().updateProd(produit);

        loadProduit();

        nom.setText(" ");
        marque.setText(" ");
        prix.setText(" ");
        description.setText(" ");
        nombre_en_stock.setText(" ");

    }
}
