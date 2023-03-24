package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.Student.StudentDTO;
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

public class ClassScene2 {
    @FXML
    private ComboBox<ClassroomDTO> courses;
    private ClassroomDTO course2;
    @FXML
    private Button Logout;


    @FXML
    private Label coursename;


    @FXML
    private Label txt;

    @FXML
    private Label attendance_link;
    private int ass = 0;

    @FXML
    private Label course;
    @FXML
    private Label teacher;


    @FXML
    private Label due_ass;
    public void initialize(){
//        courses.getItems().addAll("CSE 4402: Visual Programming Lab",
//                                    "CSE 4404: Algorithms Lab",
//                                    "CSE 4407: System Analysis and Design",
//                                    "CSE 4403: Algorithms",
//                                    "CSE 4405: Data and Telecommunications",
//                                    "EEE 4483: Digital Electronics and Pulse Techniques",
//                                    "EEE 4484: Digital Electronics and Pulse Techniques Lab",
//                                    "MATH 4441: Probability and Statistics",
//                                    "HUM 4441: Engineering Ethics");

        for(ClassroomDTO c : StudentLogin.all_classrooms){
            courses.getItems().add(c);
        }
        //semester.setText("Current Semester : " + StudentLogin.studentDTO.getSemester());
    }
    @FXML
    protected void onCourseClick(){
        //Getting the course name that is selected
        ClassroomDTO selected_course = courses.getValue();
        txt.setText(selected_course.toString());
        course2 = selected_course;

       course.setText(selected_course.getCoursename());
       teacher.setText("Mr. X");
       due_ass.setText("No due");



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

    public void goToHome(ActionEvent event) throws IOException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        myStage.setScene(subtractionScene);
        myStage.show();
    }

    public void goToCore(ActionEvent event) throws IOException, InterruptedException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scrolscrene.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        core obj = fxmlLoader.getController();
        obj.setCdto(course2);
        obj.init();
        myStage.setScene(subtractionScene);
        myStage.show();
    }

}
