module org.example.proyectoconexionbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.proyectoconexionbd to javafx.fxml;
    exports org.example.proyectoconexionbd;
    opens org.example.proyectoconexionbd.controller to javafx.fxml;
}