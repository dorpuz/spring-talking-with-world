package pl.edu.wszib.springtalkingwithworld.Lab3;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/headers")
public class HeaderController {

   /* @GetMapping
    public ResponseEntity test(@RequestHeader String testHeader){
        return ResponseEntity.ok(testHeader.toUpperCase());
    }*/

   /* @GetMapping
    @ResponseBody
    public String test(@RequestHeader String testHeader){
        return testHeader.toUpperCase();
    }*/
  /* @GetMapping("/headers/{}")
   public String test(@RequestHeader String testHeader){
       return testHeader.toUpperCase();
   }*/
  @GetMapping
    public String test() {
      return "homey";
  }


}
