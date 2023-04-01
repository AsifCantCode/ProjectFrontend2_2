package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.Student.StudentDTO;
import com.example.projectfrontend2_2.http.RequestMaker;
import com.example.projectfrontend2_2.post.PostDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Attendance {
    @FXML
    private ScrollPane scroll;

    private ClassroomDTO cdto;


    @FXML
    private Button back;

    private RequestMaker rqm = new RequestMaker();
    public  void init() throws IOException, InterruptedException {

        VBox vb = new VBox();
        vb.setSpacing(10);
        //vb.setPadding(new Insets(2,0,2,0));
        List<Long> classlist = new ArrayList<>();
        classlist.addAll(cdto.getStudents());

        HBox hb = new HBox();
        //classlist.addAll(cdto.getPosts());

        for(Long id : classlist){
            FXMLLoader fxl = new FXMLLoader(HelloApplication.class.getResource("attendance-tile.fxml"));
            Node e = fxl.load();
            AttendanceTile tc = fxl.getController();
            tc.setSdto(rqm.fetch_student(id));
            tc.init();
            e.setUserData(tc.getSdto());
            vb.getChildren().add(e);
            VBox.setVgrow(hb, Priority.ALWAYS);
        }
        Collections.sort(vb.getChildren() , (a , b)->{
            StudentDTO ab = (StudentDTO) a.getUserData();
            StudentDTO bb = (StudentDTO) b.getUserData();

            return Math.toIntExact(ab.getStudid() - bb.getStudid());
        });

        scroll.setContent(vb);
    }
//ll
    public void goBack(ActionEvent event) throws IOException{
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        myStage.show();
        myStage.close();
    }

    public ClassroomDTO getCdto() {
        return cdto;
    }

    public void setCdto(ClassroomDTO cdto) {
        this.cdto = cdto;
    }
}
