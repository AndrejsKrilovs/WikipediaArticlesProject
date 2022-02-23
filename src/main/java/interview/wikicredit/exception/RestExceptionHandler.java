package interview.wikicredit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.time.LocalDateTime;

/**
 * Handles exceptions from CompanyRestController endpoint
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleNullException(NullPointerException exception) {
        CompanyExceptionResponse response = new CompanyExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        CompanyExceptionResponse response = new CompanyExceptionResponse(HttpStatus.CONFLICT.value(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleValidationException(ValidationException exception) {
        CompanyExceptionResponse response = new CompanyExceptionResponse(HttpStatus.NOT_MODIFIED.value(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_MODIFIED);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException exception) {
        CompanyExceptionResponse response = new CompanyExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
