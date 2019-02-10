package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/patameterTest")
public class RequestParamController {

   /* @GetMapping
    public ResponseEntity get(@RequestParam("[pierwsza")int liczba1,
                              @RequestParam("druga") int liczba2,
                              @RequestParam(value = "trzecia", required = false) Integer trzecia)
    //jezeli cos nie jest wymagane, to moze byc puste, stad obsluga poprzez Integer

    {
        return ResponseEntity.ok(liczba1+liczba2);
    }*/

    @GetMapping("/sum")
    public ResponseEntity get_added(@RequestParam("liczby") int[] liczby) {
        return ResponseEntity.ok(Arrays.stream(liczby).sum());
    }

    @GetMapping("/average")
    public ResponseEntity get_averaged(@RequestParam("liczby") int[] liczby) {
        return ResponseEntity.ok(Arrays.stream(liczby).average());
    }

    @GetMapping("/multiplication")
    public ResponseEntity get_mulitplied(@RequestParam("liczby") int[] liczby) {
        int product = 1;
        for (int i = 0; i < liczby.length; i++) {
            product *= liczby[i];
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/difference")
    public ResponseEntity get_subtracted(@RequestParam("liczby") int[] liczby) {
        int minuend = liczby[0];
        for (int i = 1; i < liczby.length; i++) {
            minuend -= liczby[i];
        }
        return ResponseEntity.ok(minuend);

    }

   /* @GetMapping("/division")
    public ResponseEntity get_divided(@RequestParam("liczby") int[] liczby) {
        int div = liczby[0];
        for (int i = 1; i < liczby.length; i++) {
            if (liczby[i] != 0) {
                div /= liczby[i];
                return ResponseEntity.ok(div);
            }
            else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

        }

    }*/
}