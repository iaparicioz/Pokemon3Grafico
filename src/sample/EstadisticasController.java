package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EstadisticasController implements Initializable {

    @FXML
    public PieChart PieChart;
    @FXML
    public  BarChart BarChart;
    @FXML
    public CategoryAxis ejex;
    @FXML
    public NumberAxis ejey;
    final BarChart<String,Number> bc = new BarChart<String,Number>(ejex,ejey);

    public static double dañoYo = 0;
    public static double dañoEl = 0;

    //public Controller controller;

    public void initialize(URL url, ResourceBundle resourceBundle){
        Stage stage = new Stage();
        Scene scene = new Scene(new Group());
        stage.setTitle("Daño total");
        stage.setWidth(200);
        stage.setHeight(200);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Daño amigo", dañoYo),
                new PieChart.Data("Daño recibido",dañoEl));

        PieChart.setData(pieChartData);
        final PieChart chart = new PieChart(pieChartData);
        final Label caption = new Label("");
        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    e -> {
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        caption.setText(data.getPieValue() + "%");
                    });
        }
        PieChart.setData(pieChartData);
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();

    }
    public void graficoBarras(Controller controller){

        bc.setTitle("Grafico de barras - Seleccion");
        ejex.setLabel("Soy el Pokemon...");
        ejey.setLabel("He sido seleccionado...");

        XYChart.Series series1 = new XYChart.Series<>();
        series1.setName(String.valueOf(controller.pok1Nombre));
        series1.getData().add(new XYChart.Data("",controller.pok1Nombre));
        BarChart.getData().addAll(series1);

        XYChart.Series series2 = new XYChart.Series<>();
        series1.setName(String.valueOf(controller.pok2Nombre));
        series1.getData().add(new XYChart.Data("",controller.pok2Nombre));
        BarChart.getData().addAll(series2);

        XYChart.Series series3 = new XYChart.Series<>();
        series1.setName(String.valueOf(controller.pok3Nombre));
        series1.getData().add(new XYChart.Data("",controller.pok3Nombre));
        BarChart.getData().addAll(series3);

        XYChart.Series series4 = new XYChart.Series<>();
        series1.setName(String.valueOf(controller.pok4Nombre));
        series1.getData().add(new XYChart.Data("",controller.pok4Nombre));
        BarChart.getData().addAll(series4);

        XYChart.Series series5 = new XYChart.Series<>();
        series1.setName(String.valueOf(controller.pok5Nombre));
        series1.getData().add(new XYChart.Data("",controller.pok5Nombre));
        BarChart.getData().addAll(series5);

        XYChart.Series series6 = new XYChart.Series<>();
        series1.setName(String.valueOf(controller.pok6Nombre));
        series1.getData().add(new XYChart.Data("",controller.pok6Nombre));
        BarChart.getData().addAll(series6);

    }


}

