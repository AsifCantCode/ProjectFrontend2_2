module com.example.projectfrontend2_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires java.sql;


    exports com.example.projectfrontend2_2;
    opens  com.example.projectfrontend2_2.Student to com.google.gson;
    opens com.example.projectfrontend2_2 to com.google.gson, javafx.fxml;
    exports com.example.projectfrontend2_2.Classroom;
    opens com.example.projectfrontend2_2.Classroom to com.google.gson, javafx.fxml;
    exports com.example.projectfrontend2_2.courseReg;
    opens com.example.projectfrontend2_2.courseReg to com.google.gson, javafx.fxml;
    opens com.example.projectfrontend2_2.post to com.google.gson, javafx.fxml;
    exports com.example.projectfrontend2_2.Login;
    opens com.example.projectfrontend2_2.Login to com.google.gson, javafx.fxml;
}