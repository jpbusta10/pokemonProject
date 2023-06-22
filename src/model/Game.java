package model;

import model.biomes.Biome;

import java.util.ArrayList;
import java.util.Random;

import Controllers.JsonController;
import model.biomes.Gym;
import model.character.Character;
import model.character.Trainer;
import model.character.User;

public class Game {
    Biome forest = Biome.FOREST;
    Biome mountain = Biome.MOUNTAIN;
    Biome beach = Biome.BEACH;
    Biome cave = Biome.CAVE;
    Biome volcano = Biome.VOLCANO;
    private User myUser;
    private int idPokemon; ///actual id pokemon
    private Championship myChampionship;

    public Game() {
    }

    public Game(String name) {
        this.myUser = new User(name);
        myChampionship = new Championship();
    }

    /**
     * depending on the biome it returns a ramdom pokemon with respective types
     *
     * @param mybiome
     * @return Pokemon
     */
    public Pokemon Exploration(Biome mybiome) {
        JsonController controller = new JsonController();
        Random random = new Random();
        int numeroAleatorio = random.nextInt(3) + 1;
        String tipo = mybiome.getTypes(numeroAleatorio);
        Pokemon nuevo = controller.RandomPokemon(tipo);
        nuevo.setIdPokedex(idPokemon + 1);
        idPokemon++;
        return nuevo;
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

    /**
     * returns the first not finished gyms
     * @return Gym
     */
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
     * reset the user pokemon to default characteristics
     */
    public void resetUser(){
        for(int i=0; i<myUser.getSquadSize();i++){
            myUser.getPokemon(i).setAlive(true);
            myUser.getPokemon(i).setCurrentLife(myUser.getPokemon(i).getMaxLife());
        }
    }

}
