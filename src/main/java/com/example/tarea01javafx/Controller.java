package com.example.tarea01javafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Objects;
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
    private String rutaAbsoluta2 = new File("src\\main\\resources\\estilos\\infantil.css").getAbsolutePath();
    private final int DURACION = 5;
    private Duration duracionIntervalo = Duration.seconds(DURACION);
    private int contador = 0;
    private int contarSegundos = 0;
    private int contarMinutos = 0;


    @FXML
    void CambiarInfantil(ActionEvent event) {
        InicializarImagenes();

        Scene scene = this.AnchorPane.getScene();    //Me devuelve la scene de la interfaz

        try {
            String ruta= "com/example/tarea01javafx/estilos/infantil.css";
            System.out.println(rutaAbsoluta2);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("estilos/infantil.css")).toExternalForm());

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("no lo encuentro");
        }

        btnRomantico.setDisable(true);
        btnTerror.setDisable(true);
        btnReiniciar.setDisable(true);
        btnSalir.setDisable(true);
        contador = 1;
        FuncionConTimeline("infantil");






    }

    private void InicializarImagenes() {
        imagen1.setImage(new Image(rutaAbsoluta+"\\neutra\\1.jpg"));
        imagen2.setImage(new Image(rutaAbsoluta+"\\neutra\\1.jpg"));
        imagen3.setImage(new Image(rutaAbsoluta+"\\neutra\\1.jpg"));
        contarSegundos=0;
        contarMinutos=0;
        tfTiempo.setText("00:00");
    }

    private void FuncionConTimeline(String genero) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), ev0 -> {
                    CambiarImagenes(contador, genero);
                    Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), ev2 -> {
                        CambiarTiempo();
                    }));
                    timeline2.setCycleCount(DURACION);
                    timeline2.play();
                }),
                new KeyFrame(duracionIntervalo, ev -> {
                    CambiarImagenes(contador, genero);
                    Timeline timeline3 = new Timeline(new KeyFrame(Duration.seconds(1), ev2 -> {
                        CambiarTiempo();
                    }));
                    timeline3.setCycleCount(DURACION);
                    timeline3.play();

                }),
                new KeyFrame(Duration.seconds(DURACION * 2), ev -> {
                    CambiarImagenes(contador, genero);


                })
        );

        timeline.setCycleCount(1); //numero de repeticiones
        timeline.play();

        timeline.setOnFinished(ev -> {

            btnRomantico.setDisable(false);
            btnTerror.setDisable(false);
            btnInfantil.setDisable(false);
            btnReiniciar.setDisable(false);
            btnSalir.setDisable(false);
        });
    }

    private void CambiarTiempo() {
        contarSegundos++;
        if(contarSegundos <=9){
            tfTiempo.setText("0"+contarMinutos+":0" + contarSegundos);
        }
        if(contarSegundos >=10 && contarSegundos <=59){
            tfTiempo.setText("0"+contarMinutos+":" + contarSegundos);
        }
        if(contarSegundos>59){
            contarMinutos++;
            contarSegundos=0;
            if(contarMinutos<=9){
                tfTiempo.setText("0"+contarMinutos+":0" + contarSegundos);
            }else{
                tfTiempo.setText(contarMinutos+":0" + contarSegundos);
            }


        }


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
        InicializarImagenes();
        btnInfantil.setDisable(true);
        btnTerror.setDisable(true);
        btnReiniciar.setDisable(true);
        btnSalir.setDisable(true);
        contador = 1;
        FuncionConTimeline("romantica");


    }

    @FXML
    void CambiarTerror(ActionEvent event) {
        InicializarImagenes();
        btnInfantil.setDisable(true);
        btnRomantico.setDisable(true);
        btnReiniciar.setDisable(true);
        btnSalir.setDisable(true);
        contador = 1;
        FuncionConTimeline("terror");


    }

    @FXML
    void Reiniciar(ActionEvent event) {
        InicializarImagenes();
    }

    @FXML
    void Salir(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
