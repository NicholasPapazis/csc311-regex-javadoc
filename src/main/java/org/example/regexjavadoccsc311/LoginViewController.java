package org.example.regexjavadoccsc311;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;

public class LoginViewController {

    @FXML
    private TextField firstNameInput;
    @FXML
    private Pane inputWrapper;


    public void firstNameInput(MouseEvent mouseEvent) {
        inputWrapper.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void focusLostFirstName(MouseEvent mouseEvent) {
        inputWrapper.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
    }
}
