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
    private ImageView validateImgLN;
    @FXML
    private ImageView validateImgEmail;
    @FXML
    private ImageView validateImgDOB;
    @FXML
    private ImageView validateImgZipCode;

    @FXML
    private Pane innerBox;

    @FXML
    private Text alertTextFN;
    @FXML
    private Text alertTextLN;
    @FXML
    private Text alertTextEmail;
    @FXML
    private Text alertTextDOB;
    @FXML
    private Text alertTextZipCode;

    @FXML
    public void initialize() {
        //innerBox.requestFocus(); //removes focus from textFields
        firstNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateFirstName(); // Call validate method on text change
        });
        lastNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateLastName();
        });
        emailInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail();
        });
        dobInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateDOB();
        });
        zipCodeInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateZipCode();
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
        validateLastName(); //re-validate the input after focus is lost
    }

    public void focusLostEmail(MouseEvent mouseEvent) {
        inputWrapperEmail.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateEmail();
    }

    public void focusLostDOB(MouseEvent mouseEvent) {
        inputWrapperDOB.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateDOB();
    }

    public void focusLostZipCode(MouseEvent mouseEvent) {
        inputWrapperZipCode.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateZipCode();
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
            alertTextFN.setText("* First name must be 2-25 characters");
            return false;
        }

    }

    //used for real time validation
    public boolean validateLastName() {
        final String regex = "^.{2,25}$";
        String userInput = lastNameInput.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(userInput);

        boolean inputValid = matcher.matches(); //check if input matches regex

        if(inputValid){
            inputWrapperLN.setStyle("-fx-border-color: green");
            validateImgLN.setImage(new Image(getClass().getResource("check.png").toExternalForm()));
            alertTextLN.setText("");
            return true;
        }
        else {
            inputWrapperLN.setStyle("-fx-border-color: red");
            validateImgLN.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
            alertTextLN.setText("* Last name must be 2-25 characters");
            return false;
        }

    }


    public boolean validateEmail() {
        final String regex = "(([a-zA-Z])(\\w)+)@(farmingdale).(edu)";
        String userInput = emailInput.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(userInput);

        boolean inputValid = matcher.matches(); //check if input matches regex

        if(inputValid){
            inputWrapperEmail.setStyle("-fx-border-color: green");
            validateImgEmail.setImage(new Image(getClass().getResource("check.png").toExternalForm()));
            alertTextEmail.setText("");
            return true;
        }
        else {
            inputWrapperEmail.setStyle("-fx-border-color: red");
            validateImgEmail.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
            alertTextEmail.setText("* Email must end with @farmingdale.edu");
            return false;
        }

    }

    public boolean validateDOB() {
        final String regex = "(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4})";
        String userInput = dobInput.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(userInput);

        boolean inputValid = matcher.matches(); //check if input matches regex

        if(inputValid){
            inputWrapperDOB.setStyle("-fx-border-color: green");
            validateImgDOB.setImage(new Image(getClass().getResource("check.png").toExternalForm()));
            alertTextDOB.setText("");
            return true;
        }
        else {
            inputWrapperDOB.setStyle("-fx-border-color: red");
            validateImgDOB.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
            alertTextDOB.setText("* Enter DOB in MM/DD/YYYY format");
            return false;
        }

    }

    public boolean validateZipCode() {
        final String regex = "^\\d{5}$";
        String userInput = zipCodeInput.getText();

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(userInput);

        boolean inputValid = matcher.matches(); //check if input matches regex

        if(inputValid){
            inputWrapperZipCode.setStyle("-fx-border-color: green");
            validateImgZipCode.setImage(new Image(getClass().getResource("check.png").toExternalForm()));
            alertTextZipCode.setText("");
            return true;
        }
        else {
            inputWrapperZipCode.setStyle("-fx-border-color: red");
            validateImgZipCode.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
            alertTextZipCode.setText("* Enter a 5-digit zip code");
            return false;
        }

    }





}
