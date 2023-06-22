package model;

import java.io.Serializable;

public class Ability implements Serializable {
    private String name;
    private int damage;

    public Ability(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }


}
