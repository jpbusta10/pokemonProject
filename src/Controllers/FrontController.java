package Controllers;
import model.Ability;
import model.Game;
import model.Pokemon;
import model.biomes.Biome;
import model.biomes.Gym;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FrontController {
    private static Game myGame;

    public static void NewGame(String name) {
        myGame = new Game(name);
        myGame.newChampionship();
    }

    public static boolean addPokemonToUserByid(int id) {
        boolean rta = false;
        Pokemon newPokemon = JsonController.PokemonByID(id);
        rta = myGame.addPokemonUser(newPokemon);
        return rta;
    }

    public static String getNotfinishedGyms() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Gym> notFinished = myGame.getNotFinishedGyms();
        for (Gym data : notFinished) {
            sb.append(data);
        }
        return sb.toString();
    }

    public static String getFinishedGymsNames() {

        StringBuilder sb = new StringBuilder();
        ArrayList<Gym> notFinished = myGame.getNotFinishedGyms();
        for (Gym data : notFinished) {
            sb.append(data.getName());
            sb.append("\n");
        }
        return sb.toString();

    }

    public static String getTodoGymName() { ///returns null if
        Gym gym = myGame.getToDoGym();
        return gym.getName();
    }

    public static String getMyPokemons() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Pokemon> pokemons = myGame.getMyPokemons();
        int id = 0;
        for (Pokemon data : pokemons) {
            sb.append(id + ": " + data.getName() + "\n");
            id++;
        }
        return sb.toString();
    }

    public static String safeUserPokemonReturn(int opcion) {
        return myGame.getMyUser().getPokemonFromSquad(opcion).getName();
    }

    public static String safePokemonAbiliti(int opcion, int habilidad) {
        return myGame.getMyUser().getPokemonFromSquad(opcion).getHabilidadString(habilidad);
    }

    public static String safePokemonAbilitiRival(int opcion, int habilidad) {
        return myGame.getActual().getPokemonFromSquad(opcion).getHabilidadString(habilidad);
    }

    public static String getPokemonSalvaje() {
        return myGame.getActual().getPokemonFromSquad(0).getName();
    }

    /**
     * receibes an option from user to generete a new trainer with a random pokemon already loaded
     *
     * @param "int" opcion;
     */
    public static void logicaCazarPokemones(int opcion) {
        switch (opcion) {
            case 1:
                myGame.setActual(myGame.Exploration(myGame.getVolcano()));
                break;
            case 2:
                myGame.setActual(myGame.Exploration(myGame.getBeach()));
                break;
            case 3:
                myGame.setActual(myGame.Exploration(myGame.getMountain()));
                break;
            case 4:
                myGame.setActual(myGame.Exploration(myGame.getCave()));
                break;
            case 5:
                myGame.setActual(myGame.Exploration(myGame.getForest()));
                break;
        }
    }

    public static void balancear(int opcion) {
        Pokemon.Balanceo(myGame.getActual().getPokemonFromSquad(0));
        Pokemon.Balanceo(myGame.getMyUser().getPokemonFromSquad(opcion));
    }

    public static String logicaPeleaExploration(int opcion, int habilidad) {
        String aux = "";
        if (Pokemon.peleaPokemon(myGame.getMyUser().getPokemonFromSquad(opcion).getHabilidad(habilidad).getDamage(), myGame.getActual().getPokemonFromSquad(0)) > 0) {
            return "vida restante de " + myGame.getActual().getPokemonFromSquad(0).getName()+": "+myGame.getActual().getPokemonFromSquad(0).getCurrentLife();
        } else {
            return "El pokemon " + myGame.getActual().getPokemonFromSquad(0).getName() + " no sobrevivio";
        }
    }

    /**
     * Method that returns true if the rival Pokemon stills has lifepoints;
     * Also returns false if pokemon lifepoints dropped bellow 0;
     * @return boolean;
     */
    public static boolean chequeadorDeVidaRival(){
        boolean respuesta=false;
        if(myGame.getActual().getPokemonFromSquad(0).getCurrentLife()>0){
            respuesta=true;
        }
        return respuesta;
    }
    /**
     * Method that returns true if my own Pokemon stills has lifepoints;
     * Also returns false if the Pokemon lifepoints dropped bellow 0;
     * @return boolean;
     */
    public static boolean chequeadorDeVidaPropia(int opcion){
        boolean respuesta=false;
        if(myGame.getMyUser().getPokemonFromSquad(opcion).getCurrentLife()>0){
            respuesta=true;
        }
        return respuesta;
    }

    /**
     * Method that attacks from the rival to your current Pokemon;
     * Receives an option from the user.
     * @param=  int opcion;
     * @return String;
     */
    public static String logicaPeleaExplorationInversa(int opcion){
        String aux="";
        if(Pokemon.peleaPokemon(myGame.getActual().getPokemonFromSquad(0).getHabilidad(0).getDamage(),myGame.getMyUser().getPokemonFromSquad(opcion))>0) {
            return "vida restante de " + myGame.getMyUser().getPokemonFromSquad(0).getName()+": "+myGame.getMyUser().getPokemonFromSquad(0).getCurrentLife();
        }else {
            return "El pokemon "+myGame.getMyUser().getPokemonFromSquad(opcion).getName()+" no sobrevivio";
        }
    }

    public static String catchpokemon(){
        myGame.getMyUser().addPokemonToStorage(myGame.getActual().getPokemonFromSquad(0));
        return "El poquemon ha sido capturado con exito";
    }

    /**
     * Generates a StringBuilder from a clone of the Ability Arraylist and separates them with an id.
     * @param= int opcion;
     * @return
     */
    public static String getPokemonAbilities(int opcion) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Ability> habilidades = myGame.getMyUser().getPokemonFromSquad(opcion).getHabilidades();
        int id = 0;
        for (Ability data : habilidades) {
            sb.append(id + ": " + data.getName() + "\n");
            id++;
        }
        return sb.toString();
    }


}
