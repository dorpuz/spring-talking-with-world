package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping("/shelter")
public class ShelterController {

  Animals animal = new Animals();
  ArrayList listOfAnimals = new ArrayList();

  @PostMapping
  public ResponseEntity oddaj(@RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("animalSex") AnimalSex animalSex,
                              @RequestParam("animalType") AnimalType animalType){
    animal.name = name;
    animal.age = age;
    animal.animalSex = animalSex;
    animal.animalType = animalType;
    animal.id = String.valueOf(new Random().nextInt());

    listOfAnimals.add(animal);

    return ResponseEntity.ok(animal.id);

  }

//  @GetMapping
//  public ResponseEntity showAll()
//

}
/*
  Kontroler obsługujący nasze schronisko powinien obsługiwać następujace metody:
        POST /oddaj - metoda w której oddajemy zwierze (wysylamy pełne informacje
        odpisujace naszego zwierzaka, pozwoli nam to zbudować jego model i zapisać) 
        do schroniska, dla oddanego zwierzecia powinien zostac wygenerowany identyfikator
        który następnie zostanie zwrócony w ciele odpowiedzi
        GET /wszystkie - metoda która zwraca Listę wszyskich zwierząt oddanych do adopcji
        (dla chętnych proszę aby jedyne informacje które są zwracane na temat zwierzaków
        to id oraz imie)
        GET /zobacz - metoda która przyjmuje id zwierzaka, zwraca nam pełne informacje
        o zwierzęciu, powinna zwracać 404 w momencie kiedy takiego id nie ma w systemie
        DELETE /adoptuj - metoda która przyjmuje id zwierzaka, "adoptuje" naszego zwierzaka
        usuwając go z systemu
        Nie narzucam wam sposobu przesyłania informacji, możecie skorzystać z dowolnej
        metody którą poznaliście na naszych zajęciach (Jeżeli chcecie to mozecie je takze mieszać).
        Proponuję jednak zastanowić się w którym przypadku która metoda będzie najwygodniejsza.*/
