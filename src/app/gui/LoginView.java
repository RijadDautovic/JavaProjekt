package app.gui;

import app.controllers.Controller;
import app.controllers.events.EventBus;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginView extends AnchorPane {

    private final Label usernamLabel = new Label("Username");
    private final TextField usernameField = new TextField();
    private final Label passwordLabel = new Label("Password");
    private final TextField passwordField = new TextField();
    private final Button singInButton = new Button("Sign In");
    private final Button registerButton = new Button("Register");
    private final Label messageLabel = new Label("");

    public LoginView() {
        Controller controller = Controller.getInstance();
        EventBus eventBus = controller.getEventBus();
        singInButton.setOnAction(controller.getEventBus().getLoginEvent());

    }

    public TextField getUsernameTextField() {
        return usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

}
