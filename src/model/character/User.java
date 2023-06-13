package model.character;

import model.Pokemon;
import model.character.Character;

import java.util.ArrayList;
import java.util.HashMap;

public class User extends Character {
    private HashMap<Integer, Pokemon> pokemonStorage; //Se almacena por el id unico.

    public User(String name) {
        super(name);
        this.pokemonStorage = new HashMap<Integer, Pokemon>();
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
        if(remove!=null){
            this.pokemonStorage.remove(remove.getId(),remove);
            response=true;
        }else {
            throw new NullPointerException("el pokemon no existe");
        }
        return response;
    }

    public void switchPokemon (Pokemon toSquad, Pokemon toStorage) //toSquad es el pokemon que va del almacenamiento al squad y toStorage es el pokemon que va del squad al storage
    {
    }


}
