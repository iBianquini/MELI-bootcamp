package com.meli.aula4linktracker.exception.handler;

import com.meli.aula4linktracker.dto.ExceptionDTO;
import com.meli.aula4linktracker.exception.RecursoNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RecursoNaoEncontradoExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(RecursoNaoEncontradoException e){
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }
}
