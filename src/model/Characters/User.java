package model.Characters;

import model.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;

public class User extends Character {
    private HashMap<Integer, Pokemon> pokemonStorage; //Se almacena por el id unico.

    public User(String name, ArrayList<Pokemon> squad, HashMap<Integer, Pokemon> pokemonStorage) {
        super(name, squad);
        this.pokemonStorage = new HashMap<>();
    }

    public boolean addPokemon (Pokemon newPokemon)
    {
        boolean response = false;

        return response;
    }

}
