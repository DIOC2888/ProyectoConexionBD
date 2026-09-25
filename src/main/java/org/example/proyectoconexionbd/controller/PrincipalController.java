package org.example.proyectoconexionbd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.proyectoconexionbd.connection.DatabaseConnection;

import javax.swing.text.LabelView;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PrincipalController {
    @FXML
    public Button btnProbar;
    @FXML
    private Label lblResultado;

    public void clickProbarConexion(ActionEvent actionEvent) {
        try(Connection connection = DatabaseConnection.getConnection()){
            lblResultado.setText("Conexion exitosa");
        }catch (SQLException e){
            lblResultado.setText("Error de conexion");
            e.printStackTrace();
        }

    }
}
