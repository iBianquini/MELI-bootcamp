package com.meli.dentinhosmongo.entity;

import com.meli.dentinhosmongo.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String password;

    private boolean userStatus;

    private String name;

    private String lastName;

    private String dni;

    private LocalDate birthDate;

    private String phone;

    private String email;

    private Address address;

    public User() {
    }

    public User(String password, boolean userStatus, String name, String lastName, String dni, LocalDate birthDate, String phone, String email, Address address) {
        this.password = password;
        this.userStatus = userStatus;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public static User castToPatient(UserDTO userDTO) {
        return new User(userDTO.getPassword(), userDTO.getUserStatus(), userDTO.getName(), userDTO.getLastName(), userDTO.getDni(), userDTO.getBirthDate(), userDTO.getPhone(), userDTO.getEmail(), userDTO.getAddress());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
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
}
