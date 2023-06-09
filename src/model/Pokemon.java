package model;

import Controllers.JsonController;
import model.Ability;
import Controllers.JsonController;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable{
    private String name;
    private String nickName;
    private ArrayList<String> tipos;
    private ArrayList<Ability> habilidades;
    private int id;
    private int idPokedex;
    private int idEvolution;
    private int level;
    private int experience;
    private int maxLife; //aumenta con el nivel
    private int currentLife;
    private boolean isAlive;

    public Pokemon(String name, int id, int idPokedex, int idEvolution, int level, int experience, int maxLife, int currentLife) {
        this.name = name;
        this.tipos = new ArrayList<String>();
        this.habilidades = new ArrayList<Ability>();
        this.id = id;
        this.idEvolution = idEvolution;
        this.level = level;
        this.experience = experience;
        this.maxLife = maxLife;
        this.currentLife = currentLife;
        this.idPokedex = idPokedex;
        this.isAlive = true;
    }

    public Pokemon() {
        this.habilidades = new ArrayList<>();
        this.tipos = new ArrayList<>();
        this.isAlive = true;
    }
    public ArrayList<Ability> getHabilidades(){
        return (ArrayList<Ability>) this.habilidades.clone();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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
    public Ability randomAbilitie(){  ///returns a random abilitie
        int random = (int)(Math.random()*habilidades.size());
        return habilidades.get(random);
    }
    public static int escaladodmg(int dato) {
        dato = dato + 3;
        return dato;
    }
    public static int escaladovida(int dato) {
        dato = dato + 5;
        return dato;
    }

    public static Pokemon Evolucion(Pokemon pokemon){
        Pokemon evolucion=JsonController.PokemonByID(pokemon.idEvolution);
        Pokemon.Balanceo(evolucion);
        return evolucion;
    }
    public static Pokemon levelup(Pokemon pokemon) {
        for (int i = 0; i < pokemon.habilidades.size(); i++) {
            pokemon.habilidades.get(i).setDamage(escaladodmg(pokemon.habilidades.get(i).getDamage()));
        }
        pokemon.setMaxLife(escaladovida(pokemon.getMaxLife()));
        pokemon.setLevel(pokemon.getLevel()+1);
        if(pokemon.getLevel()==20){
            if((Integer)pokemon.getIdEvolution()!=null){
                pokemon=Pokemon.Evolucion(pokemon);
            }
        }
        return pokemon;
    }
    public static void Balanceo(Pokemon pokemon){
        for (int i=1;i<=pokemon.getLevel();i++){
            for (int j = 0; j< pokemon.habilidades.size(); j++) {
                pokemon.habilidades.get(j).setDamage(escaladodmg(pokemon.habilidades.get(j).getDamage()));
            }
            pokemon.setMaxLife(escaladovida(pokemon.getMaxLife()));
        }
        pokemon.setCurrentLife(pokemon.getMaxLife());
    }
    public Ability getAbilitieById(int id){
        return habilidades.get(id);
    }

    @Override
    public boolean equals(Object obj) {
        boolean response = false;
        if (obj != null)
        {
            if (obj instanceof Pokemon)
            {
                Pokemon aux = (Pokemon) obj;
                if (getId() == aux.getId())
                {
                    response = true;
                }
            }
        }
        return response;
    }


    public void agregarArrayListTipo(String tipo){
        tipos.add(tipo);
    }
    public void addAbility(Ability habilidad){
        habilidades.add(habilidad);
    }

    public String getPokemonData ()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + '\n');
        sb.append(" Nivel: " + getLevel() + '\n');
        sb.append(" Tipos: " + '\n');
        sb.append(getTipos());
        sb.append(" Habilidades: " + '\n');
        sb.append(getStringHabilidades());
        return sb.toString();
    }

    public String getTipos ()
    {
        StringBuilder sb = new StringBuilder();
        for (String data : tipos)
        {
            sb.append("     " + data + '\n');
        }
        return sb.toString();
    }

    public String getStringHabilidades ()
    {
        StringBuilder sb = new StringBuilder();
        for (Ability data : habilidades)
        {
            sb.append("     " + data.getName() + '\n');
            sb.append("         Dano: " + data.getDamage() + '\n');
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", tipos=" + tipos +
                ", habilidades=" + habilidades +
                ", id=" + id +
                ", nivel=" + level +
                ", id_evolution=" + idEvolution +
                ", currentLife=" + currentLife +
                ", isAlive="+isAlive+
                '}';
    }
    public String getHabilidadString(int opcion){
        return habilidades.get(opcion).toString();
    }

    public Ability getHabilidad(int opcion){
        return habilidades.get(opcion);
    }

    public static int peleaPokemon(int dmg,Pokemon atacado){
        atacado.setCurrentLife(atacado.getCurrentLife()-dmg);
        return atacado.getCurrentLife();
    }
}
