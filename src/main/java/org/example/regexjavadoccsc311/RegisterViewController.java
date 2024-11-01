package org.example.regexjavadoccsc311;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Controls the Register page
 *
 * @author Nicholas Papazis
 * */
public class RegisterViewController {


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
    private Button registerButton;

    //tracks whether the user has attempted to input into the fields
    private boolean firstNameClicked = false;
    private boolean lastNameClicked = false;
    private boolean emailClicked = false;
    private boolean dobClicked = false;
    private boolean zipCodeClicked = false;



    @FXML
    public void initialize() {

        registerButton.setDisable(true); //initially disable the register button

        //listen for changes in first name input field
        firstNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateFirstName(); //re-validate first name
        });
        //listen for changes in last name input field
        lastNameInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateLastName(); //re-validate last name
        });
        //listen for changes in email input field
        emailInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateEmail(); //re-validate email
        });
        //listen for changes in DOB input field
        dobInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateDOB(); //re-validate DOB
        });
        //listen for changes in zip code input field
        zipCodeInput.textProperty().addListener((observable, oldValue, newValue) -> {
            validateZipCode(); //re-validate zip code
        });


        //constantly monitors all fields to check if all are valid
        firstNameInput.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        lastNameInput.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        emailInput.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        dobInput.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        zipCodeInput.textProperty().addListener((observable, oldValue, newValue) -> validateFields());

    }


    private void validateFields() {
        //check if all fields are valid
        boolean allFieldsValid = validateFirstName() && validateLastName() && validateEmail() && validateDOB() && validateZipCode();

        //enable register button if all fields are valid
        registerButton.setDisable(!allFieldsValid);
    }

    public void firstNameInputClicked(MouseEvent mouseEvent) {
        firstNameClicked = true; //marks that uer has clicked this field
        focusLostAll(mouseEvent); //lose focus on all input fields
        firstNameInput.requestFocus(); //focus on name input field
        inputWrapperFN.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void lastNameInputClicked(MouseEvent mouseEvent) {
        lastNameClicked = true; //marks that user has clicked this field
        focusLostAll(mouseEvent);//lose focus on all input fields
        lastNameInput.requestFocus(); //focus on last name input field
        inputWrapperLN.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked

    }

    public void emailInputClicked(MouseEvent mouseEvent) {
        emailClicked = true; //marks that user has clicked this field
        focusLostAll(mouseEvent);//lose focus on all input fields
        emailInput.requestFocus(); //focus on email input field
        inputWrapperEmail.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked

    }

    public void dobInputClicked(MouseEvent mouseEvent) {
        dobClicked = true; //marks that user has clicked this field
        focusLostAll(mouseEvent);//lose focus on all input fields
        dobInput.requestFocus(); //focus on dob input field
        inputWrapperDOB.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }

    public void zipCodeInputClicked(MouseEvent mouseEvent) {
        zipCodeClicked = true; //marks that user has clicked this field
        focusLostAll(mouseEvent);//lose focus on all input fields
        zipCodeInput.requestFocus(); //focus on zip code input field
        inputWrapperZipCode.setStyle("-fx-border-color: #3B8EDC"); //add border when clicked
    }



    public void focusLostFirstName(MouseEvent mouseEvent) {
        //inputWrapperFN.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateFirstName(); //re-validate the input after focus is lost
    }


    public void focusLostLastName(MouseEvent mouseEvent) {
        //inputWrapperLN.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateLastName(); //re-validate the input after focus is lost
    }

    public void focusLostEmail(MouseEvent mouseEvent) {
        //inputWrapperEmail.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateEmail(); //re-validate the input after focus is lost
    }

    public void focusLostDOB(MouseEvent mouseEvent) {
        //inputWrapperDOB.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateDOB(); //re-validate the input after focus is lost
    }

    public void focusLostZipCode(MouseEvent mouseEvent) {
        //inputWrapperZipCode.setStyle("-fx-border-color: transparent;"); //remove border when focus is lost
        validateZipCode(); //re-validate the input after focus is lost
    }

    public void focusLostAll(MouseEvent mouseEvent) {

        //lose focus on all input fields
        focusLostFirstName(mouseEvent);
        focusLostLastName(mouseEvent);
        focusLostEmail(mouseEvent);
        focusLostDOB(mouseEvent);
        focusLostZipCode(mouseEvent);

        innerBox.requestFocus(); //removes focus from any input fields

    }

    //used for real time validation
    public boolean validateFirstName() {
        final String regex = "^.{2,25}$"; //regular expression
        String userInput = firstNameInput.getText(); //gets text from input

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
            //only shows warnings if user has attempted to input into the field
            if(firstNameClicked && firstNameInput.getLength() > 0){
                inputWrapperFN.setStyle("-fx-border-color: red");
                validateImgFN.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
                alertTextFN.setText("* First name must be 2-25 characters");
                return false;
            }
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
            if(lastNameClicked && lastNameInput.getLength() > 0){
                inputWrapperLN.setStyle("-fx-border-color: red");
                validateImgLN.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
                alertTextLN.setText("* Last name must be 2-25 characters");
                return false;
            }
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
            if(emailClicked && emailInput.getLength() > 0){
                inputWrapperEmail.setStyle("-fx-border-color: red");
                validateImgEmail.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
                alertTextEmail.setText("* Email must end with @farmingdale.edu");
                return false;
            }
            return false;

        }

    }

    /**
     * Checks if dob input field is valid
     *
     * @return true if dob in input field is valid, false otherwise
     * */
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
            if(dobClicked && dobInput.getLength() > 0){
                inputWrapperDOB.setStyle("-fx-border-color: red");
                validateImgDOB.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
                alertTextDOB.setText("* Enter DOB in MM/DD/YYYY format");
                return false;
            }
            return false;

        }

    }

    /**
     * Checks if zip code input field is valid
     *
     * @return true if zip code in input field is valid, false otherwise
     * */
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
            if(zipCodeClicked && zipCodeInput.getLength()>0){
                inputWrapperZipCode.setStyle("-fx-border-color: red");
                validateImgZipCode.setImage(new Image(getClass().getResource("x.png").toExternalForm()));
                alertTextZipCode.setText("* Enter a 5-digit zip code");
                return false;
            }
            return false;

        }

    }


    /**
     * Changes view to success.fxml
     *
     * @Param actionEvent the event that triggers this function to run.
     * */
    public void navigateToHomeScreen(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("success.fxml"));
            Scene scene = new Scene(root, 900, 600);
            scene.getStylesheets().add(getClass().getResource("login-styles.css").toExternalForm());
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
