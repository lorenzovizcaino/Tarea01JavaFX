package com.example.tarea01javafx;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class Controller implements Initializable {

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

    @FXML
    private TextField tfTiempo;
    private Image image;

    private String rutaAbsoluta = new File("src\\main\\resources").getAbsolutePath();
    private final int DURACION = 5;
    private Duration duracionIntervalo = Duration.seconds(DURACION);
    private int contador = 0;
    private int contarTiempo = 0;


    @FXML
    void CambiarInfantil(ActionEvent event) {
        btnRomantico.setDisable(true);
        btnTerror.setDisable(true);
        contador = 1;


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), ev0 -> {
                    CambiarImagenes(contador, "infantil");
                    Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), ev2 -> {
                        CambiarTiempo();
                    }));
                    timeline2.setCycleCount(DURACION);
                    timeline2.play();
                }),
                new KeyFrame(duracionIntervalo, ev -> {
                    CambiarImagenes(contador, "infantil");
                    Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(1), ev2 -> {
                        CambiarTiempo();
                    }));
                    timeline3.setCycleCount(DURACION);
                    timeline3.play();

                }),
                new KeyFrame(Duration.seconds(DURACION * 2), ev -> {
                    CambiarImagenes(contador, "infantil");


                })
        );

        timeline.setCycleCount(1); //numero de repeticiones
        timeline.play();

        timeline.setOnFinished(ev -> {
//            image = new Image(rutaAbsoluta+"\\infantil\\"+contador+".jpg");
//            imagen3.setImage(image);
            btnRomantico.setDisable(false);
            btnTerror.setDisable(false);
        });


    }

    private void CambiarTiempo() {
        contarTiempo++;
        System.out.println("ContarTiempo" + contarTiempo);
        tfTiempo.setText("00:" + String.valueOf(contarTiempo));
    }

    private void CambiarImagenes(int selecion, String genero) {
        String rutaImagenes = "";
        String rutaImagenesAux = "";
        switch (genero) {
            case "infantil":
                rutaImagenes = rutaAbsoluta + "\\infantil\\";
                break;
            case "romantica":
                rutaImagenes = rutaAbsoluta + "\\romantica\\";
                break;
            case "terror":
                rutaImagenes = rutaAbsoluta + "\\terror\\";
                break;

        }
        rutaImagenesAux = rutaImagenes;
        rutaImagenes = rutaImagenesAux + contador + ".jpg";
        image = new Image(rutaImagenes);


        switch (selecion) {
            case 1:

                imagen1.setImage(image);
                break;
            case 2:

                imagen2.setImage(image);
                break;
            case 3:

                imagen3.setImage(image);
                break;


        }

        contador++;


    }

    @FXML
    void CambiarRomantico(ActionEvent event) {
        btnInfantil.setDisable(true);
        btnTerror.setDisable(true);
        contador = 1;

        Timeline timeline = new Timeline(
                new KeyFrame(duracionIntervalo, ev -> CambiarImagenes(contador, "romantica"))
        );
        timeline.setCycleCount(3); //numero de repeticiones
        timeline.play();

        timeline.setOnFinished(ev -> {
            btnInfantil.setDisable(false);
            btnTerror.setDisable(false);
        });
    }

    @FXML
    void CambiarTerror(ActionEvent event) {
        btnInfantil.setDisable(true);
        btnRomantico.setDisable(true);
        contador = 1;

        Timeline timeline = new Timeline(
                new KeyFrame(duracionIntervalo, ev -> CambiarImagenes(contador, "terror"))
        );
        timeline.setCycleCount(3); //numero de repeticiones
        timeline.play();
        timeline.setOnFinished(ev -> {
            btnInfantil.setDisable(false);
            btnRomantico.setDisable(false);
        });
    }

    @FXML
    void Reiniciar(ActionEvent event) {

    }

    @FXML
    void Salir(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
