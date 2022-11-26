package com.app.policy.exception;

import com.app.policy.common.Constants;
import com.app.policy.common.StatusDescription;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Log4j2
public class AdviceHandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.FAILED.toString())
                .body(e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFound(Exception e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.FAILED.toString())
                .body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity validationExc(MethodArgumentNotValidException e) {
        log.info("validate error " + e.getMessage());
        BindingResult result = e.getBindingResult();

        final List<FieldError> fieldErrors = result.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.FAILED.toString())
                .body(e.getDetailMessageArguments());

    }

}
