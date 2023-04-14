package br.com.fiap.abctechapi.handler.exception;

import lombok.Getter;

@Getter
public class MinimumAssistsRequiredException extends RuntimeException {
    
    private String description;

    public MinimumAssistsRequiredException(String message, String description) {
        super(message);
        this.description = description;
    }
}
