package pl.edu.wszib.springtalkingwithworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    //ArrayList list = new ArrayList();
    @Autowired
    ArrayList list;

    @GetMapping("/istnieje/{imie}/{nazwisko}")
    public ResponseEntity istnieje(@PathVariable String imie, @PathVariable String nazwisko){
        String name = imie + " " + nazwisko;
        if(list.contains(name)) {
            return new ResponseEntity(name, HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        //if(list.contains(name) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    @PostMapping("/zapisz/{imie}/{nazwisko}")
    public ResponseEntity zapisz(@PathVariable String imie, @PathVariable String nazwisko){
        String name = imie + " " + nazwisko;
        if(list.contains(name)) {
            return new ResponseEntity(name, HttpStatus.NO_CONTENT);
        }else {
            list.add(name);
            return new ResponseEntity(name, HttpStatus.OK);
        }

    }
}
