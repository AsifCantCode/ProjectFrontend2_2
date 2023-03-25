package com.example.projectfrontend2_2.Classroom;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import com.example.projectfrontend2_2.HelloApplication;
import com.example.projectfrontend2_2.http.RequestMaker;
import com.example.projectfrontend2_2.post.PostDTO;
import com.example.projectfrontend2_2.tilecontrol;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TeacherCore {

    @FXML
    private ScrollPane scroll;

    public ClassroomDTO getCdto() {
        return cdto;
    }

    public void setCdto(ClassroomDTO cdto) {
        this.cdto = cdto;
    }

    private ClassroomDTO cdto;


    public  void init() throws IOException, InterruptedException {
        RequestMaker rqm  = new RequestMaker();
        VBox vb = new VBox();
        vb.setSpacing(7);
        //vb.setPadding(new Insets(2,0,2,0));
        for(Long id : cdto.getPosts()){
            FXMLLoader fxl = new FXMLLoader(HelloApplication.class.getResource("tile.fxml"));
            Node e = fxl.load();
            tilecontrol tc = fxl.getController();
            PostDTO p = rqm.fetch_post(id);
            tc.getDate().setText(p.getTime().toString());
            tc.getPoster().setText(p.getPosted_by());
            vb.getChildren().add(e);
        }
        scroll.setContent(vb);
    }


}
