package Controllers;
import model.Game;
import model.Pokemon;
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

    public static String getSquad()
    {
        return myGame.getSquad();
    }

    public static String getPokemonData(int indexOfPokemon)
    {
        return myGame.getPokemonData(indexOfPokemon);
    }

    public static int getSquadSize ()
    {
        return myGame.getSquadSize();
    }

    public static void swapPokemon (int posX, int posY)
    {
        myGame.swapPokemon(posX, posY);
    }

    public static String storageView ()
    {
        return myGame.storageView();
    }

    public static int storageSize ()
    {
        return myGame.storageSize();
    }

    public static void switchPokemon (int indexFromStorage, int indexFromSquad)
    {
        myGame.switchPokemon(indexFromStorage, indexFromSquad);
    }

    public static void addPokemonToStorage (int indexToStorage)
    {
        myGame.addPokemonToStorage(indexToStorage);
    }

}
