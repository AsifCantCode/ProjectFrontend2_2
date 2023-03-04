module com.example.projectfrontend2_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.projectfrontend2_2 to javafx.fxml;
    exports com.example.projectfrontend2_2;
    opens  com.example.projectfrontend2_2.Login to com.google.gson;
    opens  com.example.projectfrontend2_2.Student to com.google.gson;
    opens  com.example.projectfrontend2_2.Classroom to com.google.gson;
}