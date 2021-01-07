package Controller;

import Model.DbConnection;
import Model.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditCandidatesController extends DbConnection implements Initializable {

    @FXML
    private TableView<ModelTable> tableView;

    @FXML
    private TableColumn<ModelTable, String> col_name;

    @FXML
    private TableColumn<ModelTable, String> col_id;

    @FXML
    private TableColumn<ModelTable, String> col_address;

    @FXML
    private TableColumn<ModelTable, String> col_nationality;

    @FXML
    private TableColumn<ModelTable, String> col_party;

    @FXML
    private TableColumn<ModelTable, String> col_nic;

    @FXML
    private TableColumn<ModelTable, String> col_contact;

    @FXML
    private TableColumn<ModelTable, String> col_gender;

    @FXML
    private TableColumn<ModelTable, String> col_dob;

    ObservableList<ModelTable> observableList = FXCollections.observableArrayList();

    private String newID, selectedItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            ResultSet res = conn.createStatement().executeQuery("select * from add_candidates");
            while (res.next()) {
                observableList.add(new ModelTable(res.getString("ID"), res.getString("Name"),
                        res.getString("Party"), res.getString("Nationality"), res.getString("NIC_No"), res.getString("Address"),
                        res.getString("Contact_No"), res.getString("DOB"), res.getString("Gender")));


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("indexIDNo"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_party.setCellValueFactory(new PropertyValueFactory<>("party"));
        col_nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        col_nic.setCellValueFactory(new PropertyValueFactory<>("nicNo"));
        col_contact.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        tableView.setItems(observableList);

        tableView.setEditable(true);
        col_name.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void onEditChanged(TableColumn.CellEditEvent<ModelTable,String> event) {

        Object newValue = event.getNewValue();

        TablePosition<ModelTable,String> position = event.getTablePosition();
        int row = position.getRow();
        System.out.println(row);


        try {
            int res = conn.createStatement().executeUpdate("update add_candidates set Name = " + newID + " where ID = " + selectedItem + ")");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Candidate Updated");
            alert.setContentText("Candidate Update Successfully");
            alert.setHeaderText("Successful");
            alert.showAndWait();

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Candidate Not Updated");
            alert.setContentText("Candidate Update Unsuccessful");
            alert.setHeaderText("Unsuccessful");
            alert.showAndWait();

            e.printStackTrace();
        }

    }

    public String getSelectedItem() {

        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {

        this.selectedItem = selectedItem;
    }
}

