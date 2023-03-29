package com.example.projectfrontend2_2.Classroom;

import com.example.projectfrontend2_2.Attendance;
import com.example.projectfrontend2_2.HelloApplication;
import com.example.projectfrontend2_2.core2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class CreateAssignment {
    @FXML
    private Button files;

    @FXML
    private ListView listview;

    @FXML
    private Button back;

    public void ButtonAction(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files",  "*.pdf")
        );
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if(selectedFiles != null){
            for(int i = 0; i < selectedFiles.size(); ++i){
                listview.getItems().add(selectedFiles.get(i).getName());
            }

        }else{
            System.out.println("File Not Valid!");
        }
    }

    @FXML
    public void GoBack(ActionEvent event) throws IOException, InterruptedException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scrolscrene2.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        core2 obj = fxmlLoader.getController();

        myStage.setScene(subtractionScene);
        myStage.show();
    }
}
