package model.character;

import model.Pokemon;

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

    public boolean removePokemon(Pokemon remove)
    {
        boolean response = false;
        if (squad.remove(remove))
        {
            response = true;
        }
        return response;
    }

    public void swapPokemon (int posX, int posY)
    {
        Pokemon aux = squad.get(posX); //Guardo pokemon de la posicion que voy a cambiar
        squad.remove(posX); //Elimino el pokemon de esa posicion, todos restan una posicion
        squad.add(posX, squad.get(posY - 1)); //Agrego el pokemon que queria cambiar en el lugar del que elimine. (posY - 1 porque todos se restaron un lugar)
        squad.remove(posY); //Elimino el pokemon que cambie
        squad.add(posY, aux); //Finalmente agrego el pokemon que guardamos en la variable aux
    }

    public void squadView ()
    {
        for (Pokemon aux :
                squad) {
            System.out.println(squad.indexOf(aux)+1 + ") " + aux.toString());
        }
    }

    public String pokemonData (int indexOfPokemon)
    {
        return squad.get(indexOfPokemon).toString();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
