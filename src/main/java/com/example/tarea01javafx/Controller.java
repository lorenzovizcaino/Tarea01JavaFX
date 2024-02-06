package com.example.tarea01javafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;

import static java.lang.Thread.sleep;

public class Controller {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button btnInfantil;

    @FXML
    private Button btnReiniciar;

    @FXML
    private Button btnRomantico;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnTerror;

    @FXML
    private ImageView imagen1;

    @FXML
    private ImageView imagen2;

    @FXML
    private ImageView imagen3;
    private Image image1, image2,image3;

    @FXML
    void CambiarInfantil(ActionEvent event) throws InterruptedException {
        String nombreFichero = "src\\main\\resources\\infantil\\1.jpg";
        String rutaAbsoluta = new File(nombreFichero).getAbsolutePath();
        System.out.println(rutaAbsoluta);


        image1=new Image(rutaAbsoluta);
        imagen1.setImage(image1);
//        Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//            }
//        }))
       // Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(9)));
        //timeline.play();


       //imagen1.setImage(image2);

    }

    @FXML
    void CambiarRomantico(ActionEvent event) {

    }

    @FXML
    void CambiarTerror(ActionEvent event) {

    }

    @FXML
    void Reiniciar(ActionEvent event) {

    }

    @FXML
    void Salir(ActionEvent event) {

    }

}
