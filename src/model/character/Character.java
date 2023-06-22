package model.character;

import model.Pokemon;
import model.biomes.Gym;

import java.util.ArrayList;


public class Character {
    private String name;
    private ArrayList<Pokemon> squad;
    private final int squadSize = 6;

    public Character(String name) {
        this.name = name;
        squad = new  ArrayList<Pokemon>(squadSize);
    }
    public String getName() {
        return name;
    }

    public int getSquadSize()
    {
        return squad.size();
    }

    public boolean addPokemon(Pokemon newPokemon) {

        boolean rta = squad.add(newPokemon);
        return rta;
    }

    public void addPokemon(int index, Pokemon newPokemon)
    {
        squad.add(index, newPokemon);
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

    public Pokemon removePokemon(int indexRemove)
    {
        return squad.remove(indexRemove);
    }

    public void swapPokemon (int posX, int posY)
    {
        if (posX < posY)
        {
            Pokemon aux = squad.remove(posX);//Guardo pokemon de la posicion que voy a cambiar y lo elimino
            squad.add(posX, squad.get(posY-1)); //Agrego el pokemon que queria cambiar en el lugar del que elimine. (posY - 1 porque todos se restaron un lugar)
            squad.remove(posY); //Elimino el pokemon que cambie
            squad.add(posY, aux); //Finalmente agrego el pokemon que guardamos en la variable aux
        }
        else
        {
            Pokemon aux = squad.remove(posX);//Guardo pokemon de la posicion que voy a cambiar y lo elimino
            squad.add(posX, squad.get(posY)); //Agrego el pokemon que queria cambiar en el lugar del que elimine. (posY - 1 porque todos se restaron un lugar)
            squad.remove(posY); //Elimino el pokemon que cambie
            squad.add(posY, aux); //Finalmente agrego el pokemon que guardamos en la variable aux
        }

    }

    public String squadView ()
    {
        StringBuilder sb = new StringBuilder();
        for (Pokemon data : squad) {
            sb.append(squad.indexOf(data)+1 + ". " + data.getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String pokemonData (int indexOfPokemon)
    {
        return squad.get(indexOfPokemon).getPokemonData();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
