package model.Characters;

import model.Pokemon;

import java.util.ArrayList;

public abstract class Character {
    private String name;
    private ArrayList<Pokemon> squad;

    public Character(String name, ArrayList<Pokemon> squad) {
        this.name = name;
        this.squad = squad;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Pokemon> getSquad() {
        return squad;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
