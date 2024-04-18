package pl.niewadzj.LOTRecruitment.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.niewadzj.LOTRecruitment.exceptions.NotFoundException;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public final ResponseEntity<String> notFoundHandler(NotFoundException exception) {
        String message = exception.getMessage();

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

}
