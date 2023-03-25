package com.example.projectfrontend2_2.Login;

import com.example.projectfrontend2_2.Classroom.TeacherScene;
import com.example.projectfrontend2_2.HelloApplication;
import com.example.projectfrontend2_2.http.RequestMaker;
import com.example.projectfrontend2_2.teacher.TeacherDTO;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherLogin {
    @FXML
    private TextField teacherID;

    @FXML
    private TextField passWord;

    private TeacherDTO tdto;
    @FXML
    protected void goToTeacherScene(ActionEvent event) throws IOException, InterruptedException{





        LoginDTO ldto = new LoginDTO();
        Gson gson = new Gson();
        ldto.setCommon_id(Long.parseLong(teacherID.getText()));
        ldto.setPassword(passWord.getText());


        String jackson = gson.toJson(ldto );
        System.out.println( jackson +" weifhwe weofhwoe woefw");
        RequestMaker rqm = new RequestMaker();

        tdto = rqm.login_attempt_teacher(ldto , "/login/teacher");

        if(tdto.getTeachid().equals(ldto.getCommon_id()) && tdto.getPassword().equals(ldto.getPassword()))
        {


            Node root = (Node) event.getSource();
            Stage myStage = (Stage) root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TeacherScene.fxml"));

            Scene studentscene = new Scene(fxmlLoader.load());
            TeacherScene clasctrl = fxmlLoader.getController(); // next scene still not processed
            clasctrl.setTdto(tdto);

            clasctrl.init();

            myStage.setScene(studentscene);
            myStage.show();

        }



    }
}
