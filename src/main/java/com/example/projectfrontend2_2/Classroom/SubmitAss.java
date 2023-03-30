package com.example.projectfrontend2_2.Classroom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class SubmitAss {
    @FXML
    private Button files;

    @FXML
    private ListView listview;

    @FXML
    private TextField comments;

    @FXML
    private TextField course_name;

    @FXML
    private TextField ass_title;

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
}
