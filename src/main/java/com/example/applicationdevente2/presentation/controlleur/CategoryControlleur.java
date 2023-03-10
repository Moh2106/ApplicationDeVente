package com.example.applicationdevente2.presentation.controlleur;

import com.example.applicationdevente2.entities.Category;
import com.example.applicationdevente2.service.CategoryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CategoryControlleur implements Initializable {
    @FXML
    public TextField nom;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void addCategorie(ActionEvent actionEvent) throws SQLException {
        String nom_text = nom.getText();
        Category category = new Category(nom_text);
        CategoryService categoryService = new CategoryService();
        categoryService.add(category);
    }
}
