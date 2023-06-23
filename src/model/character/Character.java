package model.character;

import model.Ability;
import model.Pokemon;
import model.biomes.Gym;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Character implements Serializable {
    private String name;
    private ArrayList<Pokemon> squad;
    private final int squadSize = 6;

    public Character(String name) {
        this.name = name;
        squad = new ArrayList<Pokemon>(squadSize);
    }

    public String getName() {
        return name;
    }

    public int getActualSquadSize()
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

    /**
     * returns a copy of the squad
     * @return ArrayList
     */
    public ArrayList<Pokemon> getSquad() {
        return (ArrayList<Pokemon>) this.squad.clone();
    }

    /**
     * gets a random alive pokemon from squad, if it doesn`t exist returns null
     * @return Pokemon or null
     */
    public Pokemon getRandomAlivePokemon() {
        List<Pokemon> alivePokemon = new ArrayList<>();

        for (Pokemon pokemon : squad) {
            if (pokemon.isAlive()) {
                alivePokemon.add(pokemon);
            }
        }

        if (alivePokemon.isEmpty()) {
            return null; // No alive Pokémon found
        }

        int randomIndex = (int) (Math.random() * alivePokemon.size());
        return alivePokemon.get(randomIndex);
    }
    public boolean checkIfAlivePokemons(){
        for(Pokemon data: squad){
            if(data.isAlive()){
                return true;
            }
        }
        return false;
    }


    public Pokemon getPokemonbyName(String name){
        Pokemon rta = null;
        for(Pokemon data: squad){
            if(data.getName().equals(name)){
                rta = data;
            }
        }
        return rta;
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
        return "Character:" +
                "" + name + '\'' +
                "" + squad;
    }

    public Pokemon getPokemonFromSquad(int opcion){
        Pokemon aux= squad.get(opcion);
        return aux;
    }

}
