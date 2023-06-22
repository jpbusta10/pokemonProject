package model.character;

import model.Pokemon;
import model.character.Character;

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
            response = pokemonStorage.remove(remove.getId(),remove);
        }else {
            throw new NullPointerException("el pokemon no existe");
        }
        return response;
    }

    public void switchPokemon (Pokemon fromStorage, int indexFromSquad) //toSquad es el pokemon que va del almacenamiento al squad y toStorage es el pokemon que va del squad al storage
    {
        Pokemon fromSquad = super.removePokemon(indexFromSquad);
        addPokemonToStorage(fromSquad);
        removePokemonFromStorage(fromStorage);
        super.addPokemon(fromStorage);
    }

    public void storageView ()
    {
        ArrayList <Pokemon> storagedPokemons = storageToArray();
        for (Pokemon aux :
                storagedPokemons) {
            System.out.println(storagedPokemons.indexOf(aux)+1 + ") " + aux.toString());
        }
    }

    public ArrayList storageToArray ()
    {
        ArrayList<Pokemon> storagedPokemons = new ArrayList<>();
        Iterator it = pokemonStorage.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry me = (Map.Entry) it.next();
            if (me.getValue() instanceof Pokemon)
            {
                Pokemon aux = (Pokemon) me.getValue();
                storagedPokemons.add(aux);
            }
        }
        return storagedPokemons;
    }

    public int getStorageSize ()
    {
        return pokemonStorage.size();
    }

    @Override
    public String toString() {
        return "User{" +
                "pokemonStorage=" + pokemonStorage +
                '}';
    }
}
