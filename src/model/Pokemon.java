package model;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private ArrayList<String> tipos = new ArrayList<String>();
    private ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
    private int id;
    private int id_evolucion;
    private int nivel;
    private int experiencia;
    private int vida_maxima; //aumenta con el nivel
    private int vida_actual;

    public Pokemon(String name, ArrayList<String> tipos, ArrayList<Habilidad> habilidades, int id,
                   int id_evolucion, int nivel, int experiencia, int vida_maxima, int vida_actual) {
        this.name = name;
        this.tipos = tipos;
        this.habilidades = habilidades;
        this.id = id;
        this.id_evolucion = id_evolucion;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.vida_maxima = vida_maxima;
        this.vida_actual = vida_actual;
    }

    public Pokemon() {

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

    public int getId_evolucion() {
        return id_evolucion;
    }

    public void setId_evolucion(int id_evolucion) {
        this.id_evolucion = id_evolucion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getVida_maxima() {
        return vida_maxima;
    }

    public void setVida_maxima(int vida_maxima) {
        this.vida_maxima = vida_maxima;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public void agregarArrayListTipo(String tipo){
        tipos.add(0,tipo);
    }
    public void agregarArrayListHabilidades(Habilidad habilidad){
        habilidades.add(0,habilidad);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", tipos=" + tipos +
                ", habilidades=" + habilidades +
                ", id=" + id +
                ", nivel=" + nivel +
                ", id_evolution=" + id_evolucion +
                '}';
    }
}
