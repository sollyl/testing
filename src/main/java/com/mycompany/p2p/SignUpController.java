/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.p2p;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lyeso
 */
public class SignUpController extends abstractBase implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private HBox name_sign;
    @FXML
    private StackPane pain;
    @FXML
    private TextField s_name;
    @FXML
    private HBox name_sign1;
    @FXML
    private HBox name_sign11;
    @FXML
    private HBox name_sign111;
    @FXML
    private HBox name_sign1111;
    @FXML
    private Button Signing;
    @FXML
    private Label clickable;
    @FXML
    private TextField phone_num;
    @FXML
    private TextField s_email;
    @FXML
    private AnchorPane signing;
    @FXML
    private AnchorPane auth_pane;
    @FXML
    private Label sent_text;
    @FXML
    private Button auth_submit;
    @FXML
    private TextField auth1;
    @FXML
    private TextField auth2;
    @FXML
    private TextField auth3;
    @FXML
    private TextField auth4;

    /**
     * Initializes the controller class.
     */
    public void showAuthPane() {
        auth_pane.setVisible(true);
        auth_pane.setOpacity(1); // or use FadeTransition
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        auth_pane.setVisible(false);     // Makes it not display
        auth_pane.setOpacity(1.0);

        setupPhoneNumberField(phone_num);

        restrictToOneDigit(auth1);
        restrictToOneDigit(auth2);
        restrictToOneDigit(auth3);
        restrictToOneDigit(auth4);

        autoFocus(auth1, auth2);
        autoFocus(auth2, auth3);
        autoFocus(auth3, auth4);
    }

    private void restrictToOneDigit(TextField field) {
        TextFormatter<String> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            return newText.matches("\\d?") ? change : null;
        });
        field.setTextFormatter(formatter);
    }

    private void autoFocus(TextField current, TextField next) {
        current.textProperty().addListener((obs, oldText, newText) -> {
            if (newText.length() == 1) {
                next.requestFocus();
            }
        });
    }

    @FXML
    private void goToLogin(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSignUp(MouseEvent event) throws IOException {
        /*String email = s_email.getText().trim();

        if (!email.endsWith("@mycput.ac.za")) {
            // Show warning alert
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Invalid Email");
            alert.setHeaderText(null);
            alert.setContentText("Email must end with @mycput.ac.za");
            alert.showAndWait();
            return;
        }

        // Proceed if email is valid
        Alert success = new Alert(AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText(null);
        success.setContentText("Valid email: " + email);

        Optional<ButtonType> result = success.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {*/
        showAuthPane(); // Call your method to pop up the auth pane
        //}

        String username = s_email.getText();
        sent_text.setText("The code was sent to " + username);
    }
//
    // txt_hello.setText("Hello: "+ username);

    @FXML
    private void goToSteps(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("steps1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
