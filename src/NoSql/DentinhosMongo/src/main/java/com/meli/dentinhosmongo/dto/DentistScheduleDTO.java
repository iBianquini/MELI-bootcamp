package com.meli.dentinhosmongo.dto;

public class DentistScheduleDTO {

    private String firstName;
    private String lastName;
    private String codeMp;

    public DentistScheduleDTO(String firstName, String lastName, String codeMp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeMp = codeMp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String codeMp) {
        this.codeMp = codeMp;
    }
}
