package model.biomas;

import model.Pokemon;

import java.util.ArrayList;
import java.util.Random;

public abstract class Bioma {
    private String name;
    private ArrayList<String> pokemonTypes;

    public Bioma(String name) {
        this.name = name;
        pokemonTypes = new ArrayList<>();
    }
    public void addType(String nuevoTipo){
        this.pokemonTypes.add(nuevoTipo);
    }
    public Pokemon instanciarPokemon(){
        Pokemon rta = new Pokemon();
        Random rand = new Random();
        int index = rand.nextInt(pokemonTypes.size());
        //busco con ese index de los types al tipo y desp le mando la consulta a la api

        return rta;
    }
}
