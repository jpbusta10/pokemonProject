package model;

import model.biomes.Biome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import Controllers.JsonController;
import model.biomes.Gym;
import model.character.Character;
import model.character.Trainer;
import model.character.User;
import scala.util.parsing.combinator.testing.Str;

public class Game implements Serializable {
    Biome forest = Biome.FOREST;
    Biome mountain = Biome.MOUNTAIN;
    Biome beach = Biome.BEACH;
    Biome cave = Biome.CAVE;
    Biome volcano = Biome.VOLCANO;
    private User myUser;
    private int idPokemon; ///actual id pokemon
    private Championship myChampionship;
    private Trainer actual;

    public Game() {
    }

    public Game(String name) {
        this.myUser = new User(name);
        myChampionship = new Championship();
    }

    public Biome getForest() {
        return forest;
    }

    public Biome getMountain() {
        return mountain;
    }

    public Biome getBeach() {
        return beach;
    }

    public Biome getCave() {
        return cave;
    }

    public Biome getVolcano() {
        return volcano;
    }

    /**
     * depending on the biome it returns a ramdom pokemon with respective types
     *
     * @param mybiome
     * @return Pokemon
     */
    public Trainer Exploration(Biome mybiome) {
        JsonController controller = new JsonController();
        Random random = new Random();
        int numeroAleatorio = random.nextInt(3) + 1;
        String tipo = mybiome.getTypes(numeroAleatorio);
        Pokemon nuevo = controller.RandomPokemon(tipo);
        Pokemon.Balanceo(nuevo);
        nuevo.setIdPokedex(idPokemon + 1);
        idPokemon++;
        Trainer trainer = new Trainer("Wild "+ nuevo.getName());
        trainer.addPokemon(nuevo);
        return trainer;
    }

    public void setActual(Trainer actual) {
        this.actual = actual;
    }

    public Trainer getActual() {
        return actual;
    }
    public User getMyUser(){
        return this.myUser;
    }

    public boolean addPokemonUser(Pokemon newPokemon) {
        boolean rta = this.myUser.addPokemon(newPokemon);
        return rta;
    }

    public void newChampionship() {
        this.myChampionship.newChampionship();
    }

    public ArrayList getNotFinishedGyms() {
        ArrayList<Gym> gyms = myChampionship.getGyms();
        ArrayList<Gym> notPassed = new ArrayList<>();
        for(Gym data: gyms){
            if(!data.isPassed()){
                notPassed.add(data);
            }
        }
        return notPassed;
    }
    public Gym getToDoGym(){
        ArrayList<Gym> gyms = myChampionship.getGyms();
        Gym rta = null;
        for(Gym gym: gyms){
            if(gym.isPassed() == false){
                return gym;
            }
        }
        return rta;
    }
    public Trainer getCurrentTrainer(){
        return getToDoGym().getTrainer();
    }
    public ArrayList<Pokemon> getMyPokemons(){
        ArrayList<Pokemon> pokemons = myUser.getSquad();
        return pokemons;
    }
    public Pokemon chooceRandomPokemon(Trainer myTrainer){
        return myTrainer.getRandomAlivePokemon();
    }
    public Pokemon getUserPokemon(int id){
        return myUser.getPokemon(id);
    }
    public Gym getGymByName(String name){
      return myChampionship.getGymByName(name);
    }

    /**
     * resets user pokemons to alive and set life back to max
     */
    public void resetUser(){
        for(int i=0; i<myUser.getSquad().size()-1;i++){
            myUser.getPokemon(i).setAlive(true);
            myUser.getPokemon(i).setCurrentLife(myUser.getPokemon(i).getMaxLife());
            System.out.println(myUser.getPokemon(i).toString());
        }
    }

    public String getSquad ()
    {
        return myUser.squadView();
    }

    public int getSquadSize ()
    {
        return myUser.getActualSquadSize();
    }

    public void swapPokemon (int posX, int posY)
    {
        myUser.swapPokemon(posX, posY);
    }

    public String getPokemonData (int indexOfPokemon)
    {
        return myUser.pokemonData(indexOfPokemon);
    }

    public String storageView ()
    {
        return myUser.storageView();
    }

    public int storageSize ()
    {
        return myUser.getStorageSize();
    }

    public void switchPokemon (int indexFromStorage, int indexFromSquad)
    {
        ArrayList<Pokemon> storagedPokemons = myUser.storageToArray();
        myUser.switchPokemon(storagedPokemons.get(indexFromStorage), indexFromSquad);
    }

    public void addPokemonToStorage (int indexToStorage)
    {
        if (myUser.getSquadSize() == 1)
        {
            System.out.println("Solo tienes un pokemon en el equipo, no lo puedes almacenar");
        }
        else
        {
            Pokemon aux = myUser.removePokemon(indexToStorage);
            myUser.addPokemonToStorage(aux);
            System.out.println("El equipo quedo de la siguiente manera");
            myUser.squadView();
        }
    }
}
