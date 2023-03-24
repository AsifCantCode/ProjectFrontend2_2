package com.example.projectfrontend2_2.Login;

import com.example.projectfrontend2_2.Classroom.ClassScene;
import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.HelloApplication;
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



    static StudentDTO studentDTO;

    private List<ClassroomDTO> all_classrooms;

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
        ldto.setCommon_id(Long.parseLong(studentID.getText()));
        ldto.setPassword(passWord.getText());

        System.out.println("here");
        String jackson = gson.toJson(ldto );
        System.out.println( jackson +" weifhwe weofhwoe woefw");
        RequestMaker rqm = new RequestMaker();

        StudentDTO stdo = rqm.login_attempt(ldto , "/login/student");
        System.out.println(stdo.getStudid());
        if(stdo.getStudid().equals(ldto.getCommon_id()))
        {
            studentDTO = stdo;

            List<Long> classroom_id = studentDTO.getClassroom_id();

            System.out.println(classroom_id.size());
            for(Long x : classroom_id){
                System.out.println(x);
            }
            all_classrooms = new ArrayList<>();
            for(Long x : classroom_id){
                all_classrooms.add(rqm.fetch_classroom(x));
            }

            Node root = (Node) event.getSource();
            Stage myStage = (Stage) root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ClassScene.fxml"));

            Scene studentscene = new Scene(fxmlLoader.load());
            ClassScene clasctrl = fxmlLoader.getController();

            clasctrl.setStudentDTO(studentDTO);
            clasctrl.setAll_classrooms(all_classrooms);
            clasctrl.setNm(studentDTO.getName());
            clasctrl.setStudentid(studentDTO.getStudid().intValue());
            clasctrl.initialize();

            myStage.setScene(studentscene);
            myStage.show();

        }



    }
}
