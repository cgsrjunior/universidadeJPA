package com.example.demo2.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstudanteNaoEncontradoException extends RuntimeException{
    public EstudanteNaoEncontradoException(){
        super();
    }

    public EstudanteNaoEncontradoException(String message) {
        super(message);
    }
}
