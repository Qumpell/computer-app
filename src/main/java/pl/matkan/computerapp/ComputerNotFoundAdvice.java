package pl.matkan.computerapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ComputerNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ComputerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String computerNotFoundHandler(ComputerNotFoundException ex){
        return ex.getMessage();
    }
}
