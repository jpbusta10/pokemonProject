package Controllers;
import model.Ability;
import model.Game;
import model.Pokemon;
import model.biomes.Biome;
import model.biomes.Gym;
import model.character.Trainer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FrontController {
    private static Game myGame;

    public static void NewGame(String name) {
        myGame = new Game(name);
        myGame.newChampionship();
    }

    /**
     * adds a pokemon by pokedexId
     * @param id
     * @return boolean
     */
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

    public static String safeUserPokemonNameReturn(int opcion) {
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
            myGame.getMyUser().getPokemonFromSquad(opcion).setAlive(false);
            return "El pokemon "+myGame.getMyUser().getPokemonFromSquad(opcion).getName()+" no sobrevivio";
        }
    }

    public static String catchpokemon(){
        myGame.getMyUser().addPokemonToStorage(myGame.getActual().getPokemonFromSquad(0));
        return "El pokemon ha sido capturado con exito";
    }

    /**
     * Generates a StringBuilder from a clone of the Ability Arraylist and separates them with an id.
     * @param= int opcion;
     * @return
     */
    public static String getTodoGymName() { ///returns null if
        Gym gym = myGame.getToDoGym();
        return gym.getName();
    }
    public static String getToDoTrainerName(){
        Trainer myTrainer = myGame.getCurrentTrainer();
        return myTrainer.getName();
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
     * @param= pokemonName
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
            id++;
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
        String response = userPokemon.getName()+" le ah hecho "+myAbilitie.getDamage()+" con "+myAbilitie.getName()+" a "+trainerPokemonName;
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
    public static void resetUser(){
        myGame.resetUser();
    }
    public static int getSquadSize ()
    {
        return myGame.getSquadSize();
    }
    public static String mostrarVidaPokemonUser(int opcion){
        return "vida restante: "+ myGame.getMyUser().getPokemonFromSquad(opcion).getCurrentLife();
    }
    public static String mostrarVidaPokemonRival(){
        return "vida restante: "+myGame.getActual().getPokemonFromSquad(0).getCurrentLife();

    }

    public static String mostrarNivelPokemonRival(){
        return "Nivel: "+ myGame.getActual().getPokemonFromSquad(0).getLevel();
    }
    public static String levear(int opcion){
        String mensaje;
            if(myGame.getMyUser().getPokemonFromSquad(opcion).getLevel()+1==20){
             mensaje="Tu pokemon ha Evolucionado";
             }
            Pokemon.levelup(myGame.getUserPokemon(opcion));
        mensaje= "Tu pokemon subio de nivel\n" + "El nuevo nivel es: "+ myGame.getMyUser().getPokemonFromSquad(opcion).getLevel();
        return mensaje;
    }

}
