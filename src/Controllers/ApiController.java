package Controllers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ApiController {
    public static String getPokemonRandom(String tipo){
        try{
            URL url= new URL("http://localhost:3000/pokemons/random/"+tipo);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responsecode = connection.getResponseCode();
            if(responsecode!=200){
                throw new RuntimeException("Codigo de error"+responsecode);
            }
            else {
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext())
                {
                    stringBuilder.append(scanner.nextLine());
                }
                scanner.close();
                return stringBuilder.toString();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return "";
    }
    public static String getAllPokemon(){
        try{
            URL url= new URL("http://localhost:3000/pokemons");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responsecode = connection.getResponseCode();
            if(responsecode!=200){
                throw new RuntimeException("Codigo de error"+responsecode);
            }
            else {
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext())
                {
                    stringBuilder.append(scanner.nextLine());
                }
                scanner.close();
                return stringBuilder.toString();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return "";
    }
    public static String getPokemonById(int id){
        try{
            URL url= new URL("http://localhost:3000/pokemons/"+id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responsecode = connection.getResponseCode();
            System.out.println(responsecode+"codigo respuesta");
            if(responsecode!=200){
                throw new RuntimeException("Codigo de error"+responsecode);
            }
            else {
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext())
                {
                    stringBuilder.append(scanner.nextLine());
                }
                scanner.close();
                return stringBuilder.toString();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}
