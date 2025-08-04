/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lyeso
 */
public class Steps1Controller implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<String> stepCombo;
    @FXML
    private Button next_step1;
    @FXML
    private Label clickable;
    @FXML
    private Pane bar1;
    @FXML
    private Pane bars;
    @FXML
    private ComboBox<String> stepCombo1;
    @FXML
    private ComboBox<String> stepCombo11;
    @FXML
    private HBox top_auth;
    @FXML
    private StackPane pain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stepCombo.getItems().addAll("Tutor", "User");
        stepCombo.setValue("Select");
        
        stepCombo1.getItems().addAll("Tutor", "User");
        stepCombo1.setValue("Select");
        
        stepCombo11.getItems().addAll("Tutor", "User");
        stepCombo11.setValue("Select");
    }

    @FXML
    private void goToStep2(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("step2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void skipThrough(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("step3.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    

}
