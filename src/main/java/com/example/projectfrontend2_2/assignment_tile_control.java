package com.example.projectfrontend2_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class assignment_tile_control {
    @FXML
    Label teacher;
    @FXML
    Label date;

    public Label getTeacher() {
        return teacher;
    }

    public void setTeacher(Label teacher) {
        this.teacher = teacher;
    }

    public Label getDate() {
        return date;
    }

    public void setDate(Label date) {
        this.date = date;
    }

    public Label getAssignment_title() {
        return assignment_title;
    }

    public void setAssignment_title(Label assignment_title) {
        this.assignment_title = assignment_title;
    }

    @FXML
    Label assignment_title;

    @FXML
    private void onItemPressed() throws IOException{
        Stage myStage = new Stage();
        FXMLLoader fxml = new FXMLLoader(HelloApplication.class.getResource("submit_assignment.fxml"));
        Scene as = new Scene(fxml.load());
        myStage.setScene(as);
        myStage.show();
    }
}