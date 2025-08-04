package com.mycompany.p2p;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public abstract class abstractBase {

    protected void loadScene(String fxml, MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    protected void setupPhoneNumberField(TextField phoneField) {
        // Set initial value
        phoneField.setText("+27");
        phoneField.positionCaret(phoneField.getText().length());

// TextFormatter to enforce +27 and 9 digits
        TextFormatter<String> formatter = new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            // Always start with +27
            if (!newText.startsWith("+27")) {
                return null;
            }

            // Only allow up to 9 digits after +27
            String afterPrefix = newText.substring(3);
            if (!afterPrefix.matches("\\d{0,9}")) {
                return null;
            }

            return change;
        });

        phoneField.setTextFormatter(formatter);

// Safety listener to auto-reset if user somehow removes +27
        phoneField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.startsWith("+27")) {
                phoneField.setText("+27");
                phoneField.positionCaret(phoneField.getText().length());
            }
        });

// Prevent backspace/delete from removing +27
        phoneField.setOnKeyPressed(event -> {
            int caretPos = phoneField.getCaretPosition();
            switch (event.getCode()) {
                case BACK_SPACE:
                case DELETE:
                    if (caretPos <= 3) {
                        event.consume(); // Block key
                    }
                    break;
                default:
                    break;
            }
        });

// Tooltip for user guidance
        phoneField.setTooltip(new Tooltip("Phone number must start with +27 and contain 9 digits."));

    }
}
