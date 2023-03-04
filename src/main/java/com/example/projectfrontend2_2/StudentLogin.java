package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.Login.LoginDTO;
import com.example.projectfrontend2_2.Student.StudentDTO;
import com.example.projectfrontend2_2.http.RequestMaker;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentLogin {

    private String pass = "iutcse";
    private int userID = 1234;

    static StudentDTO studentDTO;

    static List<ClassroomDTO> all_classrooms;

    @FXML
    private TextField studentID;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField passWord;

    //function for getting pass and username
    @FXML
    protected void pressedLoginButton(){


    }
    @FXML
    protected void goToClass(ActionEvent event) throws IOException , InterruptedException{


        //int inp_ID = Integer.parseInt(studentID.getText());
        //String inp_pass = passWord.getText();


        LoginDTO ldto = new LoginDTO();
        Gson gson = new Gson();
        ldto.setStudentid(Long.parseLong(studentID.getText()));
        ldto.setPassword(passWord.getText());

        System.out.println("here");
        String jackson = gson.toJson(ldto );
        System.out.println( jackson +" weifhwe weofhwoe woefw");
        RequestMaker rqm = new RequestMaker();

        StudentDTO stdo = rqm.login_attempt(ldto , "/login/student");
        System.out.println(stdo.getStudid());
        if(stdo.getStudid().equals(ldto.getStudentid()))
        {
            studentDTO = stdo;

            List<Long> classroom_id = studentDTO.getClassroom_id();

            System.out.println(classroom_id.size());
            for(Long x : classroom_id){
                System.out.println(x);
            }
            all_classrooms = new ArrayList<>();
            for(Long x : classroom_id){
                all_classrooms.add(rqm.fetch_classroom(x.intValue()));
            }

            Node root = (Node) event.getSource();
            Stage myStage = (Stage) root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ClassScene.fxml"));
            Scene studentscene = new Scene(fxmlLoader.load(), 800, 600);
            myStage.setScene(studentscene);
            myStage.show();

        }



    }
}
