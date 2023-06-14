package Controllers;
import model.Game;
import model.Pokemon;

public class FrontController {
    private static Game myGame;

    public static void NewGame(String name){
        myGame = new Game(name);
    }

    public static boolean addPokemonToUserByid(int id){
        boolean rta = false;
        Pokemon newPokemon = JsonController.PokemonByID(id);
        rta = myGame.addPokemonUser(newPokemon);
        return rta;
    }




}
