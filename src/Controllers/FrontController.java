package Controllers;
import model.Game;
import model.Pokemon;
import model.character.Character;
import model.character.User;


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

    public static String listadepokemonesuser(){
        return myGame.getMyUser().getSquad();
    }
    public static String safeUserPokemonReturn(int opcion){
        return myGame.getMyUser().getPokemonFromSquad(opcion).toString();
    }

    public static String getPokemonOponente(Character enemigo,int opcion){
        return enemigo.getPokemonFromSquad(opcion).toString();
    }









}
