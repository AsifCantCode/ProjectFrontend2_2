package com.example.projectfrontend2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentLogin {

    @FXML
    private TextField studentID;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField passWord;

    //function for getting pass and username
    @FXML
    protected void pressedLoginButton(){
        int userID = Integer.parseInt(studentID.getText());
        String pass = passWord.getText();

    }
    @FXML
    protected void goToClass(ActionEvent event) throws IOException {
        Node root = (Node) event.getSource();
        Stage myStage = (Stage) root.getScene().getWindow();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ClassScene.fxml"));
        Scene subtractionScene = new Scene(fxmlLoader.load(), 800, 600);
        myStage.setScene(subtractionScene);
        myStage.show();
    }
}
