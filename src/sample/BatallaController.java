package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;

public class BatallaController {
    @FXML
    private Button botonAtacar;
    @FXML
    private Button botonCurar;
    @FXML
    private Button botonSeguro;
    @FXML
    private Button botonArriesgado;
    @FXML
    private Button botonMuyArriesgado;
    @FXML
    private Button botonCancelar;
    @FXML
    private ProgressBar progressBarNormal;
    @FXML
    private ProgressBar progressBarEnemigo;
    @FXML
    private Label nivelyo;
    @FXML
    private Label nivelEnemigo;
    @FXML
    private Label lnombrealiado;
    @FXML
    private Label lnombreenemigo;
    @FXML
    private Label lpsaliado;
    @FXML
    private Label lpsenemigo;
    @FXML
    private ImageView imagenYo;
    @FXML
    private ImageView imagenEnemigo;

    pokemonData enemigo = new pokemonData("Ivonnesita", "Nv. 19", 754, "@../../../../Desktop/pokemon/ivonne.jpg");
    int total = 0;
    pokemonData pokemondata;
    Controller controller;

    @FXML
    public void BotonAtacar() {
        botonArriesgado.setVisible(true);
        botonArriesgado.setVisible(true);
        botonCancelar.setVisible(true);
        botonAtacar.setVisible(false);
        botonCurar.setVisible(false);
        botonSeguro.setVisible(true);

    }

    @FXML
    public void botonCancelar() {
        botonArriesgado.setVisible(false);
        botonArriesgado.setVisible(false);
        botonCancelar.setVisible(false);
        botonAtacar.setVisible(true);
        botonCurar.setVisible(true);
        botonSeguro.setVisible(false);

    }

    @FXML
    public void botonArriesgado() {
        Random r = new Random();
        double meCuro = r.nextInt(15) + 10;
        double seCura = r.nextInt(15) + 10;
        meCuro = meCuro / 100;
        seCura = seCura / 100;
        bajarVida(meCuro, lpsaliado);
        bajarVida(seCura, lpsenemigo);
        progressBarEnemigo.setProgress(progressBarEnemigo.getProgress() - seCura);
        progressBarNormal.setProgress(progressBarNormal.getProgress() - meCuro);
        alerta();
    }

    public void auxiliar(pokemonData pokemon) {
        pokemondata = pokemon;
        nivelyo.setText("Nv." + pokemon.nivelPokemon);
        lnombrealiado.setText(pokemon.nombrePokemon);
        Image imagen2 = new Image(pokemon.imagenPokemon);

        imagenYo.setImage(imagen2);
        nivelEnemigo.setText("Nv." + enemigo.nivelPokemon);
        lnombreenemigo.setText(enemigo.nombrePokemon);
        Image imagenenemigo = new Image(enemigo.imagenPokemon);

        imagenEnemigo.setImage(imagenenemigo);
        total = pokemon.vidaPokemon;
        lpsaliado.setText(pokemon.vidaPokemon + "/" + total);
        lpsenemigo.setText(enemigo.vidaPokemon + "/" + enemigo.vidaPokemon);
    }

    @FXML
    public void botonMuyArriesgado() {
        Random r = new Random();
        double meCuro = r.nextInt(50);
        double seCura = r.nextInt(50);
        meCuro = meCuro / 100;
        seCura = seCura / 100;
        bajarVida(meCuro, lpsaliado);
        bajarVida(seCura, lpsenemigo);
        progressBarEnemigo.setProgress(progressBarEnemigo.getProgress() - seCura);
        progressBarNormal.setProgress(progressBarNormal.getProgress() - meCuro);
        //alerta();
    }

    public void alerta() {
        // hay cosas que no me tiran, HAY QUE MIRARLO!! y entenderlo, copiado de uno que compartio en teams porq no entendia
        // preguntar,
       /* if (nivelEnemigo.getProgress() <= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("has ganado colega");

            Optional<ButtonType> resultado = alert.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                System.exit(0);
            } else if (resultado.get() == ButtonType.CANCEL) {
                //controller.entrada(nuevo, nivelyo.getId());
                Stage stage = (Stage) botonCancelar.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("Resultado = OTROS: " + resultado.get().getText());
            }
        }
        //if (nivelyo.getProgress() <= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("ups, que malo eres, has perdido!!");
            Optional<ButtonType> resultado = alert.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                System.exit(0);
            } else if (resultado.get() == ButtonType.CANCEL) {
                controller.entrada(nuevo, nivelyo.getId());
                Stage stage = (Stage) botonCancelar.getScene().getWindow();
                stage.close();
            } else {
                System.out.println("Resultado = OTROS: " + resultado.get().getText());
            }
        }*/
    }

    @FXML
    public void botonCurar () {
        Random r = new Random();
        double curaa = r.nextInt(50) + 25;
        double curae = r.nextInt(50) + 25;
        curaa = curaa / 100;
        curae = curae / 100;
        curarvida(curaa, progressBarNormal);
        curarvida(curae, progressBarEnemigo);
        progressBarEnemigo.setProgress(progressBarEnemigo.getProgress() + curae);
        progressBarNormal.setProgress(progressBarNormal.getProgress() + curaa);

    }


    public void bajarVida (Double daño, Label ps){
        Double vida = pokemondata.vidaPokemon * daño;
        pokemondata.vidaPokemon = (int) (pokemondata.vidaPokemon - vida);
        ps.setText(pokemondata.vidaPokemon + "/" + total);
    }


    public void curarvida (Double cura, ProgressBar pb){
        Double vida = pokemondata.vidaPokemon * cura;
        int resultado = (int) (pokemondata.vidaPokemon + vida);
        if (resultado >= pokemondata.vidaPokemon) {
            pokemondata.vidaPokemon = total;
            pb.setProgress(1);
        } else {
            pokemondata.vidaPokemon = resultado;
        }
        lpsaliado.setText(pokemondata.vidaPokemon + "/" + total);
    }


    public void setVentana (Controller controller){
        this.controller = this.controller;
    }

    public void onpbaliadoEntered () {
        lpsaliado.setVisible(true);
    }
    public void onpbaliadoExit () {
        lpsaliado.setVisible(false);
    }
    public void onpbenemigoEntered () {
        lpsenemigo.setVisible(true);
    }
    public void onpbenemigoExit () {
        lpsenemigo.setVisible(false);
    }

}
}