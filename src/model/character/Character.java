package model.character;

import model.Pokemon;
import model.exceptions.FullSquadException;

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
            System.out.println(squad.indexOf(aux) + ") " + aux.toString());
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", squad=" + squad +
                '}';
    }
}
