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

    public void loginAccount() {

        if (login_username.getText().isEmpty()
                || login_password.getText().isEmpty()) {
            alert.errorMessage("Incorrect Username/Password");
        } else {

            String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

            connect = Database.connectDB();

            try {

                if (!login_showPassword.isVisible()) {
                    if (!login_showPassword.getText().equals(login_password.getText())) {
                        login_showPassword.setText(login_password.getText());
                    }
                } else {
                    if (!login_showPassword.getText().equals(login_password.getText())) {
                        login_password.setText(login_showPassword.getText());
                    }
                }

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, login_username.getText());
                prepare.setString(2, login_password.getText());
                result = prepare.executeQuery();

                if (result.next()) {
                    alert.successMessage("Login Successfully");
                } else {
                    alert.errorMessage("Incorrect Username/Password");
                }
//                if (result.next()) {
//                    // TO GET THE USERNAME
//                    Data.admin_username = login_username.getText();
//                    Data.admin_id = Integer.parseInt(result.getString("admin_id"));
//
//                    // IF CORRECT USERNAME AND PASSWORD
//                    alert.successMessage("Login Successfully!");
//
//                    // LINK MAIN FORM FOR ADMIN
//                    Parent root = FXMLLoader.load(getClass().getResource("AdminMainForm.fxml"));
//                    Stage stage = new Stage();
//
//                    stage.setTitle("Hospital Management System | Admin Portal");
//                    stage.setScene(new Scene(root));
//                    stage.show();
//
//                    // TO HIDE YOUR ADMIN PAGE (LOGIN FORM)
//                    login_loginBtn.getScene().getWindow().hide();
//                } else {
//                    // IF WRONG USERNAME OR PASSWORD
//                    alert.errorMessage("Incorrect Username/Password");
//                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void loginShowPassword() {

        if (login_checkBox.isSelected()) {
            login_showPassword.setText(login_password.getText());
            login_showPassword.setVisible(true);
            login_password.setVisible(false);
        } else {
            login_password.setText(login_showPassword.getText());
            login_showPassword.setVisible(false);
            login_password.setVisible(true);
        }

    }

    public void registerAccount() {

        if (register_email.getText().isEmpty()
                || register_username.getText().isEmpty()
                || register_password.getText().isEmpty()) {
            // KALO KOSONG FIELD NYA
            alert.errorMessage("Please fill all blank fields");
        } else {

            // MEMERIKSA APAKAH USERNAME YANG DIMASUKKAN OLEH USER SUDAH ADA DI DATABASE
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
                } else if (register_password.getText().length() < 8) { // CEK JIKA PASSWORD MEMILIKI KARAKTER DIBAWAH 8
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
                    registerClear();

                    // UNTUK MENGGANTI FORM MENJADI LOGIN FORM
                    login_form.setVisible(true);
                    register_form.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // INI SIH FUNCTION YANG AKAN CLEAR FORM REGISTER SIAP DIGUNAKAN
    public void registerClear() {
        register_email.clear();
        register_username.clear();
        register_password.clear();
        register_showPassword.clear();
    }

    // FUNCTION UNTUK SHOW PASSWORD NYA DARI CHECKBOX
    public void registerShowPassword() {

        if (register_checkBox.isSelected()) {
            register_showPassword.setText(register_password.getText());
            register_showPassword.setVisible(true);
            register_password.setVisible(false);
        } else {
            register_password.setText(register_showPassword.getText());
            register_showPassword.setVisible(false);
            register_password.setVisible(true);
        }

    }

// Tombol Pindah Dari login ke register atau sebaliknya dari Link paling bawah
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
