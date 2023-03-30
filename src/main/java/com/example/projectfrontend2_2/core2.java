package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.Classroom.CreateAssignment;
import com.example.projectfrontend2_2.Classroom.TeacherScene2;
import com.example.projectfrontend2_2.Student.StudentDTO;
import com.example.projectfrontend2_2.courseReg.CourseRegistration;
import com.example.projectfrontend2_2.http.RequestMaker;
import com.example.projectfrontend2_2.post.PostDTO;
import com.example.projectfrontend2_2.teacher.TeacherDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;
import java.util.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class core2 {
    @FXML
    private ScrollPane scroll;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button assign;

    @FXML
    private Button back;

    @FXML
    private Button attendance;


    private TeacherDTO tdto;
    private ClassroomDTO cdto;
    private RequestMaker rqm  = new RequestMaker();
    public ClassroomDTO getCdto() {
        return cdto;
    }

    public void setCdto(ClassroomDTO cdto) {
        this.cdto = cdto;
    }

    public TeacherDTO getSdto() {
        return tdto;
    }

    public void setSdto(TeacherDTO tdto) {
        this.tdto = tdto;
    }

    public  void init() throws IOException, InterruptedException {

        VBox vb = new VBox();
        vb.setSpacing(15);
        //vb.setPadding(new Insets(2,0,2,0));
        List<Long> classlist = new ArrayList<>();
        classlist.addAll(cdto.getPosts());
        Collections.sort(classlist , (a , b)->{
            return Math.toIntExact(b - a);
        });
        for(Long id : classlist){
            FXMLLoader fxl = new FXMLLoader(HelloApplication.class.getResource("tile.fxml"));
            Node e = fxl.load();
            tilecontrol tc = fxl.getController();
            PostDTO p = rqm.fetch_post(id);
            tc.getDate().setText(p.getTime().toString());
            tc.getPoster().setText(p.getPosted_by());
            tc.getPost().setText(p.getText());
            vb.getChildren().add(e);
            VBox.setVgrow(e, Priority.ALWAYS);
        }
        scroll.setContent(vb);
    }


    @FXML
    public void init_assignments(){

    }


    @FXML
    public void create_post() throws IOException, InterruptedException {
        Date date = new Date();

        Timestamp ts = new Timestamp(date.getTime());

        if(tdto == null) return;
        PostDTO pdto = new PostDTO(Long.parseLong("0") ,txtArea.getText() , ts ,tdto.getName() , "sad" , cdto.getId());

        rqm.create_post(pdto);
        cdto = rqm.fetch_classroom(cdto.getId());
        init();
    }

    @FXML
    public void createAssignment(ActionEvent event) throws IOException, InterruptedException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateAssignment.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        CreateAssignment obj = fxmlLoader.getController();

        obj.setCdto(cdto);
        obj.setTdto(tdto);

        myStage.setScene(subtractionScene);
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

    @FXML
    public void GoBack(ActionEvent event) throws IOException, InterruptedException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TeacherScene2.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        TeacherScene2 obj = fxmlLoader.getController();

        myStage.setScene(subtractionScene);
        myStage.show();
    }

    @FXML
    public void GoToAttendance(ActionEvent event) throws IOException, InterruptedException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Attendance.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        Attendance obj = fxmlLoader.getController();

        myStage.setScene(subtractionScene);
        myStage.show();
    }


}
