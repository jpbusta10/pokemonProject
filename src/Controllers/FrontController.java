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

    /**
     * adds a pokemon by pokedexId
     * @param id
     * @return boolean
     */
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
    public static String chooceRandomAlivePokemom(){
        Pokemon trainerPok = myGame.getCurrentTrainer().getRandomAlivePokemon();
        if(trainerPok != null){
            return trainerPok.getName();
        }
        else {
            return null;
        }
    }
    public static String getUserPokemonNameByid(int id){
       return myGame.getUserPokemon(id).getName();
    }

    /**
     * passing the information about the fisht makes an attack from the trainer with a random abilitie to the user pokemon
     * @param idPokemon
     * @param trainerPokemonName
     * @param gymName
     * @return String with the damage dealt
     * @return null if user pokemon dies
     */
    public static String attackFromTrainer(int idPokemon, String trainerPokemonName, String gymName){
        Pokemon userPokemon = myGame.getUserPokemon(idPokemon);
        Gym myGym = myGame.getGymByName(gymName);
        Pokemon trainerPokemon = myGym.getTrainer().getPokemonbyName(trainerPokemonName);
        Ability attack = trainerPokemon.randomAbilitie();
        userPokemon.setCurrentLife(userPokemon.getCurrentLife()-attack.getDamage());
        String response = trainerPokemonName + " le ah hecho "+attack.getDamage()+" a "+userPokemon.getName();
        if(userPokemon.getCurrentLife()<=0){
            userPokemon.setAlive(false);
            response = null;
        }
        return response;
    }

    /**
     * checks if user pokemon is alive
     * @param id
     * @return boolean
     */
    public static boolean checkIfAliveUser(int id){
        return myGame.getUserPokemon(id).isAlive();
    }

    /**
     * checks if trainer pokemon is alive
     * @param pokemonName
     * @return boolean
     */
    public static boolean checkIfAliveTrainer(String pokemonName){
       return myGame.getToDoGym().getTrainer().getPokemonbyName(pokemonName).isAlive();
    }
    public static String getPokemonAbilities(int idPokemon){
        StringBuilder sb = new StringBuilder();
        Pokemon myPokemon = myGame.getUserPokemon(idPokemon);
        int id = 0;
        for(Ability data: myPokemon.getHabilidades()){
            sb.append(id+": "+data.getName()+" damage: "+data.getDamage()+"\n");
        }
        return sb.toString();
    }

    /**
     * makes an attack from user pokemon to trainer pokemon usig a chosen abilitie
     * @param idPokemon
     * @param trainerPokemonName
     * @param gymName
     * @param abilitieId
     * @return String with message or null if trainer pokemon is dead
     */
    public static String attackFromUserToTrainer(int idPokemon, String trainerPokemonName, String gymName, int abilitieId){
        Pokemon userPokemon = myGame.getUserPokemon(idPokemon);
        Gym myGym = myGame.getGymByName(gymName);
        Pokemon trainerPokemon = myGym.getTrainer().getPokemonbyName(trainerPokemonName);
        Ability myAbilitie = userPokemon.getAbilitieById(abilitieId);
        trainerPokemon.setCurrentLife(trainerPokemon.getCurrentLife()-myAbilitie.getDamage());
        String response = userPokemon.getName()+" le ah hecho "+myAbilitie.getDamage()+" a "+trainerPokemonName;
        if(trainerPokemon.getCurrentLife() <= 0){
            response = null;
            trainerPokemon.setAlive(false);
        }
        return response;
    }

    /**
     * checks if the trainer has alive pokemons
     * @return boolean
     */
    public static boolean checkIfAbailablePokemonsTrainer(){
        Trainer myTrainer = myGame.getCurrentTrainer();
        return  myTrainer.checkIfAlivePokemons();
    }

    /**
     * checks if it has alive pokemons
     * @return boolean
     */
    public static boolean checkIfAbailablePokemonsUser(){
        return myGame.getMyUser().checkIfAlivePokemons();
    }

    /**
     * sets the gym as passed
     */
    public static void setFinishedGym(){
        myGame.getToDoGym().setPassed(true);
    }










}
