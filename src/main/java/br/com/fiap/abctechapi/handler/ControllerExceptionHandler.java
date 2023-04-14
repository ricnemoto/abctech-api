package br.com.fiap.abctechapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistsRequiredException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MinimumAssistsRequiredException.class)
    public ResponseEntity<ErrorMessageResponse> errorMinAssistRequired(MinimumAssistsRequiredException minimumAssistsRequiredException) {
        ErrorMessageResponse error = new ErrorMessageResponse(minimumAssistsRequiredException.getMessage(), 
            minimumAssistsRequiredException.getDescription(), 
            HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

   
    @ExceptionHandler(MaximumAssistException.class)
    public ResponseEntity<ErrorMessageResponse> errorMaxAssistsRequired(MaximumAssistException exception) {
        ErrorMessageResponse error = new ErrorMessageResponse(exception.getMessage(), 
            exception.getDescription(), 
            HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
