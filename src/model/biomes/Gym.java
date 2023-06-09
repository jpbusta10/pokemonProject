package model.biomes;

import model.character.Trainer;

import java.io.Serializable;
import java.util.ArrayList;

public class Gym implements Serializable{
    private String name;
    private ArrayList<Trainer> trainers;
    private int level;
    private boolean passed;

    public Gym(String name){
        this.name = name;
        this.trainers = new ArrayList<>();
        this.passed = false;
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

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Trainer getTrainer(){
        return trainers.get(0);
    }

    @Override
    public String toString() {
        return "Gym{" +
                "name='" + name + '\'' +
                ", trainers=" + trainers +
                '}';
    }
}
