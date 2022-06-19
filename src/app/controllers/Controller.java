package app.controllers;

import app.Biblioteka;
import app.controllers.events.EventBus;
import app.facade.FacadeFactory;
import app.gui.LoginView;
import app.gui.RegisterView;
import app.gui.SheetView;
import app.gui.admin.AdminView;
import app.gui.user.UserView;
import app.modules.User;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import app.facade.Facade;
import encryption.HashCodeEncryption;
import java.awt.Desktop;
import java.io.File;
import javafx.application.HostServices;

public class Controller {

    public static Controller getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label passwordLabel;

    private LoginView loginView;
    private UserView userView;
    private AdminView adminView;
    private final EventBus eventBus = new EventBus();
    private Stage primaryStage;
    private User loggedUser;

    @FXML
    private Label firstNameLabel;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField emailField;
    @FXML
    private Label emailLabel;
    @FXML
    private Button registerButton;
    @FXML
    private TextField lastNameField;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label incorrectLabel;

    @FXML
    private Label showUsername;

    private HostServices hostServices;

    public Controller() {
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @FXML
    public void handleButtonLogin(ActionEvent event) throws IOException {
        Facade fasada = FacadeFactory.getFacade();
        User user = fasada.login(usernameField.getText(), HashCodeEncryption.encrypt(passwordField.getText()));
        if (user != null) {
            URL resource = SheetView.class.getResource("Sheet.fxml");
            System.out.println(resource);
            Parent sheetView = FXMLLoader.load(resource);
            Scene sheetViewScene = new Scene(sheetView);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene((sheetViewScene));
            window.show();
        } else {
        }

    }

    @FXML
    public void handleButtonRegister(ActionEvent event) throws IOException {
        Facade fasada = FacadeFactory.getFacade();
        URL resource = RegisterView.class.getResource("Register.fxml");
        System.out.println(resource);
        Parent registerView = FXMLLoader.load(resource);
        Scene registerViewScene = new Scene(registerView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene((registerViewScene));
        window.show();

    }

    public void handleRegisterButton(ActionEvent event) throws IOException {
        Facade fasada = FacadeFactory.getFacade();
        boolean isRegistered = fasada.register(usernameField.getText(), HashCodeEncryption.encrypt(passwordField.getText()), firstNameField.getText(), lastNameField.getText(), emailField.getText());
        if (isRegistered) {
            URL resource = Biblioteka.class.getResource("Login.fxml");
            System.out.println(resource);
            Parent registerView = FXMLLoader.load(resource);
            Scene registerViewScene = new Scene(registerView);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene((registerViewScene));
            window.show();

        }
    }

    public void handleReadButton5(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\rijad\\Documents\\NetBeansProjects\\Biblioteka\\src\\booksPDF\\Stephen Chin, Johan Vos, James Weaver - The Definitive Guide to Modern Java Clients with JavaFX - Cross-Platform Mobile and Cloud Development-Apress (2020).pdf"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void handleReadButton6(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\rijad\\Documents\\NetBeansProjects\\Biblioteka\\src\\booksPDF\\Clean_Code.pdf"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void handleReadButton7(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\rijad\\Documents\\NetBeansProjects\\Biblioteka\\src\\booksPDF\\Head_First_Java.pdf"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void handleReadButton8(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\rijad\\Documents\\NetBeansProjects\\Biblioteka\\src\\booksPDF\\Eric Freeman, Elisabeth Freeman, Kathy Sierra, Bert Bates-Head First Design Patterns -OReilly (2008).pdf"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void handleReadButton9(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\rijad\\Documents\\NetBeansProjects\\Biblioteka\\src\\booksPDF\\Clean_Code.pdf"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void handleReadButton10(ActionEvent event) throws IOException {
        try {
            Desktop.getDesktop().open(new File(""));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Controller INSTANCE = null;

    public Object setLoginView() {
        return loginView;
    }

}
