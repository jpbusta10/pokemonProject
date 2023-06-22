package model.character;

import model.Ability;
import model.Pokemon;

import java.util.ArrayList;
import java.util.List;


public class Character {
    private String name;
    private ArrayList<Pokemon> squad;
    private int squadSize = 3;

    public Character(String name) {
        this.name = name;
        squad = new ArrayList<Pokemon>(squadSize);
    }

    public String getName() {
        return name;
    }

    public boolean addPokemon(Pokemon newPokemon) {

        boolean rta = squad.add(newPokemon);
        return rta;
    }

    public boolean removePokemon(Pokemon remove) {
        boolean response = false;
        if (squad.remove(remove)) {
            response = true;
        }
        return response;
    }

    public Pokemon getPokemon(int id) {
        Pokemon rta = this.squad.get(id);
        return rta;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public ArrayList<Pokemon> getSquad() {
        return (ArrayList<Pokemon>) this.squad.clone();
    }

    /**
     * gets a random alive pokemon from squad, if it doesn`t exist returns null
     * @return Pokemon or null
     */
    public Pokemon getRandomAlivePokemon() {
        List<Pokemon> alivePokemon = new ArrayList<>();

        for (Pokemon pokemon : squad) {
            if (pokemon.isAlive()) {
                alivePokemon.add(pokemon);
            }
        }

        if (alivePokemon.isEmpty()) {
            return null; // No alive Pokémon found
        }

        int randomIndex = (int) (Math.random() * alivePokemon.size());
        return alivePokemon.get(randomIndex);
    }
    public boolean checkIfAlivePokemons(){
        for(Pokemon data: squad){
            if(data.isAlive()){
                return true;
            }
        }
        return false;
    }


    public Pokemon getPokemonbyName(String name){
        Pokemon rta = null;
        for(Pokemon data: squad){
            if(data.getName().equals(name)){
                rta = data;
            }
        }
        return rta;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
