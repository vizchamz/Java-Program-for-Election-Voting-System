package Controller;

import Model.DbConnection;
import Model.ModelTable2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageBallotsController extends DbConnection {

    @FXML
    private Button cancelButton;

    @FXML
    private TableView<ModelTable2> tableView2;

    @FXML
    private TableColumn<ModelTable2, String> col_id;

    @FXML
    private TableColumn<ModelTable2, String> col_name;

    @FXML
    private TableColumn<ModelTable2, String> col_dob;

    static ObservableList<ModelTable2> observableList = FXCollections.observableArrayList();

    public void cancelButton() throws IOException {

        Stage newstage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../View/adminOptions.fxml"));
        newstage.setTitle("Admin Options");
        newstage.setScene(new Scene(root, 1008, 624));
        newstage.show();

        Stage newstage2 = (Stage) cancelButton.getScene().getWindow();
        newstage2.close();

    }

    private static List<String> getBallotsFromFile(String path) {
        List<String> voters = new ArrayList<String>();

        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);
            System.out.println("File Imported");

            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split(",");

                try {
                    conn.createStatement().executeUpdate("insert into voters_ballots (ID, Name, DOB) values ('" + data[0] + "', '" + data[1] + "', '" + data[2] + "')");

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Ballot Added");
                    alert.setContentText("Ballot Added Successfully");
                    alert.setHeaderText("Successful");
                    alert.showAndWait();

                } catch (Exception e) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ballot Not Added");
                    alert.setContentText("Ballot Adding Unsuccessful");
                    alert.setHeaderText("Unsuccessful");
                    alert.showAndWait();

                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Available");
            ex.printStackTrace();
        } catch (Exception e){
            System.out.println("Something Else Went Wrong");
            e.printStackTrace();
        }
        return voters;
    }

    public void importBallotsButton() throws IOException {
        List<String> voters = getBallotsFromFile("src/VotersBallots.txt");

        try {
            ResultSet res = conn.createStatement().executeQuery("select * from voters_ballots");
            while (res.next()) {
                observableList.add(new ModelTable2(res.getString("ID"), res.getString("Name"),
                        res.getString("DOB")));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("DOB"));

        tableView2.setItems(observableList);
    }
}
