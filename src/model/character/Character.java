package model.character;

import model.Pokemon;

import java.util.ArrayList;


public abstract class Character {
    private String name;
    private ArrayList<Pokemon> squad;
    private final int squadSize = 6;

    public Character(String name, ArrayList<Pokemon> squad) {
        this.name = name;
        this.squad = squad;
    }

    public String getName() {
        return name;
    }

    public boolean addPokemon (Pokemon newPokemon)
    {
        boolean response = false;
        if (newPokemon != null)
        {
            if (squad.size() <= squadSize) {
                squad.add(newPokemon);
                response = true;
            }
            else
            {
        }
        return response;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
