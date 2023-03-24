package com.example.projectfrontend2_2.Classroom;

import com.example.projectfrontend2_2.HelloApplication;
import com.example.projectfrontend2_2.Login.StudentLogin;
import com.example.projectfrontend2_2.Student.StudentDTO;
import com.example.projectfrontend2_2.core;
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
import java.util.List;

public class ClassScene2 {
    @FXML
    private ComboBox<ClassroomDTO> courses;
    private ClassroomDTO course2;

    private StudentDTO sdto;
    @FXML
    private Button Logout;

    private List<ClassroomDTO> all_classrooms;
    @FXML
    private Label coursename;
    @FXML
    private Label txt;


    private int ass = 0;

    @FXML
    private Label course;
    @FXML
    private Label teacher;


    @FXML
    private Label due_ass;
    public void initialize(){

        if(all_classrooms == null) return;
        for(ClassroomDTO c : all_classrooms){
            courses.getItems().add(c);
        }

    }

    public List<ClassroomDTO> getAll_classrooms() {
        return all_classrooms;
    }

    public void setAll_classrooms(List<ClassroomDTO> all_classrooms) {
        this.all_classrooms = all_classrooms;
    }

    public StudentDTO getSdto() {
        return sdto;
    }

    public void setSdto(StudentDTO sdto) {
        this.sdto = sdto;
    }

    @FXML
    protected void onCourseClick(){
        //Getting the course name that is selected
        ClassroomDTO selected_course = courses.getValue();
        txt.setText(selected_course.toString());
        course2 = selected_course;

       course.setText(selected_course.getCoursename());
       teacher.setText("Mr. X , Designation");
       due_ass.setText("Nothing due");



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
        obj.setSdto(sdto);
        obj.init();
        myStage.setScene(subtractionScene);
        myStage.show();
    }

}
