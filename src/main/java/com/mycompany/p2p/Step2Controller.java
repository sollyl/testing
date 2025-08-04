package com.mycompany.p2p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lyeso
 */
public class Step2Controller implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Pane bars;
    @FXML
    private Pane bar1;
    @FXML
    private ScrollPane scrollable;
    @FXML
    private VBox module_box;
    @FXML
    private ComboBox<?> combo_2;
    @FXML
    private Label clickable;
    @FXML
    private Button step2_btn;
    @FXML
    private VBox manualBox;
    @FXML
    private Button delete_man;
    @FXML
    private HBox back_box1;
    @FXML
    private ImageView back_arrow1;
    @FXML
    private Button next_step3;
    @FXML
    private HBox top_auth;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        delete_man.setOnAction(e -> {
            module_box.getChildren().remove(manualBox);
        });
    }

    @FXML
    private void addRow(ActionEvent event) {
        // Label row
        Label choose_mod = new Label("Choose a module");
        choose_mod.setStyle("-fx-font-size: 17px; -fx-font-weight: bold;");

        HBox labelRow = new HBox();
        labelRow.getChildren().add(choose_mod);

        // Input row with ComboBox, TextField, and Delete Button
        ComboBox<String> moduleCombo = new ComboBox<>();

        moduleCombo.setMinHeight(37.6);
        moduleCombo.setMinWidth(273);
        moduleCombo.setPrefWidth(273);
        moduleCombo.setPrefHeight(38);
        moduleCombo.setMaxWidth(Region.USE_PREF_SIZE);
        moduleCombo.setMaxHeight(Region.USE_PREF_SIZE);

        TextField markField = new TextField();
        markField.setMinWidth(37.6);
        markField.setMinHeight(37.6);
        markField.setPrefWidth(37.6);
        markField.setPrefHeight(37.6);
        markField.setMaxWidth(Region.USE_PREF_SIZE);
        markField.setMaxHeight(Region.USE_PREF_SIZE);

        Button deleteBtn = new Button("Delete");
        deleteBtn.setStyle("-fx-font-size: 11px;");
        deleteBtn.setMinWidth(46.8);
        deleteBtn.setMinHeight(24);
        deleteBtn.setPrefWidth(46.8);
        deleteBtn.setPrefHeight(24);
        deleteBtn.setMaxWidth(Region.USE_PREF_SIZE);
        deleteBtn.setMaxHeight(Region.USE_PREF_SIZE);

        HBox inputRow = new HBox(12); // spacing 10
        inputRow.getChildren().addAll(moduleCombo, markField, deleteBtn);
        inputRow.setAlignment(Pos.CENTER_LEFT);

        // Container VBox to hold labelRow and inputRow together
        VBox container = new VBox(3); // spacing 3 between label and input rows
        container.getChildren().addAll(labelRow, inputRow);
        container.setPadding(new Insets(0, 0, 12, 0)); // bottom margin

        // Delete action removes this whole container from module_box
        deleteBtn.setOnAction(e -> {
            module_box.getChildren().remove(container);
        });

        module_box.getChildren().add(container);
    }


    @FXML
    private void goToStep1(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("steps1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void goToStep3(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("step3.fxml"));
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
