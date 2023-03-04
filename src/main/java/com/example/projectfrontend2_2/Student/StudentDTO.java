package com.example.projectfrontend2_2.Student;

import java.util.ArrayList;

public class StudentDTO  {

    private  Long studid;
    private float cgpa;

    private String name;
    private ArrayList<Long> classroom_id = new ArrayList<>();

    public Long getStudid() {
        return studid;
    }

    public void setStudid(Long studid) {
        this.studid = studid;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Long> getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(ArrayList<Long> classroom_id) {
        this.classroom_id = classroom_id;
    }
}
