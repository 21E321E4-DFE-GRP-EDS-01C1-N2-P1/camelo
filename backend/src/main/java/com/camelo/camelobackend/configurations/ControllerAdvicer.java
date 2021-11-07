package com.camelo.camelobackend.configurations;

import com.camelo.camelobackend.transportlayers.openapi.model.Error;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerAdvicer {

    @ResponseBody
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error dealNotLocalizedException(NoSuchElementException e) {
        var response = new Error();
        response.setMensagem(e.getMessage());
        return response;
    }

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error dataIntegrityViolationException(DataIntegrityViolationException e) {
        var response = new Error();
        response.setMensagem(e.getMessage());
        return response;
    }
}
