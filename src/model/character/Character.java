package model.character;

import model.Pokemon;
import model.exceptions.FullSquadException;

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

    public boolean addPokemon(Pokemon newPokemon) throws FullSquadException, NullPointerException {
        boolean response = false;
        if (newPokemon != null) {
            if (squad.size() < squadSize) {
                squad.add(newPokemon);
                response = true;
            } else {
                throw new FullSquadException();
            }
        } else
        {
            throw new NullPointerException("Pokemon nulo.");
        }
        return response;
    }

    public boolean removePokemon(Pokemon remove)
    {

    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
