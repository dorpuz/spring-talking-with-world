package pl.edu.wszib.springtalkingwithworld;

public class Animals {

  String name;
  int age;
  AnimalType animalType;
  AnimalSex animalSex;
  String id;

  public Animals(String name, int age, AnimalType animalType, AnimalSex animalSex) {
    this.name = name;
    this.age = age;
    this.animalType = animalType;
    this.animalSex = animalSex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public AnimalType getAnimalType() {
    return animalType;
  }

  public void setAnimalType(AnimalType animalType) {
    this.animalType = animalType;
  }

  public AnimalSex getAnimalSex() {
    return animalSex;
  }

  public void setAnimalSex(AnimalSex animalSex) {
    this.animalSex = animalSex;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}






/* * 		imie - typ String
 * 		wiek - typ integer
 * 		typ - typu Enum TypZwierzaka o wartościach KOT/PIES/LIS/SZOP
 * 		płeć - typ Enum PlecZwierzaka o wartościach K/M
 * 		id - generowany identyfikator*/