package com.example.projectfrontend2_2.Login;

import com.example.projectfrontend2_2.Classroom.ClassScene;
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

public class TeacherLogin {
    @FXML
    private TextField teacherID;

    @FXML
    private TextField passWord;

    @FXML
    protected void goToTeacherScene(ActionEvent event) throws IOException, InterruptedException{


        int inp_ID = Integer.parseInt(teacherID.getText());
        String inp_pass = passWord.getText();


//        LoginDTO ldto = new LoginDTO();
//        Gson gson = new Gson();
//        ldto.setStudentid(Long.parseLong(studentID.getText()));
//        ldto.setPassword(passWord.getText());
//
//        System.out.println("here");
//        String jackson = gson.toJson(ldto );
//        System.out.println( jackson +" weifhwe weofhwoe woefw");
//        RequestMaker rqm = new RequestMaker();
//
//        StudentDTO stdo = rqm.login_attempt(ldto , "/login/student");
//        System.out.println(stdo.getStudid());


        //----------------------------------------------------------------------------------------------------------------
        //Ekhane dummy login banaitesi

        if(inp_ID == 200041106 && inp_pass.equals("asif106"))
        {
//            studentDTO = stdo;
//
//            List<Long> classroom_id = studentDTO.getClassroom_id();
//
//            System.out.println(classroom_id.size());
//            for(Long x : classroom_id){
//                System.out.println(x);
//            }
//            all_classrooms = new ArrayList<>();
//            for(Long x : classroom_id){
//                all_classrooms.add(rqm.fetch_classroom(x.intValue()));
//            }

            Node root = (Node) event.getSource();
            Stage myStage = (Stage) root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TeacherScene.fxml"));

            Scene studentscene = new Scene(fxmlLoader.load());
            ClassScene clasctrl = fxmlLoader.getController();

//            clasctrl.setAll_classrooms(all_classrooms);
//            clasctrl.setNm(studentDTO.getName());
//            clasctrl.setStudentid(studentDTO.getStudid().intValue());
//            clasctrl.initialize();

            myStage.setScene(studentscene);
            myStage.show();

        }



    }
}
