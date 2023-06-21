package Controllers;
import model.Game;
import model.Pokemon;
import model.character.Character;
import model.character.User;
import model.biomes.Gym;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class FrontController {
    private static Game myGame;

    public static void NewGame(String name){
        myGame = new Game(name);
        myGame.newChampionship();
    }

    public static boolean addPokemonToUserByid(int id){
        boolean rta = false;
        Pokemon newPokemon = JsonController.PokemonByID(id);
        rta = myGame.addPokemonUser(newPokemon);
        return rta;
    }
    public static String getNotfinishedGyms(){
        StringBuilder sb = new StringBuilder();
        ArrayList<Gym> notFinished = myGame.getNotFinishedGyms();
        for(Gym data: notFinished){
            sb.append(data);
        }
        return sb.toString();
    }
    public static String getFinishedGymsNames(){

        StringBuilder sb = new StringBuilder();
        ArrayList<Gym> notFinished = myGame.getNotFinishedGyms();
        for (Gym data : notFinished) {
            sb.append(data.getName());
            sb.append("\n");
        }
        return sb.toString();

    }
    public static String getTodoGymName(){ ///returns null if
        Gym gym = myGame.getToDoGym();
        return gym.getName();
    }
    public static String listadepokemonesuser(){
        return myGame.getMyUser().getSquad();
    }
    public static String safeUserPokemonReturn(int opcion){
        return myGame.getMyUser().getPokemonFromSquad(opcion).toString();
    }











}
