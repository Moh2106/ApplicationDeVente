module com.example.applicationdevente2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens com.example.applicationdevente2 to javafx.fxml;
    opens com.example.applicationdevente2.entities;
    opens com.example.applicationdevente2.presentation.controlleur to javafx.fxml;

    exports com.example.applicationdevente2;
    exports com.example.applicationdevente2.entities to javafx.fxml;
    exports com.example.applicationdevente2.presentation.controlleur to javafx.fxml;
}