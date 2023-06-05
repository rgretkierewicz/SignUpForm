package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button loginBtn1;

    @FXML
    private Label passwordLbl;

    @FXML
    private Label passwordLbl1;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Label usernameLbl;

    @FXML
    private TextField usernameTxt;

    @FXML
    void onActionClickHere(ActionEvent event) throws IOException {
        Stage stage;
        Parent scene;
        stage = (Stage)((Hyperlink)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionLogin(ActionEvent event) throws IOException {

    }

}
