package com.example.projectfrontend2_2;

import com.example.projectfrontend2_2.Classroom.ClassroomDTO;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;

public class core {

    @FXML
    private ScrollPane scroll;

    public ClassroomDTO getCdto() {
        return cdto;
    }

    public void setCdto(ClassroomDTO cdto) {
        this.cdto = cdto;
    }

    private ClassroomDTO cdto;


}
