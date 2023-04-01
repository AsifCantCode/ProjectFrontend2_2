package com.example.projectfrontend2_2.Classroom;

import com.example.projectfrontend2_2.Student.StudentDTO;
import com.example.projectfrontend2_2.http.RequestMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SubmitAss {
    @FXML
    private Button files;

    @FXML
    private Button upload;


    private StudentDTO sdto;
    private AssignmentDTO adto;


    public StudentDTO getSdto() {
        return sdto;
    }

    public void setSdto(StudentDTO sdto) {
        this.sdto = sdto;
    }

    public AssignmentDTO getAdto() {
        return adto;
    }

    public void setAdto(AssignmentDTO adto) {
        this.adto = adto;
    }

    @FXML
    private ListView listview;
    private List<Long> neededFiles = new ArrayList<>();

    private RequestMaker rqm = new RequestMaker();
    @FXML
    private TextField comments;

    @FXML
    private TextField course_name;

    @FXML
    private TextField ass_title;

    public void ButtonAction(ActionEvent event) throws URISyntaxException, IOException, InterruptedException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files",  "*.pdf")
        );
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if(selectedFiles != null){
            for(int i = 0; i < selectedFiles.size(); ++i){
                listview.getItems().add(selectedFiles.get(i).getName());
                neededFiles.add(rqm.upload_file(selectedFiles.get(i).getAbsolutePath()));


            }

        }else{
            System.out.println("File Not Valid!");
        }
    }


    @FXML
    public void upload_ass() throws IOException, InterruptedException {
        SubmissionDTO subdto = rqm.fetch_submission_info(sdto.getStudid().toString() + adto.getId().toString());
        if(subdto == null){
            subdto = new SubmissionDTO();
        }
        subdto.setId(sdto.getStudid().toString() + adto.getId() );
        subdto.setGrade(-1);
        subdto.getAddedFiles().addAll(neededFiles);
        subdto.setInformation(comments.getText());
        subdto.setSubmittedBy(sdto.getName());
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        subdto.setSubmittedOn(ts);
        subdto.setAssignmentId(adto.getId());
        rqm.create_submit(subdto);

    }
}
