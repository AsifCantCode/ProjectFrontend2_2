package com.example.projectfrontend2_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class tilecontrol {
    public Label getPoster() {
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

    @FXML
    Label poster;
    @FXML
    Label date;

}
