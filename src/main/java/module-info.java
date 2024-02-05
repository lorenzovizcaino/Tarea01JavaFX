module com.example.tarea01javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tarea01javafx to javafx.fxml;
    exports com.example.tarea01javafx;
}