package com.meli.aula4linktracker.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException(String message) {
        super(message);
    }

    public RecursoNaoEncontradoException(Exception exception) {
        super(exception);
    }
}
