package model;

import Controllers.JsonController;
import model.biomes.Gym;
import model.character.Character;
import model.character.Trainer;

import java.util.ArrayList;

public class Championship {

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
        brok.addPokemon(nuevo);
        nuevo = JsonController.PokemonByID(74); //geodude
        this.gyms.get(0).addTrainer(brok);
        //gym ciudad celeste
        gyms.add(new Gym("ciudad celeste"));
        Trainer misty = new Trainer("misty");
        nuevo = JsonController.PokemonByID(103);
        misty.addPokemon(nuevo);
        nuevo = JsonController.PokemonByID(54);
        misty.addPokemon(nuevo);
        this.gyms.get(1).addTrainer(misty);
        // gym ciudad carmin
        gyms.add(new Gym("ciudad carmin"));
        Trainer surge = new Trainer("Lt.Surge");
        surge.addPokemon(JsonController.PokemonByID(25));
        surge.addPokemon(JsonController.PokemonByID(26));
        surge.addPokemon(JsonController.PokemonByID(100));
        this.gyms.get(2).addTrainer(surge);
    }
    public ArrayList getGyms(){
        ArrayList<Gym> copyGyms = new ArrayList<>(gyms.size());
        copyGyms.addAll(gyms);
        return copyGyms;
    }







}
