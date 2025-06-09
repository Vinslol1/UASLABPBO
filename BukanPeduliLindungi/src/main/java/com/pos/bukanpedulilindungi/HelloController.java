package com.pos.bukanpedulilindungi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private CheckBox login_checkBox;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button login_logInBtn;

    @FXML
    private PasswordField login_password;

    @FXML
    private Hyperlink login_registerHere;

    @FXML
    private TextField login_showPassword;

    @FXML
    private ComboBox<?> login_user;

    @FXML
    private TextField login_username;

    @FXML
    private CheckBox register_checkBox;

    @FXML
    private TextField register_email;

    @FXML
    private AnchorPane register_form;

    @FXML
    private Hyperlink register_logInHere;

    @FXML
    private PasswordField register_password;

    @FXML
    private TextField register_showPassword;

    @FXML
    private Button register_signupBtn;

    @FXML
    private TextField register_username;

    // Database Tools (WAJIB UNTUK DATABASE)
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private AlertMessage alert = new AlertMessage();

    public void registerAccount() {

        if (register_email.getText().isEmpty()
                || register_username.getText().isEmpty()
                || register_password.getText().isEmpty()) {
            // LETS CREATE OUR ALERT MESSAGE
            alert.errorMessage("Please fill all blank fields");
        } else {

            // WE WILL CHECK IF THE USERNAME THAT USER ENTERED IS ALREADY EXIST TO OUR DATABASE
            String checkUsername = "SELECT * FROM admin WHERE username = '"
                    + register_username.getText() + "'";

            connect = Database.connectDB();

            try {

                if (!register_showPassword.isVisible()) {
                    if (!register_showPassword.getText().equals(register_password.getText())) {
                        register_showPassword.setText(register_password.getText());
                    }
                } else {
                    if (!register_showPassword.getText().equals(register_password.getText())) {
                        register_password.setText(register_showPassword.getText());
                    }
                }

                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert.errorMessage(register_username.getText() + " is already exist!");
                } else if (register_password.getText().length() < 8) { // CHECK IF THE CHARACTERS OF THE PASSWORD IS LESS THAN TO 8
                    alert.errorMessage("Invalid Password, at least 8 characters needed");
                } else {
                    // TO INSERT THE DATA TO OUR DATABASE
                    String insertData = "INSERT INTO admin (email, username, password, date) VALUES(?,?,?,?)";

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, register_email.getText());
                    prepare.setString(2, register_username.getText());
                    prepare.setString(3, register_password.getText());
                    prepare.setString(4, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert.successMessage("Registered Successfully!");
//                    registerClear();
//
//                    // TO SWITCH THE FORM INTO LOGIN FORM
//                    login_form.setVisible(true);
//                    register_form.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchForm(ActionEvent event){
        if(event.getSource() == login_registerHere) {
            // register form akan muncul :))
            login_form.setVisible(false);
            register_form.setVisible(true);
        } else if (event.getSource() == register_logInHere){
            // login form akan muncul (╯°□°)╯( ┻━┻
            login_form.setVisible(true);
            register_form.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
