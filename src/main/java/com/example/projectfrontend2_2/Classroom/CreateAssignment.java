package com.example.projectfrontend2_2.Classroom;

import com.example.projectfrontend2_2.http.RequestMaker;
import com.example.projectfrontend2_2.teacher.TeacherDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;

public class CreateAssignment {
    @FXML
    private Button files;

    @FXML
    private DatePicker dpkr;

    private ClassroomDTO cdto;
    private TeacherDTO tdto;

    private List<String> filepaths = new ArrayList<>();

    private List<Long> fileID = new ArrayList<>();

    private RequestMaker rqm = new RequestMaker();
    @FXML
    private ListView listview;

    public void ButtonAction(ActionEvent event) throws URISyntaxException, IOException, InterruptedException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files",  "*.pdf")
        );
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if(selectedFiles != null){
            for(int i = 0; i < selectedFiles.size(); ++i){
                listview.getItems().add(selectedFiles.get(i).getName());
                filepaths.add(selectedFiles.get(i).getAbsolutePath());
                fileID.add(rqm.upload_file(selectedFiles.get(i).getAbsolutePath()));
            }

        }else{
            System.out.println("File Not Valid!");
        }
    }

    public void uploadClick(){

        AssignmentDTO adto = new AssignmentDTO();
        adto.setClassroomid(cdto.getId());

        Timestamp ts = new Timestamp(dpkr.getValue().toEpochDay() );
        System.out.println(ts.toString());


    }

    public ClassroomDTO getCdto() {
        return cdto;
    }

    public void setCdto(ClassroomDTO cdto) {
        this.cdto = cdto;
    }

    public TeacherDTO getTdto() {
        return tdto;
    }

    public void setTdto(TeacherDTO tdto) {
        this.tdto = tdto;
    }
}
