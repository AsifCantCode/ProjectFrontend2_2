package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.FileDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;


public class FileView {

    private FileDTO fdto;

    @FXML
    private Label filename;

    public Label getFilename() {
        return filename;
    }

    public void setFilename(Label filename) {
        this.filename = filename;
    }

    @FXML
    public void openLink() throws IOException {
        Desktop.getDesktop().browse(URI.create("http://localhost:8080/file/files/" + fdto.getId()));
    }

    public FileDTO getFdto() {
        return fdto;
    }

    public void setFdto(FileDTO fdto) {
        this.fdto = fdto;
    }
}
