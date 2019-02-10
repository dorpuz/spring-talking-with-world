package pl.edu.wszib.springtalkingwithworld;

public class Restaurant {

    public static double koszt(Client client){
        double wynik =25;
        if(client.accompany){
            wynik += 15;
        }
        if(client.kid){
            wynik += 40;
        }

        if(client.animal){
            wynik += 20;
        }
        return wynik;
    }

}
