package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField signInLoginVar;

    @FXML
    private PasswordField signInPasswordVar;

    @FXML
    private Button signInLoginBtn;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    void initialize() {
        signUpLink.setOnAction(event -> {
            openWindow(signUpLink, "Sign Up",true, "/sample/views/sign-up.fxml");
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
