package model.character;

import model.Pokemon;
import model.character.Character;
import model.exceptions.FullSquadException;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
            response = this.pokemonStorage.remove(remove.getId(),remove);
        }else {
            throw new NullPointerException("el pokemon no existe");
        }
        return response;
    }

    public void switchPokemon (Pokemon toSquad, Pokemon toStorage) //toSquad es el pokemon que va del almacenamiento al squad y toStorage es el pokemon que va del squad al storage
    {
        if (super.removePokemon(toStorage))
        {
            addPokemonToStorage(toStorage);
            removePokemonFromStorage(toSquad);
            try{
                super.addPokemon(toSquad);
            }
            catch (FullSquadException ex)
            {
                System.out.println(ex.getMessage());
            }

        }
    }

    public void storageView ()
    {
        Iterator it = pokemonStorage.entrySet().iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }


}
