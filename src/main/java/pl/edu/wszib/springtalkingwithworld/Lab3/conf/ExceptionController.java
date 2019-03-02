package pl.edu.wszib.springtalkingwithworld.Lab3.conf;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.Random;

@Controller
@RequestMapping("/simpsons")
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    static class FirstException extends RuntimeException{}
    @ResponseStatus(HttpStatus.OK)
    static class SecException extends RuntimeException{}
    @ResponseStatus(HttpStatus.NOT_FOUND)
    static class ThirdException extends RuntimeException{}

    @GetMapping
    public String test(){
        int rzut = new Random().nextInt(3);

        if(rzut==0) throw new FirstException();
        else if(rzut==1) throw new SecException();
        else throw new ThirdException();
    }

    @ExceptionHandler(FirstException.class)
    public String exception(){
        return "homey";
    }
    @ExceptionHandler(SecException.class)
    public String exception2(){
        return "lisa";
    }
    @ExceptionHandler(ThirdException.class)
    public String exception3(){
        return "bart";
    }
}



