package com.example.projectfrontend2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class tilecontrol {
    public Label getPoster() {
        poster.setMinWidth(0);
        poster.setMaxWidth(Double.MAX_VALUE);
        return poster;
    }

    public void setPoster(Label poster) {
        this.poster = poster;
    }

    public Label getDate() {
        return date;
    }

    public void setDate(Label date) {
        this.date = date;
    }

    public Label getPost() {
        return post;
    }

    public void setPost(Label post) {
        this.post = post;

    }

    @FXML
    Label poster;

    @FXML
    Label date;

    @FXML
    Label post;

    @FXML
    Button deets;

    public void goToPost(ActionEvent event) throws IOException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("postcontrol.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load());
        myStage.setScene(subtractionScene);
        myStage.show();
    }

}
