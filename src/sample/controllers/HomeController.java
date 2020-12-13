package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button profileBtn;

    @FXML
    private Button bookBtn;

    @FXML
    private Button comicsBtn;

    @FXML
    private Button cartBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    void initialize() {
        loginBtn.setOnAction(event -> {
            openWindow(loginBtn, "Login", false, "/sample/views/login.fxml");
        });

        signUpBtn.setOnAction(event -> {
            openWindow(signUpBtn, "Sign Up", false, "/sample/views/sign-up.fxml");
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
