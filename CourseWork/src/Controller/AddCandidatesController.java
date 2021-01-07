package Controller;

import Model.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class AddCandidatesController extends DbConnection implements Initializable {

    @FXML
    TextField cName, cParty, cNationality, cNicNo, cIndexNo, cAddress, cContactNo;

    @FXML
    DatePicker cDOB;

    @FXML
    RadioButton cFemale;

    @FXML
    RadioButton cMale;

    ToggleGroup cGender = new ToggleGroup();

    String name="", party="", nationality="", nicNo="", indexIDNo="", address="", contactNo="", dob="", radiobuttonlbl="";

    @FXML
    public void submitAddCandidate()  {

        try {
            LocalDate date = LocalDate.parse(cDOB.getValue().toString());
            name = cName.getText();
            party = cParty.getText();
            nationality = cNationality.getText();
            nicNo = cNicNo.getText();
            indexIDNo = cIndexNo.getText();
            address = cAddress.getText();
            contactNo = cContactNo.getText();
            dob = date.toString() ;
        }
        catch(Exception e)
        {

        }

        if (cMale.isSelected()) {
            radiobuttonlbl = cMale.getText();
        }
        if (cFemale.isSelected()){
            radiobuttonlbl = cFemale.getText();
       }

        try {
            int res = conn.createStatement().executeUpdate("insert into add_candidates (ID, Name, Party, Nationality, NIC_No," +
                    "Address, Contact_No, DOB, Gender) values('" + Integer.parseInt(indexIDNo) + "', '" + name + "', '" + party + "', '" + nationality + "', '" + nicNo + "'," +
                    " '" + address + "', '" + contactNo + "', '" + dob + "', '" + radiobuttonlbl + "')");

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Candidate Added");
                alert.setContentText("Candidate Added Successfully");
                alert.setHeaderText("Successful");
                alert.showAndWait();

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Candidate Not Added");
            alert.setContentText("Candidate Adding Unsuccessful");
            alert.setHeaderText("Unsuccessful");
            alert.showAndWait();

        }
    }

    public void resetAddCandidate() throws IOException {

        cName.clear();
        cParty.clear();
        cNationality.clear();
        cNicNo.clear();
        cIndexNo.clear();
        cAddress.clear();
        cContactNo.clear();
        cDOB.setValue(null);
        cMale.setSelected(false);
        cFemale.setSelected(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cMale.setToggleGroup(cGender);
        cFemale.setToggleGroup(cGender);

    }
}
