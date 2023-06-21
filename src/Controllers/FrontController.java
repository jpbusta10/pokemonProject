package Controllers;
import model.Game;
import model.Pokemon;
import model.biomes.Gym;
import model.character.Trainer;
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
    public static String getToDoTrainerName(){
        Trainer myTrainer = myGame.getCurrentTrainer();
        return myTrainer.getName();
    }
    public static String getMyPokemons(){
        StringBuilder sb = new StringBuilder();
        ArrayList<Pokemon> pokemons = myGame.getMyPokemons();
        int id = 0;
        for(Pokemon data: pokemons){
            sb.append(id + ": "+ data.getName()+"\n");
            id++;
        }
        return sb.toString();
    }
    public static String chooceRandomPokemom(){
        return myGame.getCurrentTrainer().getRandomPokemon().getName();
    }









}
