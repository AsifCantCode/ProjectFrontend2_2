package com.example.projectfrontend2_2;

import javafx.fxml.FXML;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;


public class FileView {
    @FXML
    public void openLink() throws IOException {
        Desktop.getDesktop().browse(URI.create("www.facebook.com"));
    }
}
