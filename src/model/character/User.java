package model.character;

import model.Pokemon;
import model.character.Character;

import java.util.ArrayList;
import java.util.HashMap;

public class User extends Character {
    private HashMap<Integer, Pokemon> pokemonStorage; //Se almacena por el id unico.

    public User(String name, ArrayList<Pokemon> squad, HashMap<Integer, Pokemon> pokemonStorage) {
        super(name, squad);
        this.pokemonStorage = new HashMap<>();
    }

}
