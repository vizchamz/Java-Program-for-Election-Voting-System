package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminOptionsController {

    @FXML
    public Button logoutButton, manageCandidatesButton, manageBallotsButton, manageVotingButton;

    public void logoutButton(ActionEvent actionEvent) throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/adminLogin.fxml"));
        newstage.setTitle("Login");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) logoutButton.getScene().getWindow();
        newstage2.close();
    }

    public void manageCandidatesButton(ActionEvent actionEvent) throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/manageCandidates.fxml"));
        newstage.setTitle("Manage Candidates");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) manageCandidatesButton.getScene().getWindow();
        newstage2.close();
    }

    public void manageBallotsButton(ActionEvent actionEvent) throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/manageBallots.fxml"));
        newstage.setTitle("Manage Ballot Papers");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) manageCandidatesButton.getScene().getWindow();
        newstage2.close();
    }

    public void manageVotingButton(ActionEvent actionEvent) throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/manageVoting.fxml"));
        newstage.setTitle("Manage Voting");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) manageVotingButton.getScene().getWindow();
        newstage2.close();
    }
}
