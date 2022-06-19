package app;

import app.controllers.Controller;
import app.gui.LoginView;
import app.gui.RegisterView;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Biblioteka extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        LoginView loginView = new LoginView();
        Controller controller = Controller.getInstance();
        controller.setLoginView(loginView);
        controller.setPrimaryStage(primaryStage);
        URL resource = Biblioteka.class.getResource("Login.fxml");
        System.out.println(resource.getPath());
        AnchorPane mainPane = (AnchorPane) FXMLLoader.load(resource);
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
        }
    }

}
