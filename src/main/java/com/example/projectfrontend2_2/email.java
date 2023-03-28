package com.example.projectfrontend2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;


public class email {

    @FXML
    private TextField frame;
    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtmsg;
    @FXML
    private Button j;
    @FXML
    private  TextField txtsub;

    public void sendMail(ActionEvent event) throws IOException, InterruptedException{
        System.out.println(txtEmail.getText());
            String to = "asif141100@gmail.com";
            String from = "asifabrar@iut-dhaka.edi";
            String host = "localhost";
            String port = "25";

            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.store.protocol", "pop3");
            props.put("mail.transport.protocol", "smtp");
            final String username = "asifabrar@iut-dhaka.edu";//
            final String password = "";
            try{
                Session session = Session.getInstance(props,
                        new Authenticator(){
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }});

                Message msg = new MimeMessage(session);


                msg.setFrom(new InternetAddress(txtEmail.getText()));
                msg.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(txtEmail.getText(),false));
                msg.setSubject(txtsub.getText());
                msg.setText(txtmsg.getText());





                msg.setSentDate(new Date());
                Transport.send(msg);
                JOptionPane.showMessageDialog(null, "Sent");
            }catch (MessagingException e){ System.out.println("Erreur d'envoi, cause: " + e);}
    }
    private static String getExceptionMessage(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
