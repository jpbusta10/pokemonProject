import Controllers.ApiController;
import Controllers.FrontController;
import model.Pokemon;
import model.character.User;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

import static Controllers.JsonController.RandomPokemon;

public class Main {
    static Scanner keyboard;

    public static void main(String[] args) {
    initialMenu();

    }

    static boolean initialMenu() {
        keyboard = new Scanner(System.in);
        int option = 0;
        boolean rta = true;
        System.out.println("1. nuevo juego");
        System.out.println("2.cargar juego");
        System.out.println("9.salir");
        option = keyboard.nextInt();
        switch (option) {
            case 1:
                newGameMenu();
                break;
            case 2:
                //carga juego
                break;
            case 9:
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
                FrontController.addPokemonToUserByid(4);
                FrontController.addPokemonToUserByid(1);
                FrontController.addPokemonToUserByid(7);
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
            System.out.println("1. cazar pokemon");
            System.out.println("2. campeonato");
            System.out.println("3. pokemon");
            System.out.println("4. ver almacenamiento pokemon");
            System.out.println("9. salir");
            int option = 0;
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    // menu cazar
                    break;
                case 2:
                    menuCampeonato();
                    break;
                case 3:
                    menuPokemon();
                    break;
                case 4:
                    if (FrontController.storageSize() == 0)
                    {
                        System.out.println("No hay ningun pokemon en el almacenamiento");
                    }
                    else {
                        System.out.println(FrontController.storageView());
                    }
                    break;
                case 9:
                    seguir = false;
                    initialMenu();
                    break;

            }
        }

    }
    static  void menuCampeonato(){
        keyboard = new Scanner(System.in);
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        int option = 0;
        boolean seguir = true;
        while(seguir == true){
            System.out.println("1. ver tu progreso");
            System.out.println("2. continuar el campeonato");
            System.out.println("9. salir");
           option = keyboard.nextInt();
            switch(option){
                case 1:
                    System.out.println("Not finished gyms: ");
                    System.out.println(FrontController.getFinishedGymsNames());
                    System.out.println("presione cualquier tecla para continuar");
                    keyboard.nextLine();
                    break;
                case 2:
                    gimnacio();
                    break;
                case 9:
                    seguir = false;
            }


        }

    }
    static void gimnacio(){
        keyboard = new Scanner(System.in);
        int option = 0;
        boolean seguir = true;
        while(seguir == true){
            System.out.println("estas en " + FrontController.getTodoGymName());

        }
    }

    static void menuPokemon (){
        keyboard = new Scanner(System.in);
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        int option = 0;
        while(option != 9) {
            System.out.println("Elija un pokemon para continuar");
            System.out.println(FrontController.getSquad());
            System.out.println("9. salir");
            option = keyboard.nextInt();
            if(option >= 1 && option <= FrontController.getSquadSize())
            {
                menuAcciones(option - 1);
            }
            else if (option != 9)
            {
                System.out.println("La opcion ingresada no existe.");
            }
        }
    }

    static void menuAcciones (int indexOfPokemon)
    {
        keyboard = new Scanner(System.in);
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        int option = 0;
        while (option != 9)
        {
            System.out.println("que desea hacer");
            System.out.println("1. Ver datos del pokemon");
            System.out.println("2. Cambiar posicion en el equipo");
            System.out.println("3. Cambiar con un pokemon del almacenamiento");
            System.out.println("4. Almacenar pokemon");
            System.out.println("9. Salir");
            option = keyboard.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println(FrontController.getPokemonData(indexOfPokemon));
                    break;
                case 2:
                    menuSwap(indexOfPokemon);
                    option = 9;
                    break;
                case 3:
                    menuSwitch(indexOfPokemon);
                    option = 9;
                    break;
                case 4:
                    FrontController.addPokemonToStorage(indexOfPokemon);
                    option = 9;
                    break;
                case 9:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion fuera de rango");
            }
        }
    }

    static void menuSwap (int indexOfPokemon)
    {
        int swap = 0;
        keyboard = new Scanner(System.in);
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        if (FrontController.getSquadSize() == 1)
        {
            System.out.println("Solo tienes un pokemon en el equipo");
        }
        else {
            do //Va a repetir mientras que swap no se encuentre entre el rango de opciones y sea igual al indice del pokemon que quiero cambiar
            {
                System.out.println("Ingrese la posicion en la que lo quiere ubicar");
                System.out.println("La posicion debe estar dentro del rango disponible y no puede ser la misma del pokemon que se quiere cambiar");
                System.out.println(FrontController.getSquad());
                System.out.println("9. Salir");
                swap = keyboard.nextInt();
            } while (((swap < 1 || swap > FrontController.getSquadSize()) || swap == indexOfPokemon + 1) && swap != 9);
            if (swap != 9)
            {
                FrontController.swapPokemon(swap - 1, indexOfPokemon);
                System.out.println("El equipo quedo de la siguiente manera");
                System.out.println(FrontController.getSquad());
            }
            else
            {
                System.out.println("Saliendo");
            }
        }
    }

    static void menuSwitch (int indexOfPokemon)
    {
        int swap = 0;
        keyboard = new Scanner(System.in);
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        if (FrontController.storageSize() == 0)
        {
            System.out.println("No hay ningun pokemon en el almacenamiento");
        }
        else
        {
            do
            {
                System.out.println("Ingrese el numero del pokemon a cambiar");
                System.out.println("La posicion debe estar dentro del rango disponible");
                System.out.println(FrontController.storageView());
                System.out.println("9. Salir");
                swap = keyboard.nextInt();
            }while ((swap < 1 || swap > FrontController.storageSize()) && swap != 9);
            if (swap != 9)
            {
                FrontController.switchPokemon(swap-1, indexOfPokemon);
                System.out.println("El equipo quedo de la siguiente manera");
                System.out.println(FrontController.getSquad());
            }
            else
            {
                System.out.println("Saliendo");
            }
        }
    }
}