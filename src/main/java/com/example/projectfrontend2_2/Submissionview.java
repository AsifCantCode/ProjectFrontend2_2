package com.example.projectfrontend2_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Submissionview {
    @FXML
    private Label name;

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }
}
