package Controllers;

import model.Ability;
import model.Ability;
import model.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonController {
    public static Pokemon RandomPokemon(String tipo){
        String respuesta= ApiController.getPokemonRandom(tipo);
        JSONObject poki= new JSONObject(respuesta);
        Pokemon nuevo= new Pokemon();
        nuevo.setName(poki.getString("name"));
        nuevo.setLevel(poki.getInt("level"));
        nuevo.setId(poki.getInt("id"));
        if(!poki.isNull("id_evolution")) {
            nuevo.setIdEvolution(poki.getInt("id_evolution"));
        }
        JSONArray skills= poki.getJSONArray("abilities");
        for (int i=0;i<skills.length();i++){
            Ability habilidad = new Ability(skills.getString(i),10);
            nuevo.agregarArrayListHabilidades(habilidad);
        }
        nuevo.agregarArrayListTipo(poki.getString("type1"));
        if(!poki.isNull("type2")){
            nuevo.agregarArrayListTipo(poki.getString("type2"));
        }
        return nuevo;
    }


}
