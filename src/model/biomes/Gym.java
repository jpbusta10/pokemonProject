package model.biomes;

import model.character.Trainer;

import java.util.ArrayList;

public class Gym {
    private String name;
    private ArrayList<Trainer> trainers;
    private int level;

    public Gym(String name){
        this.trainers = new ArrayList<>();
    }
    public void addTrainer(Trainer newTrainer){
        this.trainers.add(newTrainer);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
