package pl.edu.wszib.springtalkingwithworld.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.activation.MimeType;

@Controller
@RequestMapping("/moj")
public class MyController {

    //localhost/moj
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity get(){
        ResponseEntity entity = new ResponseEntity("HelloWorld!",HttpStatus.OK);
        return entity;
    }

    //localhost/moj/json
    //@RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    @GetMapping(value = "/json", produces = "application/json")
    public ResponseEntity getJson(){
        String json = "{\n" +
                "  \"imie\": \"Dorota\",\n" +
                "  \"szkola\": {\n" +
                "    \"nazwa\" : \"WSZIB\",\n" +
                "    \"adres\" : \"Kijowska 11\"\n" +
                "  },\n" +
                "  \"oceny\": [5,5,5]\n" +
                "}";
        ResponseEntity entity = new ResponseEntity(json, HttpStatus.OK);
        return entity;
    }
}
