package model.biomes;

import java.util.ArrayList;

public enum Biome {
    FOREST("Grass","Electic","Bug"), MOUNTAIN("Ground","Flying","Electric"), BEACH("Water","Electric","Bug"), VOLCANO("Fire","Ground","Electric"), CAVE("Poison","Ground","Bug");

    private ArrayList<String> pokemonTypes;

    private Biome (String type1, String type2, String type3){
        this.pokemonTypes = new ArrayList<>();
        this.pokemonTypes.add(type1);
        this.pokemonTypes.add(type2);
        this.pokemonTypes.add(type3);
    }
    public String getTypes(int id){
        String rta = null;
        if(id>=0 && id<pokemonTypes.size()-1){
            rta = pokemonTypes.get(id);
        }
        return rta;
    }

}
