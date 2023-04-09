package fes.ico.camisasfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class Inicio extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource("Principal.fxml"));

            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.getIcons().add(new Image("/fes/ico/camisasfx/icon.png"));
            stage.setTitle("Tienda de Camisas");
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}