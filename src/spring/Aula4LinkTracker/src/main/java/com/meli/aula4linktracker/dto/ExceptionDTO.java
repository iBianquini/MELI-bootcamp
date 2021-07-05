package com.meli.aula4linktracker.dto;

public class ExceptionDTO {
    private String message;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public ExceptionDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
