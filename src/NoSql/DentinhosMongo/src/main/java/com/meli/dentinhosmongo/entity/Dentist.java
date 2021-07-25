package com.meli.dentinhosmongo.entity;

import com.meli.dentinhosmongo.dto.DentistScheduleDTO;
import com.meli.dentinhosmongo.dto.UserDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "users")
public class Dentist extends User {

    private String codeMp;

    List<Schedule> diaries;

    public Dentist() {
    }

    public Dentist(String codeMp, List<Schedule> diaries) {
        this.codeMp = codeMp;
        this.diaries = diaries;
    }

    public Dentist(String password, boolean userStatus, String name, String lastName, String dni, LocalDate birthDate, String phone, String email, Address address, String codeMp, List<Schedule> diaries) {
        super(password, userStatus, name, lastName, dni, birthDate, phone, email, address);
        this.codeMp = codeMp;
        this.diaries = diaries;
    }

    public static Dentist castToDentist(UserDTO userDTO) {
        return new Dentist(userDTO.getPassword(), userDTO.getUserStatus(), userDTO.getName(), userDTO.getLastName(), userDTO.getDni(), userDTO.getBirthDate(), userDTO.getPhone(), userDTO.getEmail(), userDTO.getAddress(), userDTO.getCodeMp(), userDTO.getSchedules());
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String codeMp) {
        this.codeMp = codeMp;
    }

    public List<Schedule> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<Schedule> diaries) {
        this.diaries = diaries;
    }

    public DentistScheduleDTO castToDentistScheduleDTO() {
        return new DentistScheduleDTO(this.getName(), this.getLastName(), this.getCodeMp());
    }
}
