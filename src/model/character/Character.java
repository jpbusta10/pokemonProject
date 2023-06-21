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
        squad = new ArrayList<Pokemon>(squadSize);
    }

    public String getName() {
        return name;
    }

    public boolean addPokemon(Pokemon newPokemon) {
        boolean response = false;
        if (newPokemon != null) {
            if (squad.size() < squadSize) {

                response = squad.add(newPokemon);
            } else {
                throw new NullPointerException("Pokemon nulo.");
            }
        }
        return response;
    }


        public boolean removePokemon (Pokemon remove){
            boolean response = false;
            if (squad.remove(remove)) {
                response = true;
            }
            return response;
        }

    public String getSquad() {
        return squad.toString();
    }

    public Pokemon getPokemonFromSquad(int opcion){
            Pokemon variable = new Pokemon();
            switch (opcion) {
                case 1:
                    variable = squad.get(0);
                    break;
                case 2:
                    variable = squad.get(1);
                    break;
                case 3:
                    variable = squad.get(2);
                    break;
            }
            return variable;
        }

    public boolean vacio(){
        boolean respuesta=false;
        if(squad.isEmpty()){
            respuesta=true;
        }
        return respuesta;
    }
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
