package pl.niewadzj.LOTRecruitment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.niewadzj.LOTRecruitment.exceptions.BadRequestException;
import pl.niewadzj.LOTRecruitment.exceptions.NotFoundException;

@ControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    public final ResponseEntity<String> badRequestHandler(NotFoundException exception) {
        String message = exception.getMessage();

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
