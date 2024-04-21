package pl.niewadzj.LOTRecruitment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.niewadzj.LOTRecruitment.exceptions.BadRequestException;

@RestControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    public final ResponseEntity<String> badRequestHandler(BadRequestException exception) {
        String message = exception.getMessage();

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
