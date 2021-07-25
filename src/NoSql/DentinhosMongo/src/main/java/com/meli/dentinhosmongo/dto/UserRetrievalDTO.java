package com.meli.dentinhosmongo.dto;

import com.meli.dentinhosmongo.entity.Address;

import java.time.LocalDate;

public class UserRetrievalDTO {

    private String name;

    private String lastName;

    private boolean userStatus;

    private String dni;

    private LocalDate birthDate;

    private String phone;

    private String email;

    private Address address;

    private String codeMp;

    public UserRetrievalDTO(String name, String lastName, boolean userStatus, String dni, LocalDate birthDate, String phone, String email, Address address, String codeMp) {
        this.name = name;
        this.lastName = lastName;
        this.userStatus = userStatus;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.codeMp = codeMp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCodeMp() {
        return codeMp;
    }

    public void setCodeMp(String codeMp) {
        this.codeMp = codeMp;
    }
}
