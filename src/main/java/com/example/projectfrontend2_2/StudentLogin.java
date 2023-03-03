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

    private String pass = "iutcse";
    private int userID = 1234;

    @FXML
    private TextField studentID;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField passWord;

    //function for getting pass and username
    @FXML
    protected void pressedLoginButton(){


    }
    @FXML
    protected void goToClass(ActionEvent event) throws IOException {
        int inp_ID = Integer.parseInt(studentID.getText());
        String inp_pass = passWord.getText();
        if(inp_pass.equals(pass) && inp_ID == userID)
        {
            Node root = (Node) event.getSource();
            Stage myStage = (Stage) root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ClassScene.fxml"));
            Scene studentscene = new Scene(fxmlLoader.load(), 800, 600);
            myStage.setScene(studentscene);
            myStage.show();
        }
    }
}
