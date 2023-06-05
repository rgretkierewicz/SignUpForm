
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    public TextFlow textFlow1;
    public Text text1;
    public Label confirmPasswordInvalid;
    @FXML
    private Label dobInvalid;
    @FXML
    private TextField dobTxt;
    @FXML
    private Label emailInvalid;
    @FXML
    private TextField emailTxt;
    @FXML
    private Label firstNameInvalid;
    @FXML
    private TextField firstNameTxt;
    @FXML
    private Label lastNameInvalid;
    @FXML
    private TextField lastNameTxt;
    @FXML
    private Label passwordInvalid;
    @FXML
    private TextField passwordTxt;
    @FXML
    private TextField passwordConfirmationTxt;
    @FXML
    private Label phoneInvalid;
    @FXML
    private TextField phoneTxt;
    private String password;
    private String passwordConfirmation;


    @FXML
    void onActionSignUp(ActionEvent event) throws IOException {
        String passwordChanges = "Password must contain the following:\n";

        String fName = firstNameTxt.getText();
        String lName = lastNameTxt.getText();
        password = passwordTxt.getText();
        passwordConfirmation = passwordConfirmationTxt.getText();
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();
        String dob = dobTxt.getText();

        boolean isValidFName = true;
        boolean isValidLName = true;
        boolean isValidPassword = true;
        boolean isValidPasswordConfirmation = true;
        boolean isValidEmail = true;
        boolean isValidPhone = true;
        boolean isValidDob = true;

        //Validating each field
        if (!fName.matches("^[a-zA-Z]+$")) {
            isValidFName = false;
        }
        if (!lName.matches("^[a-zA-Z]+$")) {
            isValidLName = false;
        }
        if (!email.matches("\\w+[@]\\w+[.com]\\w+")) {
            isValidEmail = false;
        }
        if (!phone.matches("^\\d{3}-\\d{3}-\\d{4}$")) {
            isValidPhone = false;
        }
        if (!dob.matches(("(0?[1-9]|1[0-2])/[0-3]?[0-9]/[12][09][0-9][0-9]"))) {
            isValidDob = false;
        }
        //Check that first password entered matches second.
        if (!password.equals(passwordConfirmation) || passwordConfirmation.equals("")) {
            isValidPasswordConfirmation = false;
        }

        //Validating the password field
        if (!password.matches(".{6,16}")) {
            passwordChanges +="6 - 16 characters\n";
            isValidPassword = false;
        }
        if(!password.matches(".*[0-9]+.*")) {
            passwordChanges +="At least 1 number\n";
            isValidPassword = false;

        }
        if (!password.matches(".*[A-Z]+.*")) {
            passwordChanges +="At least 1 uppercase character\n";
            isValidPassword = false;
        }

        if (!password.matches(".*[a-z]+.*")) {
            passwordChanges +="At least 1 lowercase character\n";
            isValidPassword = false;
        }
        if (!password.matches(".*[*@!#%&()^~{}]+.*")) {
            passwordChanges +="At least 1 special character (*, @, !, #, %, &, (, ), ^, ~, {, })";
            isValidPassword = false;
        }

        //Setting labels for invalid fields

        //First name validation
        if (!isValidFName) {
            firstNameInvalid.setText("*Please enter a first name");
        }
        else {
            firstNameInvalid.setText("");
        }

        //Last name validation
        if (!isValidLName) {
            lastNameInvalid.setText("*Please enter a last name");
        }
        else {
            lastNameInvalid.setText("");
        }

        //Email validation
        if (!isValidEmail) {
            emailInvalid.setText("*Please enter a valid email address");
        }
        else {
            emailInvalid.setText("");
        }

        //Phone validation
        if (!isValidPhone) {
            phoneInvalid.setText("*Please enter a valid phone number");
        }
        else {
            phoneInvalid.setText("");
        }

        //DOB validation
        if (!isValidDob) {
            dobInvalid.setText("*Please enter a valid date of birth");
        }
        else {
            dobInvalid.setText("");
        }

        //Passwords match validation
        if (!isValidPasswordConfirmation) {
            confirmPasswordInvalid.setText("*Passwords must match.");
        }
        else {
            confirmPasswordInvalid.setText("");
        }

        //Password requirements validation
        if (!isValidPassword) {
            passwordInvalid.setText("*Please enter a valid password");
            text1.setText(passwordChanges);
        }
        else {
            passwordInvalid.setText("");
            text1.setText("");
        }

        if (isValidFName && isValidLName && isValidPassword && isValidPasswordConfirmation && isValidEmail && isValidPhone && isValidDob) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Success!");
            success.setContentText("User sign-up successful. You should receive a confirmation email in your inbox shortly.");
            success.setHeight(400);
            success.show();

            Stage stage;
            Parent scene;
            stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip passwordToolTip = new Tooltip("Must be between 6 and 16 characters\n" +
                "Must have at least 1 number\n" +
                "Must have at least 1 uppercase character\n" +
                "Must have at least 1 lowercase character\n" +
                "Must have at least 1 special character ($, !, *, %, #, ^, @)");

        passwordTxt.setTooltip(passwordToolTip);


        Image venus = new Image("view/venus2.png");
        ImageView iv1 = new ImageView(venus);
        iv1.setFitWidth(40);
        iv1.setFitHeight(40);



    }

}