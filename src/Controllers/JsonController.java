package Controllers;

import model.Habilidad;
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
        nuevo.setNivel(poki.getInt("level"));
        nuevo.setId(poki.getInt("id"));
        if(!poki.isNull("id_evolution")) {
            nuevo.setId_evolucion(poki.getInt("id_evolution"));
        }
        JSONArray skills= poki.getJSONArray("abilities");
        for (int i=0;i<skills.length();i++){
            Habilidad habilidad = new Habilidad(skills.getString(i),10);
            nuevo.agregarArrayListHabilidades(habilidad);
        }
        nuevo.agregarArrayListTipo(poki.getString("type1"));
        if(!poki.isNull("type2")){
            nuevo.agregarArrayListTipo(poki.getString("type2"));
        }
        return nuevo;
    }


}
