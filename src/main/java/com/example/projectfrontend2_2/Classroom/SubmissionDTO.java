package com.example.projectfrontend2_2.Classroom;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SubmissionDTO {
    private Long id;


    private Timestamp submittedOn;

    private String information;

    private float grade;

    private List<Long> addedFiles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Timestamp submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public List<Long> getAddedFiles() {
        return addedFiles;
    }

    public void setAddedFiles(List<Long> addedFiles) {
        this.addedFiles = addedFiles;
    }
}
