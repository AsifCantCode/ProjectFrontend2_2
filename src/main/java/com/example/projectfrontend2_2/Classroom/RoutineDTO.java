package com.example.projectfrontend2_2.Classroom;

public class RoutineDTO {

    private Long id;

    private Long fileId;

    public RoutineDTO(Long id, Long fileId) {
        this.id = id;
        this.fileId = fileId;
    }
    public RoutineDTO() {
        this.id = (long)0;
        this.fileId = (long)0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
