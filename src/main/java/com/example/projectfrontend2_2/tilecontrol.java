package com.example.projectfrontend2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;

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

    public Text getPost() {
        return post;
    }

    public void setPost(Text post) {
        this.post = post;

    }

    @FXML
    Label poster;

    @FXML
    Label date;

    @FXML
    Text post;

    @FXML
    Button deets;

    @FXML
    private Pane mainPane;

    @FXML
    private VBox vb;

    public void goToPost(ActionEvent event) throws IOException {

    }

    public Pane getMainPane() {
        return mainPane;
    }

    public void setMainPane(Pane mainPane) {
        this.mainPane = mainPane;
    }
}
