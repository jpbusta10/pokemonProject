package model.character;

import model.Pokemon;

import java.util.ArrayList;


public class Character {
    private String name;
    private ArrayList<Pokemon> squad;
    private final int squadSize = 3;

    public Character(String name) {
        this.name = name;
        squad = new  ArrayList<Pokemon>(squadSize);
    }
    public String getName() {
        return name;
    }

    public boolean addPokemon(Pokemon newPokemon) {

        boolean rta = squad.add(newPokemon);
        return rta;
    }

    public boolean removePokemon(Pokemon remove)
    {
        boolean response = false;
        if (squad.remove(remove))
        {
            response = true;
        }
        return response;
    }

    public ArrayList<Pokemon> getSquad() {
        return (ArrayList<Pokemon>) this.squad.clone();
    }

    @Override
    public String toString() {
        return "Character:" +
                "" + name + '\'' +
                "" + squad;
    }

    public Pokemon getPokemonFromSquad(int opcion){
        Pokemon aux= squad.get(opcion);
        return aux;
    }

}
