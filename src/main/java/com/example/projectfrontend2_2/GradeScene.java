package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.AssignmentDTO;
import com.example.projectfrontend2_2.Student.StudentDTO;
import com.example.projectfrontend2_2.post.PostDTO;
import com.example.projectfrontend2_2.teacher.TeacherDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GradeScene {

    @FXML
    private ScrollPane submissions;
    @FXML
    private ScrollPane files;

    @FXML
    private TextField grade;

    @FXML
    private Label assignment_name;
    @FXML
    private  Label student_name;
    @FXML
    private Label total_grade;

    private AssignmentDTO adto;

    private TeacherDTO tdto;


    public  void init() throws IOException {


        VBox vb = new VBox();
        vb.setSpacing(5);
        for(int i = 0 ; i < 10 ; i++){
            FXMLLoader fxl = new FXMLLoader(HelloApplication.class.getResource("submissionview.fxml"));
            Node e = fxl.load();
            Submissionview tc = fxl.getController();
            tc.getName().setText("Hello " + i);

            vb.getChildren().add(e);
            VBox.setVgrow(e, Priority.ALWAYS);
        }

        submissions.setContent(vb);


        VBox vb2 = new VBox();
        vb2.setSpacing(5);
        for(int i = 0 ; i < 10 ; i++){
            FXMLLoader fxl = new FXMLLoader(HelloApplication.class.getResource("FileView.fxml"));
            Node e = fxl.load();
            FileView tc = fxl.getController();


            vb2.getChildren().add(e);
            VBox.setVgrow(e, Priority.ALWAYS);
        }

        files.setContent(vb2);
    }

}
