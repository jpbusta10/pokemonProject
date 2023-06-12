import Controllers.ApiController;
import model.Pokemon;


import static Controllers.JsonController.RandomPokemon;

public class Main {
    public static void main(String[] args) {
        Pokemon nuevo = RandomPokemon("Electric");
        System.out.println(nuevo.toString());

    }
}