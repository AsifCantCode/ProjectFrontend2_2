package com.example.projectfrontend2_2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ClassScene {
    @FXML
    private ComboBox courses;

    @FXML
    private Button Routine;
    @FXML
    private Rectangle box;
    @FXML
    private Label txt;

    public void initialize(){
        courses.getItems().addAll("CSE 4402", "CSE 4404", "CSE 4407", "CSE 4403", "CSE 4405", "EEE 4483", "EEE 4484", "MATH 4441", "HUM 4441");
    }
    @FXML
    protected void onCourseClick(){
        //Getting the course name that is selected
        String selected_course = (String)courses.getValue();
        box.setFill(Color.BLUE);
    }
    
}
