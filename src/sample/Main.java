package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        //Para establecer el tamaño
        primaryStage.setHeight(475);
        primaryStage.setWidth(700);
        //Para establecer lo maximo y minimo
        primaryStage.setMaxHeight(475);
        primaryStage.setMaxWidth(700);
        primaryStage.setMinHeight(475);
        primaryStage.setMinWidth(700);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}