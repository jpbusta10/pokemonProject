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

    public boolean addPokemonToStorage (Pokemon newPokemon)
    {
        boolean response = false;
        if (newPokemon != null)
        {
            if (pokemonStorage.put(newPokemon.getId(), newPokemon) != null)
            {
                response = true;
            }
            else {

            }
        }
        else
        {
            throw new NullPointerException("Pokemon nulo.");
        }
        return response;
    }

    public boolean removePokemonFromStorage(Pokemon remove)
    {
        boolean response = false;
        return response;
    }

    public void switchPokemon (Pokemon toSquad, Pokemon toStorage) //toSquad es el pokemon que va del almacenamiento al squad y toStorage es el pokemon que va del squad al storage
    {
        //removePokemon();
    }

}
