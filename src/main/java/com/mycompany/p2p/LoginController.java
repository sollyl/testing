package com.mycompany.p2p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lyeso
 */
public class LoginController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @FXML
    private AnchorPane log_left;
    @FXML
    private TextField box_user;
    @FXML
    private PasswordField log_pass;
    @FXML
    private CheckBox check_rem;
    @FXML
    private Label clickable;
    @FXML
    private Button log_btn;
    @FXML
    private Label forgot_pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rememberMe(ActionEvent event) {
    }


    @FXML
    private void goToMainPage(MouseEvent event) {
    }

    @FXML
    private void login(ActionEvent event) {
    }

    @FXML
    private void goToSignup(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
