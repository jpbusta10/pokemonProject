package Controllers;
import model.Ability;
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
    public static String getUserPokemonNameByid(int id){
       return myGame.getUserPokemon(id).getName();
    }
    public static String attackFromTrainer(int idPokemon, String trainerPokemonName, String gymName){
        Pokemon userPokemon = myGame.getUserPokemon(idPokemon);
        Gym myGym = myGame.getGymByName(gymName);
        Pokemon trainerPokemon = myGym.getTrainer().getPokemonbyName(trainerPokemonName);
        Pokemon.Balanceo(trainerPokemon);
        Ability attack = trainerPokemon.randomAbilitie();
        userPokemon.setCurrentLife(userPokemon.getCurrentLife()-attack.getDamage());
        String response = trainerPokemonName + "le ah hecho "+attack.getDamage()+" a "+userPokemon.getName();
        if(userPokemon.getCurrentLife()<=0){
            userPokemon.setAlive(false);
            response = null;
        }
        return response;
    }









}
