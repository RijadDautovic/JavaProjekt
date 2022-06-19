package app.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegisterView extends AnchorPane {

    private final Label firstNameLabel = new Label("First Name");
    private final Label lastNameLabel = new Label("Last Name");
    private final Label usernameLabel = new Label("Username");
    private final Label emailLabel = new Label("e-Mail");
    private final Label passwordLabel = new Label("Password");
    private final TextField firstNameField = new TextField();
    private final TextField lastNameField = new TextField();
    private final TextField usernamField = new TextField();
    private final TextField emailField = new TextField();
    private final TextField passwordField = new TextField();
    private final Button registerButton = new Button("Register");

    public TextField getfirstNameField() {
        return firstNameField;

    }

    public TextField getLastNameField() {
        return lastNameField;

    }

    public TextField getUsernameField() {
        return usernamField;

    }

    public TextField getemailField() {
        return emailField;

    }

    public TextField getPasswordField() {
        return passwordField;
    }
}
