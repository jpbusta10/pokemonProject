package model;

import Controllers.JsonController;
import model.biomes.Gym;
import model.character.Character;
import model.character.Trainer;

import java.io.Serializable;
import java.util.ArrayList;

public class Championship implements Serializable {

    private ArrayList<Gym> gyms;

    public Championship(){
        this.gyms = new ArrayList<>();
    }

    public void newChampionship(){
        //gym ciudad plateada
        gyms.add(new Gym("ciudad Plateada"));
        Trainer brok = new Trainer("brok");
        Pokemon nuevo = new Pokemon();
        nuevo = JsonController.PokemonByID(95); //onix
        Pokemon.Balanceo(nuevo);
        brok.addPokemon(nuevo);
        nuevo = JsonController.PokemonByID(74);//geodude
        Pokemon.Balanceo(nuevo);
        brok.addPokemon(nuevo);
        this.gyms.get(0).addTrainer(brok);
        //gym ciudad celeste
        gyms.add(new Gym("ciudad celeste"));
        Trainer misty = new Trainer("misty");
        nuevo = JsonController.PokemonByID(103);
        Pokemon.Balanceo(nuevo);
        misty.addPokemon(nuevo);
        nuevo = JsonController.PokemonByID(54);
        Pokemon.Balanceo(nuevo);
        misty.addPokemon(nuevo);
        this.gyms.get(1).addTrainer(misty);
        // gym ciudad carmin
        gyms.add(new Gym("ciudad carmin"));
        Trainer surge = new Trainer("Lt.Surge");
        nuevo=JsonController.PokemonByID(25);
        Pokemon.Balanceo(nuevo);
        surge.addPokemon(nuevo);
        nuevo=JsonController.PokemonByID(26);
        Pokemon.Balanceo(nuevo);
        surge.addPokemon(nuevo);
        nuevo=JsonController.PokemonByID(100);
        surge.addPokemon(nuevo);
        this.gyms.get(2).addTrainer(surge);
    }
    public ArrayList getGyms(){
        ArrayList<Gym> copyGyms = new ArrayList<>(gyms.size());
        copyGyms.addAll(gyms);
        return copyGyms;
    }
    public Gym getGymById(int id){
        return gyms.get(id);
    }
    public Gym getGymByName(String name){
        Gym rta = null;
        for( Gym data: gyms){
            if(data.getName().equals(name)){
                rta = data;
            }
        }
        return rta;
    }







}
