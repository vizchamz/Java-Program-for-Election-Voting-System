package Controller;

import java.io.IOException;
import java.sql.*;

import Model.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController extends DbConnection {

    @FXML
    private TextField textField, textField1;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button button;

    String userN;
    String passW;
    String voterID;

    public void adminLogin() throws IOException {
        userN = textField.getText();
        passW = passwordField.getText();

        try {
            ResultSet res = conn.createStatement().executeQuery("select * from admin_login_credentials where username = '" + userN + "' AND password = '" + passW + "'");
            if (res.next()) {

                Stage newstage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../View/adminOptions.fxml"));
                newstage.setTitle("Admin Options");
                newstage.setScene(new Scene(root, 1008, 624));
                newstage.show();

                Stage primaryStage = (Stage) button.getScene().getWindow();
                primaryStage.close();

            } else {

                textField.clear();
                passwordField.clear();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid Credentials");
                alert.setContentText("Invalid Username or Password");
                alert.setHeaderText("Invalid Credentials");
                alert.showAndWait();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void voterLogin() throws IOException {

        voterID = textField1.getText();

        try {
            ResultSet res = conn.createStatement().executeQuery("select ID from voters_ballots where ID = '" + voterID + "'");
            if (res.next()) {

                Stage newstage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../View/Voting.fxml"));
                newstage.setTitle("Vote Here");
                newstage.setScene(new Scene(root, 1008, 624));
                newstage.show();

                Stage primaryStage = (Stage) button.getScene().getWindow();
                primaryStage.close();

            } else {

                textField1.clear();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid Voter ID");
                alert.setContentText("Your Voter ID is Invalid");
                alert.setHeaderText("Invalid Voter ID");
                alert.showAndWait();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetLogin() {
        textField.clear();
        passwordField.clear();
    }

    public void resetVoter() {

        textField1.clear();
    }
}