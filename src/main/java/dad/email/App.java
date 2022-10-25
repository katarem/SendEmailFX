package dad.email;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    Controller controller;
    public static Stage primaryStage;
    @Override public void start(Stage primaryStage) throws Exception {

        App.primaryStage = primaryStage;
        controller = new Controller();

        App.primaryStage.setTitle("Cliente de correo by Katarem");
        App.primaryStage.getIcons().add(new Image("/icono.png"));
        App.primaryStage.setScene(new Scene(controller.getView()));
        App.primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}