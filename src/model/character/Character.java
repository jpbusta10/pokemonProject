package model.character;

import model.Pokemon;
import model.exceptions.FullSquadException;

import java.util.ArrayList;


public class Character {
    private String name;
    private ArrayList<Pokemon> squad;
    private final int squadSize = 3;

    public Character(String name) {
        this.name = name;
        squad = new  ArrayList<Pokemon>(squadSize);
    }
    public String getName() {
        return name;
    }

    public boolean addPokemon(Pokemon newPokemon) throws FullSquadException, NullPointerException {
        boolean response = false;
        if (newPokemon != null) {
            if (squad.size() < squadSize) {

                response = squad.add(newPokemon);
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
        boolean response = false;
        if (squad.remove(remove))
        {
            response = true;
        }
        return response;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
