package model;

import model.biomas.Bioma;

public class Game {
    private Bioma forest;
    private Bioma beach;
    private Bioma cave;
    private Bioma volcano;
    private Bioma mountain;

    public Game(){
        //types forest
        this.forest.addType("Electric");
        this.forest.addType("Grass");
        this.forest.addType("Normal");
        this.forest.addType("Bug");
        //types beach
        this.beach.addType("Water");
        this.beach.addType("Poison");
        //types cave
        this.cave.addType("Poison");
        this.cave.addType("Ground");

        //types volcan
        this.volcano.addType("Fire");
        this.volcano.addType("Flying");

        //types mountain
        this.mountain.addType("Ground");
        this.mountain.addType("flying");
    }

}
