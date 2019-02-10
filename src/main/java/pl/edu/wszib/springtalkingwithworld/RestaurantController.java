package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Null;

// /restautacja/koszt?imie=adam&imie_ps_tow=genowefa&imie_zw, dziecka | wymagane tylko imie

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    Client client = new Client();

    @GetMapping()
    public ResponseEntity koszt(@RequestParam("name") String name,
                                @RequestParam(value = "accompany", required = false) String accompany,
                                @RequestParam(value = "animal", required = false) String animal,
                                @RequestParam(value = "kid", required = false) String kid)

    {
        if(accompany!=null){
            client.accompany = true;
        }
        if(animal!=null){
            client.animal = true;
        }
        if(kid!=null){
            client.kid = true;
        }

        return ResponseEntity.ok(Restaurant.koszt(client));
    }
}
