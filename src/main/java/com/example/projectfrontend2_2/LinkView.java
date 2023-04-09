package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.http.RequestMaker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LinkView {
    @FXML
    private Button link_press;

    private String link;

    @FXML
    private ImageView icon;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @FXML
    public void buttonpress() throws IOException {

        Desktop.getDesktop().browse(URI.create(link));
    }

    public void init() throws IOException {

        try{

            Document doc = Jsoup.connect(link).get();
            link_press.setText(doc.title());

            if(link.contains("youtube")){

                Image img = new Image(getClass().getResource("youtube.png").toURI().toString());
                icon.setImage(img);
            }

        }
        catch(Exception h) {
            link = "www.google.com";
            h.printStackTrace();
        }


    }
}
