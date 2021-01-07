package Controller;

import Model.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageVotingController extends DbConnection {

    String visal;

    @FXML
    private Button cancelButton, logoutButton;

    public void cancelButton() throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/adminOptions.fxml"));
        newstage.setTitle("Admin Options");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) cancelButton.getScene().getWindow();
        newstage2.close();

    }

    public void logoutButton(ActionEvent actionEvent) throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/adminLogin.fxml"));
        newstage.setTitle("Login");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) logoutButton.getScene().getWindow();
        newstage2.close();
    }

    public void endVotingButton(ActionEvent actionEvent) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Voting Ended");
        alert.setContentText("Voting Ended Successfully");
        alert.setHeaderText("Voting Ended");
        alert.showAndWait();
        /*try
        {
            ResultSet res1=conn.createStatement().executeQuery("SELECT Name from add_candidates");
            while ((res1.next()))
            visal = res1.getString("Name");
            System.out.println(visal);
            {
                try {
                    ResultSet res = conn.createStatement().executeQuery("SELECT Count(voterID) FROM election_voting_system.votes where candidateID = '" + visal + "'");
                    if(res.next())
                    {
                        System.out.println(res1.getString("Name") + "-" + res.getInt(1));
                        //System.out.println("Trump: " + Integer.parseInt(res) * "*");
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
        catch(Exception e)
        {

        }*/

    }

    public void startVotingButton(ActionEvent actionEvent) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Voting Started");
        alert.setContentText("Voting Started Successfully");
        alert.setHeaderText("Voting Started");
        alert.showAndWait();
    }
}
