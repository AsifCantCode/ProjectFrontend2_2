package com.example.projectfrontend2_2;

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

    @FXML
    private Button back;

    public  void initialize() throws IOException, InterruptedException {

        VBox vb = new VBox();
        vb.setSpacing(10);
        //vb.setPadding(new Insets(2,0,2,0));
        List<String> classlist = new ArrayList<>();
        classlist.add("200041106");
        classlist.add("200041108");
        HBox hb = new HBox();
        //classlist.addAll(cdto.getPosts());
//        Collections.sort(classlist , (a , b)->{
//            return Math.toIntExact(b - a);
//        });
        for(String id : classlist){
            FXMLLoader fxl = new FXMLLoader(HelloApplication.class.getResource("attendance-tile.fxml"));
            Node e = fxl.load();
            AttendanceTile tc = fxl.getController();
            tc.ID.setText(id);
            vb.getChildren().add(e);
            VBox.setVgrow(hb, Priority.ALWAYS);
        }
        scroll.setContent(vb);
    }
//ll
    public void goBack(ActionEvent event) throws IOException{
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scrolscrene2.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        core2 obj = fxmlLoader.getController();

        myStage.setScene(subtractionScene);
        myStage.show();
    }


}
