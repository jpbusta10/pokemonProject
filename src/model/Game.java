package model;

import model.biomes.Biome;

import java.util.Random;
import Controllers.JsonController;
import model.character.User;

public class Game {
    Biome forest = Biome.FOREST;
    Biome mountain = Biome.MOUNTAIN;
    Biome beach = Biome.BEACH;
    Biome cave = Biome.CAVE;
    Biome volcano = Biome.VOLCANO;
    private User myUser;
    private int idPokemon; ///actual id pokemon
    public Game (){
    }

    public Game(String name) {
        this.myUser = new User(name);
    }

    /**
     * depending of the biome it returns a ramdom pokemon with respective types
     * @param mybiome
     * @return Pokemon
     */
    public Pokemon Exploration(Biome mybiome){
            JsonController controller = new JsonController();
            Random random = new Random();
            int numeroAleatorio = random.nextInt(3) + 1;
            String tipo = mybiome.getTypes(numeroAleatorio);
            Pokemon nuevo = controller.RandomPokemon(tipo);
            nuevo.setIdPokedex(idPokemon + 1);
            idPokemon ++;
            return nuevo;
    }

}
