package pl.edu.wszib.springtalkingwithworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/shelter")
public class ShelterController {

  @Autowired
  List<Animals> listOfAnimals;


  @PostMapping("/shelter/oddaj")
  public ResponseEntity leaveAnimal(@RequestParam("name") String name,
                              @RequestParam("age") int age,
                              @RequestParam("animalSex") AnimalSex animalSex,
                              @RequestParam("animalType") AnimalType animalType) {

    Animals animal = new Animals(name, age, animalType, animalSex);
    animal.id = String.valueOf(new Random().nextInt());

    listOfAnimals.add(animal);

    return ResponseEntity.ok(animal.id);

  }

  @GetMapping("/shelter/pokaz")
  public ResponseEntity showAllAnimals() {

    String nazwa = "";

    if (listOfAnimals.isEmpty())
      return new ResponseEntity("Wszystkie zwierzątka znalazły swój dom", HttpStatus.NO_CONTENT);
    else {
      for (Animals a : listOfAnimals
      ) {
        nazwa = nazwa + a.id + "|" + a.name + "\n";
      }
    }
    return new ResponseEntity(nazwa, HttpStatus.OK);
  }

  @GetMapping("/shelter/pokazInfo")
  public ResponseEntity checkAnimal(@RequestParam String checkId) {

    //Iterator it = listOfAnimals.iterator();
    boolean isAvailable = false;
    String specsOfChecked = "";
    for (Animals animals : listOfAnimals) {
      if(animals.id.equals(checkId)){
        isAvailable = true;
        specsOfChecked = animals.id + " " + animals.name + " " + animals.animalType + " " + animals.age + " " + animals.animalSex;
      }
    }
    if(isAvailable) return new ResponseEntity(specsOfChecked,HttpStatus.OK);
    else return new ResponseEntity(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping
  public ResponseEntity adopt(@RequestParam String wantedID){
    boolean isAdopted = false;
    for (Animals a:listOfAnimals) {
      if (a.id.equals(wantedID)){
        isAdopted = true;
        listOfAnimals.remove(a);
      }
    }
    if(isAdopted) return new ResponseEntity("Adoptowano", HttpStatus.OK);
    else return new ResponseEntity(HttpStatus.NOT_FOUND);
  }

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
        usuwając go z systemu*/

