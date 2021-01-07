package Controller;

import Model.DbConnection;
import Model.ModelTable1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class VotingController extends DbConnection implements Initializable {

    @FXML
    private TextField voterTextField, voterTextField2;

    @FXML
    private Button submitVoterID;

    @FXML
    private TableView<ModelTable1> tableView1;

    @FXML
    private TableColumn<ModelTable1, String> col_id;

    @FXML
    private TableColumn<ModelTable1, String> col_name;

    @FXML
    private TableColumn<ModelTable1, String> col_party;

    ObservableList<ModelTable1> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            ResultSet res = conn.createStatement().executeQuery("select ID, Name, Party from add_candidates");
            while (res.next()) {
                observableList.add(new ModelTable1(res.getString("ID"), res.getString("Name"),
                        res.getString("Party")));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("indexIDNo"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_party.setCellValueFactory(new PropertyValueFactory<>("party"));

        tableView1.setItems(observableList);
    }

    public void submitVoterID(ActionEvent actionEvent) throws IOException {

        String votersID = voterTextField2.getText();
        String vote = voterTextField.getText();

        try {
            ResultSet res = conn.createStatement().executeQuery("select ID from voters_ballots where ID = '" + votersID + "'");

            if (res.next()) {

                try {
                    conn.createStatement().executeUpdate("insert into votes (voterID, candidateID) values ('" + votersID + "', '" + vote + "')");

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Voted");
                    alert.setContentText("You Have Voted Successfully");
                    alert.setHeaderText("Successfully Voted");
                    alert.showAndWait();

                } catch (Exception e) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Vote Not Added");
                    alert.setContentText("You Have Voted Already");
                    alert.setHeaderText("Voting Unsuccessful");
                    alert.showAndWait();

                }

                Stage newstage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("../View/adminLogin.fxml"));
                newstage.setTitle("Login");
                newstage.setScene(new Scene(root, 1008, 624));
                newstage.show();

                Stage newstage2 = (Stage) submitVoterID.getScene().getWindow();
                newstage2.close();
            }

            else {

                voterTextField2.clear();
                voterTextField.clear();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid Voter ID");
                alert.setContentText("Your Voter ID is Invalid");
                alert.setHeaderText("Invalid Voter ID");
                alert.showAndWait();

            }

            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void resetVoterID() {

        voterTextField.clear();
        voterTextField2.clear();
    }
}



