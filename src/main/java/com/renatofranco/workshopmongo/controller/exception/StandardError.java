package com.renatofranco.workshopmongo.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;

    public StandardError(){
    }

    public StandardError(String message) {
        this.message = message;
    }

    public String getMensagem() {
        return message;
    }

    public void setMensagem(String message) {
        this.message = message;
    }


}
