package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/adminLogin.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 1008, 624));
        primaryStage.show();
    }
}


/*
*
* References
*
•	http://tutorials.jenkov.com/javafx/radiobutton.html
•	https://www.swtestacademy.com/database-operations-javafx/
•	https://stackoverflow.com/questions/18941093/how-to-fill-up-a-tableview-with-database-data
•	https://www.youtube.com/watch?v=_FBPukQOLCY
•	https://stackoverflow.com/questions/16111525/how-do-i-reset-clear-jradiobutton-in-java#:~:text=If%20you%20want%20to%20clear,setSelected(false)%20.
•	https://stackoverflow.com/questions/34702122/how-to-get-editable-tableview-cell-value-after-edit-complete-in-javafx-fxml
*
*
 */