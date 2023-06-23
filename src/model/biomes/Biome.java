package model.biomes;

import java.io.Serializable;
import java.util.ArrayList;

public enum Biome implements Serializable{
    FOREST("Grass", "Electic", "Bug"), MOUNTAIN("Ground","Flying","Electric"), BEACH("Water","Electric", "Bug"), VOLCANO("Fire","Ground","Electric"), CAVE("Poison","Ground", "Bug");

    private ArrayList<String> pokemonTypes;

    private Biome (String type1, String type2, String type3){
        this.pokemonTypes = new ArrayList<>();
        this.pokemonTypes.add(type1);
        this.pokemonTypes.add(type2);
        this.pokemonTypes.add(type3);
    }
    public String getTypes(int id){
        return pokemonTypes.get(id);
    }

}
