package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.http.RequestMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistration {

    @FXML
    private ComboBox<ClassroomDTO> courses;


    @FXML
    private Label txt;


    private int ass = 0;

    @FXML
    private Label course;
    @FXML
    private Label teacher;


    @FXML
    private Label due_ass;
    public void initialize() throws IOException, InterruptedException {
        RequestMaker rqm= new RequestMaker();
        List<ClassroomDTO> classroomDTOS = rqm.fetch_all_classroom() ;

        courses.getItems().clear();
        for(ClassroomDTO x : classroomDTOS){
            courses.getItems().add(x);
        }



    }
    @FXML
    protected void onCourseClick(){
        //Getting the course name that is selected
        ClassroomDTO selected_course = courses.getValue();
        txt.setText(selected_course.toString());



        course.setText(selected_course.getCoursename());
        teacher.setText("Mr. X , Designation");
        due_ass.setText("Nothing due");



    }

    @FXML
    protected void goToRoutine(ActionEvent event) throws IOException {
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
}
