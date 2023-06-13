import Controllers.ApiController;
import Controllers.FrontController;
import model.Pokemon;


import java.util.Scanner;

import static Controllers.JsonController.RandomPokemon;

public class Main {
    static Scanner keyboard;
    public static void main(String[] args) {


    }
    static boolean initialMenu(){
        keyboard = new Scanner(System.in);
        int option = 0;
        boolean rta = true;
        System.out.println("1. nuevo juego");
        System.out.println("2.cargar juego");
        System.out.println("3.salir");
        option = keyboard.nextInt();
        switch (option){
            case 1:
                //nuevo juego
                break;
            case 2:
                //carga juego
                break;
            case 3:
                rta = false;
                break;
        }
        return rta;
    }
    static boolean newGame(){
        keyboard = new Scanner(System.in);
        String name = new String("");
        int option = 0;
        System.out.println("ingrese el nombre de su personaje");
        name = keyboard.nextLine();
        FrontController frontController= new FrontController();
        frontController.NewGame(name);
        System.out.println("felicitaciones ah iniciado su aventura \nel profesor Samuel Oak le dara a elegir uno de estos Pokemon");
        System.out.println("1. Pikachu");
        System.out.println("2. Charmander");
        System.out.println("3. bulbasaur");
        System.out.println("4. squirtle");
        option = keyboard.nextInt();


    }
}