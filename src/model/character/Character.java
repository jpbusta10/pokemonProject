package model.character;

import model.Ability;
import model.Pokemon;

import java.util.ArrayList;


public class Character {
    private String name;
    private ArrayList<Pokemon> squad;
    private int squadSize = 3;

    public Character(String name) {
        this.name = name;
        squad = new ArrayList<Pokemon>(squadSize);
    }

    public String getName() {
        return name;
    }

    public boolean addPokemon(Pokemon newPokemon) {

        boolean rta = squad.add(newPokemon);
        return rta;
    }

    public boolean removePokemon(Pokemon remove) {
        boolean response = false;
        if (squad.remove(remove)) {
            response = true;
        }
        return response;
    }

    public Pokemon getPokemon(int id) {
        Pokemon rta = this.squad.get(id);
        return rta;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public ArrayList<Pokemon> getSquad() {
        return (ArrayList<Pokemon>) this.squad.clone();
    }

    public Pokemon getRandomPokemon() {  ///returns a random pokemom from squad
        int random = (int) (Math.random() *squad.size());
        return squad.get(random);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
