package com.example.projectfrontend2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassScene {
    @FXML
    private ComboBox courses;

    @FXML
    private Button Routine;
    @FXML
    private Rectangle box;
    @FXML
    private Label teacher;
    @FXML
    private Label txt;

    @FXML
    private Label attendance_link;
    private int ass = 0;

    @FXML
    private Label post;

    @FXML
    private Button assignment;

    @FXML
    private Label due_ass;
    public void initialize(){
        courses.getItems().addAll("CSE 4402: Visual Programming Lab",
                                    "CSE 4404: Algorithms Lab",
                                    "CSE 4407: System Analysis and Design",
                                    "CSE 4403: Algorithms",
                                    "CSE 4405: Data and Telecommunications",
                                    "EEE 4483: Digital Electronics and Pulse Techniques",
                                    "EEE 4484: Digital Electronics and Pulse Techniques Lab",
                                    "MATH 4441: Probability and Statistics",
                                    "HUM 4441: Engineering Ethics");
    }
    @FXML
    protected void onCourseClick(){
        //Getting the course name that is selected
        String selected_course = (String)courses.getValue();
        txt.setText(selected_course);
        teacher.setText("Assigned Teacher: Mr. X");
        attendance_link.setText("Here will be the attendance spreadsheet link");
        post.setText("Tomorrow, there will be no class. Happy Sleeping! ");
        due_ass.setText("Assignments Due: " + ass);
        if(ass > 0){
            assignment.setText("Assignments Pending!");
            assignment.setTextFill(Color.RED);
        }
        else assignment.setText("No Assignments");

        box.setFill(Color.CYAN);
    }

    @FXML
    protected void goToRoutine(ActionEvent event) throws IOException{
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Routine.fxml"));
        Scene x = new Scene(fxmlLoader.load(), 800, 600);
        myStage.setScene(x);
        myStage.show();
    }
    
}
