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
    private Pane inputWrapperFN;
    @FXML
    private Pane inputWrapperLN;
    @FXML
    private Pane inputWrapperEmail;
    @FXML
    private Pane inputWrapperDOB;
    @FXML
    private Pane inputWrapperZipCode;

    @FXML
    private Pane innerBox;



    public void firstNameInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        inputWrapperFN.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void lastNameInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        inputWrapperLN.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void emailInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        inputWrapperEmail.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void dobInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        inputWrapperDOB.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void zipCodeInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        inputWrapperZipCode.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }



    public void focusLostFirstName(MouseEvent mouseEvent) {
        inputWrapperFN.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
    }

    public void focusLostLastName(MouseEvent mouseEvent) {
        inputWrapperLN.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
    }

    public void focusLostEmail(MouseEvent mouseEvent) {
        inputWrapperEmail.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
    }

    public void focusLostDOB(MouseEvent mouseEvent) {
        inputWrapperDOB.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
    }

    public void focusLostZipCode(MouseEvent mouseEvent) {
        inputWrapperZipCode.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
    }

    public void focusLostAll(MouseEvent mouseEvent) {

        focusLostFirstName(mouseEvent);
        focusLostLastName(mouseEvent);
        focusLostEmail(mouseEvent);
        focusLostDOB(mouseEvent);
        focusLostZipCode(mouseEvent);

        innerBox.requestFocus(); //removes focus from any input fields


    }



}
