import Controllers.ApiController;
import Controllers.FrontController;
import Controllers.JsonController;
import model.Ability;
import model.Game;
import model.Pokemon;
import model.character.Character;


import java.util.Formatter;
import java.util.Scanner;

import static Controllers.JsonController.RandomPokemon;

public class Main {
    static Scanner keyboard;

    public static void main(String[] args) {

        Pokemon pikachu= JsonController.PokemonByID(25);
        System.out.println(pikachu.toString());
        System.out.println("///////////////");
        for(int i=0;i<10;i++){
            pikachu=Pokemon.levelup(pikachu);
        }
        System.out.println(pikachu.toString());

        /*Pokemon pikachu= JsonController.PokemonByID(25);
        System.out.println(pikachu.toString());
        System.out.println("///////////////");
        pikachu=Pokemon.Evolucion(pikachu);
        System.out.println(pikachu.toString());*/
    }

    static boolean initialMenu() {
        keyboard = new Scanner(System.in);
        int option = 0;
        boolean rta = true;
        System.out.println("1. nuevo juego");
        System.out.println("2.cargar juego");
        System.out.println("3.salir");
        option = keyboard.nextInt();
        switch (option) {
            case 1:
                newGameMenu();
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

    static void newGameMenu() {
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
        switch (option) {
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
        System.out.println("felicidades ya tiene su Pokemon");
        menuJuego();


    }

    static void menuJuego() {
        keyboard = new Scanner(System.in);
        System.out.println("presione caulquier tecla para continuar");
        keyboard.nextLine();
        boolean seguir = true;
        while (seguir == true) {
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
                    seguir = false;
                    initialMenu();
                    break;

            }
        }

    }
    static boolean menuPelea(){
        keyboard = new Scanner(System.in);
        int opcion=0;
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        for (int i=0;i<10;i++){
            System.out.println("\n");
        }
        System.out.println("|||||||||||||||||||COMIENZA EL COMBATE|||||||||||||||||||\n");
        System.out.println("\n");
        System.out.println(FrontController.getPokemonOponente());
        System.out.println("Empiezas tu\n");
        System.out.println("Que Pokemon deseas usar?\n");
        System.out.println(FrontController.listadepokemonesuser());
        opcion=keyboard.nextInt();
        System.out.println(FrontController.safeUserPokemonReturn(opcion));
        System.out.println("Que habilidad deseas utilizar: \n");
        opcion= keyboard.nextInt();


    }

}