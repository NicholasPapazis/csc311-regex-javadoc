package org.example.regexjavadoccsc311;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginViewController {


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
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField dobInput;
    @FXML
    private TextField zipCodeInput;

    @FXML
    private ImageView validateImgFN;

    @FXML
    private Pane innerBox;

    @FXML
    private Text alertTextFN;

    @FXML
    public void initialize() {
        //innerBox.requestFocus(); //removes focus from textFields
        firstNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateFirstName(); // Call validate method on text change
        });
    }

    public void firstNameInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        firstNameInput.requestFocus();
        inputWrapperFN.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void lastNameInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        lastNameInput.requestFocus();
        inputWrapperLN.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked

    }

    public void emailInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        emailInput.requestFocus();
        inputWrapperEmail.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked

    }

    public void dobInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        dobInput.requestFocus();
        inputWrapperDOB.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void zipCodeInputClicked(MouseEvent mouseEvent) {
        focusLostAll(mouseEvent);
        zipCodeInput.requestFocus();
        inputWrapperZipCode.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }



    public void focusLostFirstName(MouseEvent mouseEvent) {
        inputWrapperFN.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateFirstName(); //re-validate the input after focus is lost
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

    //used for real time validation
    public boolean validateFirstName() {
        final String regex = "^.{2,25}$";
        String userInput = firstNameInput.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(userInput);

        boolean inputValid = matcher.matches(); //check if input matches regex

        if(inputValid){
            inputWrapperFN.setStyle("-fx-border-color: green");
            validateImgFN.setImage(new Image(getClass().getResource("check.png").toExternalForm()));
            alertTextFN.setText("");
            return true;
        }
        else {
            inputWrapperFN.setStyle("-fx-border-color: red");
            validateImgFN.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
            alertTextFN.setText("*First name must be 2-25 characters.");
            return false;
        }



    }


}
