package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.RoutineDTO;
import com.example.projectfrontend2_2.http.RequestMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.RoundingMode;

public class Routine {

    @FXML
    private Button goBack;
    @FXML
    private ImageView routine;

    private RoutineDTO rdto;

    public RoutineDTO getRdto() {
        return rdto;
    }

    public void setRdto(RoutineDTO rdto) {
        this.rdto = rdto;
    }

    public void init(){
        Image image = new Image("http://"+ RequestMaker.host_addr +":8080/file/files/" + rdto.getFileId());
        routine.setImage(image);
    }
}
