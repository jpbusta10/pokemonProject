import Controllers.ApiController;
import Controllers.FrontController;
import model.Pokemon;


import java.util.Scanner;

import static Controllers.JsonController.RandomPokemon;

public class Main {
    static Scanner keyboard;
    public static void main(String[] args) {
        initialMenu();

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
                newGame();
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
        boolean rta = true;
        keyboard = new Scanner(System.in);
        String name = new String("");
        int option = 0;
        System.out.println("ingrese el nombre de su personaje");
        name = keyboard.nextLine();
        FrontController.NewGame(name);
        System.out.println("felicitaciones ah iniciado su aventura \nel profesor Samuel Oak le dara a elegir uno de estos Pokemon");
        System.out.println("1. Pikachu");
        System.out.println("2. Charmander");
        System.out.println("3. bulbasaur");
        System.out.println("4. squirtle");
        option = keyboard.nextInt();
        switch (option){
            case 1:
                FrontController.addPokemonToUserByid(25);
                break;
            case 2:
                FrontController.addPokemonToUserByid(4);
                break;
            case 3:
                FrontController.addPokemonToUserByid(1);
                break;
            case 4:
                FrontController.addPokemonToUserByid(7);
                break;
        }
        rta = menuJuego();

        return rta;

    }
    static boolean menuJuego(){
        keyboard = new Scanner(System.in);
        boolean rta =true;
        while(rta == false) {
            System.out.println("que desea hacer ahora");
            System.out.println("1.cazar pokemon");
            System.out.println("2. campeonato");
            System.out.println("3. salir");
            int option = 0;
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    // menu cazar
                    break;
                case 2:
                    //menu campeonato
                    break;
                case 3:
                    rta = false;
                    break;

            }
        }
        return rta;
    }



}