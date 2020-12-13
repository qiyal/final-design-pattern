package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.services.AuthService;

import java.io.IOException;

public class LoginController {
    private AuthService authService = AuthService.getInstance();

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorText;

    @FXML
    private Button signInLoginBtn;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    void initialize() {
        signUpLink.setOnAction(event -> {
            openWindow(signUpLink, "Sign Up",true, "/sample/views/sign-up.fxml");
        });

        signInLoginBtn.setOnAction(event -> {
            if (authService.login(login.getText(), password.getText())) {

                try {
                    FXMLLoader layout1Loader = new FXMLLoader(getClass().getResource("/sample/views/home.fxml"));
                    Parent root = layout1Loader.load();

                    HomeController l1Controller = layout1Loader.getController();

                    l1Controller.hideLoginAndSignUpBtns();

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Flip");
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                signInLoginBtn.getScene().getWindow().hide();
            } else {
                errorText.setText("Login or password is not correct!");
            }
        });
    }

    private void openWindow(Node note, String title, boolean hide, String path) {
        if (hide) {
            note.getScene().getWindow().hide();
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
