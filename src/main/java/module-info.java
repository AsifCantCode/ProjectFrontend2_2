module com.example.projectfrontend2_2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.projectfrontend2_2 to javafx.fxml;
    exports com.example.projectfrontend2_2;
}