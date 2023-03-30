package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.Student.StudentDTO;
import com.example.projectfrontend2_2.courseReg.CourseRegistration;
import com.example.projectfrontend2_2.http.RequestMaker;
import com.example.projectfrontend2_2.post.PostDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;
import java.util.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class core {
    @FXML
    private ScrollPane scroll;

    @FXML
    private TextArea txtArea;

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    @FXML
    private Label title;
    @FXML
    private Label name;
    @FXML
    private Label id;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    @FXML
    private int studentid;
    private String nm;


    private StudentDTO sdto;
    private ClassroomDTO cdto;
    private RequestMaker rqm  = new RequestMaker();
    public ClassroomDTO getCdto() {
        return cdto;
    }

    public void setCdto(ClassroomDTO cdto) {
        this.cdto = cdto;
    }

    public StudentDTO getSdto() {
        return sdto;
    }

    public void setSdto(StudentDTO sdto) {
        this.sdto = sdto;
    }

    public void initialize(){
        id.setText(" " + (studentid));
        name.setText(nm);
    }

    @FXML
    private void handleMouseEntered(MouseEvent event) {
        Node node = (Node) event.getSource();
        node.getStyleClass().add("tile-hover");
    }

    @FXML
    private void handleMouseExited(MouseEvent event) {
        Node node = (Node) event.getSource();
        node.getStyleClass().remove("tile-hover");
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
            e.addEventHandler(MouseEvent.MOUSE_ENTERED, this::handleMouseEntered);
            e.addEventHandler(MouseEvent.MOUSE_EXITED, this::handleMouseExited);
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
    public void create_post() throws IOException, InterruptedException {
        Date date = new Date();

        Timestamp ts = new Timestamp(date.getTime());
        PostDTO pdto = new PostDTO(Long.parseLong("0") ,txtArea.getText() , ts ,sdto.getName() , "sad" , cdto.getId());

        rqm.create_post(pdto);
        cdto = rqm.fetch_classroom(cdto.getId());
        init();
    }

    public void goToSubmitAss(ActionEvent event) throws IOException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AssSubmit.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        myStage.setScene(subtractionScene);
        myStage.show();
    }




    //FXMLLoader fxm = new FXMLLoader(HelloApplication.class.getResource("assignment_tile.fxml"));

    public  void init2() throws IOException, InterruptedException {

        VBox vb = new VBox();
        vb.setSpacing(15);
            FXMLLoader fxl = new FXMLLoader(HelloApplication.class.getResource("assignment_tile.fxml"));

            Node e = fxl.load();
        System.out.println("jo");
            assignment_tile_control astc = fxl.getController();
            //PostDTO p = rqm.fetch_post(id);

        astc.getDate().setText("20 Jan 2002");
        astc.getTeacher().setText("Samnun Azfar");
        astc.getAssignment_title().setText("Balsal");
            vb.getChildren().add(e);
            //VBox.setVgrow(e, Priority.ALWAYS);
        scroll.setContent(vb);
    }


    public void onAssignmentClick() throws IOException, InterruptedException {
        init2();
    }
    public void onPostClick() throws IOException, InterruptedException {
        init();
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
