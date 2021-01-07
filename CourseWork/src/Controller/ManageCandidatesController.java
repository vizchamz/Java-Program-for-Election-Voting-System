package Controller;

import Model.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class ManageCandidatesController extends Main {

    @FXML
    private Pane tablePane;

    @FXML
    public Button viewCandidatesButton, cancelOptions, addCandidates;

    public void cancelOptions(ActionEvent actionEvent) throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/adminOptions.fxml"));
        newstage.setTitle("Admin Options");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) cancelOptions.getScene().getWindow();
        newstage2.close();
    }

    public void viewCandidatesButton(ActionEvent event) throws IOException {

       Pane newLoadedPane = FXMLLoader.load(getClass().getResource("../View/viewCandidates.fxml"));
                tablePane.getChildren().setAll(newLoadedPane);
            }

    public void addCandidates(ActionEvent event) throws IOException {

        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("../View/addCandidates.fxml"));
        tablePane.getChildren().setAll(newLoadedPane);
    }

    public void editCandidates(ActionEvent event) throws IOException {

        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("../View/editCandidates.fxml"));
        tablePane.getChildren().setAll(newLoadedPane);
    }

    public void deleteCandidates(ActionEvent event) throws IOException {

        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("../View/deleteCandidates.fxml"));
        tablePane.getChildren().setAll(newLoadedPane);
    }
}
