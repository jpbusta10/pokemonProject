package model;

import model.biomes.Biome;

import java.util.ArrayList;
import java.util.Random;

import Controllers.JsonController;
import model.biomes.Gym;
import model.character.Character;
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
     * depending of the biome it returns a ramdom pokemon with respective types
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
        for (int i = 0; i < gyms.size() && !gyms.get(i).isPassed(); i++) {
            notPassed.add(gyms.get(i));
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

    public void getSquad ()
    {
        myUser.squadView();
    }

    public int getSquadSize ()
    {
        return myUser.getSquadSize();
    }

    public void swapPokemon (int posX, int posY)
    {
        myUser.swapPokemon(posX, posY);
    }

    public String getPokemonData (int indexOfPokemon)
    {
        return myUser.pokemonData(indexOfPokemon);
    }

    public void storageView ()
    {
        myUser.storageView();
    }

    public int storageSize ()
    {
        return myUser.getStorageSize();
    }

    public void switchPokemon (int indexToSquad, int indexToStorage)
    {
        myUser.
        myUser.switchPokemon(toSquad, toStorage);
    }
}
