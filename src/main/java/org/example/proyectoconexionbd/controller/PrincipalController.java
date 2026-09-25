package org.example.proyectoconexionbd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.proyectoconexionbd.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipalController {

    @FXML
    public Button btnProbar;

    @FXML
    private Label lblResultado;

    public void clickProbarConexion(ActionEvent actionEvent) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            lblResultado.setText("Conexion exitosa");
        } catch (SQLException e) {
            lblResultado.setText("Error de conexion");
            e.printStackTrace();
        }
    }

    public void clickListaEstudiantes(ActionEvent actionEvent) {
        String sql = "SELECT * FROM estudiante";

        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {

            System.out.println("Listado de estudiantes");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");

                System.out.println(id + " " + nombre + " " + correo);
            }

        } catch (SQLException e) {
            System.out.println("Error en obtener estudiantes");
            e.printStackTrace();
        }
    }
}