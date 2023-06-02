package model;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private String nickName;
    private ArrayList<String> types;
    private ArrayList<Ability> abilities;
    private int id;
    private int idPokedex;
    private int idEvolution;
    private int level;
    private int experience;
    private int maxLife; //aumenta con el nivel
    private int currentLife;

    public Pokemon(String name, ArrayList<String> types, ArrayList<Ability> abilities, int id, int idPokedex,
                   int idEvolution, int level, int experience, int maxLife, int currentLife) {
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.id = id;
        this.idEvolution = idEvolution;
        this.level = level;
        this.experience = experience;
        this.maxLife = maxLife;
        this.currentLife = currentLife;
        this.idPokedex = idPokedex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public int getIdPokedex() {
        return idPokedex;
    }

    public void setIdPokedex(int idPokedex) {
        this.idPokedex = idPokedex;
    }

    public int getIdEvolution() {
        return idEvolution;
    }

    public void setIdEvolution(int idEvolution) {
        this.idEvolution = idEvolution;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }
}
