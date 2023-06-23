import Controllers.ApiController;
import Controllers.FrontController;
import Controllers.JsonController;
import model.Pokemon;
import model.biomes.Biome;
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
        boolean checkArchivo = false;
        System.out.println("1.nuevo juego");
        System.out.println("2.cargar juego");
        System.out.println("9.salir");
        option = keyboard.nextInt();
        switch (option) {
            case 1:
                newGameMenu();
                break;
            case 2:
                checkArchivo = FrontController.loadGame();
                if(checkArchivo) {
                    menuJuego();
                }
                else{
                    System.out.println("no hay archivo");
                }
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
            System.out.println("5. Guardar partida");
            System.out.println("9. Salir");
            int option = 0;
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    menuCazarPokemones();
                    break;
                case 2:
                    menuCampeonato();
                    break;
                case 3:
                    menuPokemon();
                    break;
                case 4:
                    menuAlmacenamiento();
                    break;
                case 5:
                   FrontController.saveGame();
                case 9:
                    seguir = false;
                    initialMenu();
                    break;
            }
        }
    }
    static void menuCampeonato() {
        keyboard = new Scanner(System.in);
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        int option = 0;
        boolean seguir = true;
        while (seguir == true) {
            System.out.println("1. ver tu progreso");
            System.out.println("2. continuar el campeonato");
            System.out.println("9. salir");
            option = keyboard.nextInt();
            switch (option) {
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
                    break;
            }
        }
    }
    static void gimnacio() {
        keyboard = new Scanner(System.in);
        int option = 0;
        boolean seguir = true;
        System.out.println("estas en " + FrontController.getTodoGymName());
        seguir = menuPeleaCampeonato();
        if(seguir == true){
            System.out.println("felicidades a vencido el gimnacio de "+FrontController.getTodoGymName());
            FrontController.setFinishedGym();
        }
        else if(seguir == false){
            System.out.println("perdiste, vas a tener que volver a intentarlo");
        }
        FrontController.resetUser();
    }

    static boolean menuPeleaCampeonato() {
        boolean rta = true;
        int idPokemon;
        String pokemonTrainer;
        keyboard = new Scanner(System.in);
        String nombreTrainer = FrontController.getToDoTrainerName();
        System.out.println("estas pelendo contra " + nombreTrainer);
        System.out.println(nombreTrainer + " va a iniciar la pelea");
        System.out.println("elija que pokemon desea utilizar");
        System.out.println(FrontController.getMyPokemons());
        idPokemon = keyboard.nextInt();
        pokemonTrainer = FrontController.chooceRandomAlivePokemom();
        System.out.println(nombreTrainer + " a elegido a " + pokemonTrainer);
        while(FrontController.checkIfAbailablePokemonsUser() && FrontController.checkIfAbailablePokemonsTrainer()) {
            while (FrontController.checkIfAliveUser(idPokemon) && FrontController.checkIfAliveTrainer(pokemonTrainer)) {
                ataquePokemonTrainer(idPokemon, pokemonTrainer, FrontController.getTodoGymName());
                System.out.println("presione cualquier tecla para continuar");
                keyboard.nextLine();
                keyboard.nextLine();
                if (FrontController.checkIfAliveUser(idPokemon)) {
                    ataqueUserTrainer(idPokemon, pokemonTrainer, FrontController.getTodoGymName());
                }
                System.out.println("presione cualquier tecla para continuar");
                keyboard.nextLine();
                keyboard.nextLine();
            }
            if (!FrontController.checkIfAliveUser(idPokemon) && FrontController.checkIfAbailablePokemonsUser()) {
                System.out.println("tiene que seleccionar otro pokemon");
                System.out.println(FrontController.getMyPokemons());
                idPokemon = keyboard.nextInt();
            }
            if (!FrontController.checkIfAliveTrainer(pokemonTrainer) && FrontController.checkIfAbailablePokemonsTrainer()) {
                pokemonTrainer = FrontController.chooceRandomAlivePokemom();
                if (pokemonTrainer != null) {
                    System.out.println(nombreTrainer + "a cambiado a " + pokemonTrainer);
                }
            }
        }
        if(FrontController.checkIfAbailablePokemonsUser()){

            return true;
        }
        else{
            return false;
        }
    }

    /**
     * ataque del trainer al pokemon del usuario
     * @param idPokemon
     * @param nombrePokemonTrainer
     * @param gymName
     */
    static void ataquePokemonTrainer(int idPokemon, String nombrePokemonTrainer, String gymName) {
        String res = FrontController.attackFromTrainer(idPokemon, nombrePokemonTrainer, gymName);
        if (res == null) {
            System.out.println(FrontController.getUserPokemonNameByid(idPokemon) + " murio");
        }
        else System.out.println(res);
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
            if(option >= 1 && option <= FrontController.getActualSquadSize())
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
                    if (FrontController.getActualSquadSize() == 1)
                    {
                        System.out.println("No puedes almacenar el unico pokemon del equipo");
                    }
                    else
                    {
                        FrontController.addPokemonToStorage(indexOfPokemon);
                    }
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

    /**
     * ataque del usuario al pokemon del trainer
     * @param idPokemon
     * @param nombrePokemonTrainer
     * @param gymName
     */
    static void ataqueUserTrainer(int idPokemon, String nombrePokemonTrainer, String gymName){
        keyboard = new Scanner(System.in);
        int abilitieId;
        System.out.println("Elija la habilidad que quiera utilizar: ");
        System.out.println(FrontController.getPokemonAbilities(idPokemon));
        abilitieId = keyboard.nextInt();
        String res = FrontController.attackFromUserToTrainer(idPokemon, nombrePokemonTrainer, gymName, abilitieId);
        if(res == null){
            System.out.println(nombrePokemonTrainer+ " de "+FrontController.getToDoTrainerName()+" murio");
        }
        else{
            System.out.println(res);
        }
    }

    static void menuCazarPokemones(){
        keyboard = new Scanner(System.in);
        boolean continuar=true;
        int opcion;
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        for (int i=0;i<4;i++){
            System.out.println("\n");
        }
        while(continuar==true) {
            System.out.println("||||||||||||||||||||||||||||||||||||||");
            System.out.println("Que bioma deseas explorar?");
            System.out.println("||||||||||||||||||||||||||||||||||||||");
            System.out.println("OPCIONES:");
            System.out.println("1. VOLCAN");
            System.out.println("2. PLAYA");
            System.out.println("3. MONTANA");
            System.out.println("4. CUEVA");
            System.out.println("5. BOSQUE");
            opcion = keyboard.nextInt();
            FrontController.logicaCazarPokemones(opcion);
            menuPeleaExploration();
            keyboard.nextLine();
            keyboard.nextLine();
            for (int i = 0; i < 4; i++) {
                System.out.println("\n");
            }
            System.out.println("Que desea hacer:\n");
            System.out.println("OPCIONES:");
            System.out.println("\n");
            System.out.println("1. Capturar el pokemon");
            System.out.println("2. Continuar Explorando");
            System.out.println("3. Salir");
            opcion = keyboard.nextInt();
            switch (opcion){
                case 1:
                    System.out.println(FrontController.catchPokemon());
                    continuar=false;
                    break;
                case 2:
                    break;
                case 3:
                    continuar=false;
                    break;
            }
        }
    }


    static void menuPeleaExploration() {
        keyboard = new Scanner(System.in);
        int opcion, habilidad;
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        for (int i = 0; i < 10; i++) {
            System.out.println("\n");
        }
        System.out.println("|||||||||||||||||||COMIENZA EL COMBATE|||||||||||||||||||");
        System.out.println("Has encontrado un: "+FrontController.getPokemonSalvaje());
        System.out.println("Empiezas tu\n");
        System.out.println("Que Pokemon deseas usar?\n");
        System.out.println(FrontController.getMyPokemons());
        System.out.println("PRECIONA 0/1/2 PARA ELEGIR EL POKEMON RESPECTIVAMENTE");
        opcion = keyboard.nextInt();
        FrontController.balancear(opcion);
        for (int i = 0; i < 4; i++) {
            System.out.println("\n");
        }
        while(FrontController.chequeadorDeVidaRival()==true) {
            System.out.println(FrontController.safeUserPokemonReturn(opcion));
            System.out.println("Que habilidad deseas utilizar: \n");
            System.out.println(FrontController.getPokemonAbilities(opcion));
            System.out.println("PRECIONA 0/1 PARA ELEGIR LA HABILIDAD RESPECTIVAMENTE");
            habilidad = keyboard.nextInt();
            System.out.println("utilizaste: " + FrontController.safePokemonAbiliti(opcion, habilidad));
            System.out.println(FrontController.logicaPeleaExploration(opcion, habilidad));
            if(FrontController.chequeadorDeVidaRival()==true&&FrontController.chequeadorDeVidaPropia(opcion)==true) {
                System.out.println("Es el turno del rival\n");
                System.out.println(FrontController.getPokemonSalvaje() + " Utilizo: " + FrontController.safePokemonAbilitiRival(0, 0));
                System.out.println(FrontController.logicaPeleaExplorationInversa(opcion));
            }
        }
        System.out.println("|||||||||||||||||||  GANASTE!  |||||||||||||||||||");

    }
    static void menuSwap (int indexOfPokemon)
    {
        int swap = 0;
        keyboard = new Scanner(System.in);
        System.out.println("presione cualquier tecla para continuar");
        keyboard.nextLine();
        if (FrontController.getActualSquadSize() == 1)
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
            } while (((swap < 1 || swap > FrontController.getActualSquadSize()) || swap == indexOfPokemon + 1) && swap != 9);
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

    static void menuAlmacenamiento ()
    {
        int option = 0;
        if (FrontController.storageSize() == 0)
        {
            System.out.println("No hay ningun pokemon en el almacenamiento");
        }
        else {
            while(option != 9) {
                System.out.println("Puede elegir un pokemon si desea hacer un cambio");
                System.out.println(FrontController.storageView());
                System.out.println("9. salir");
                option = keyboard.nextInt();
                if(option >= 1 && option <= FrontController.storageSize())
                {
                    menuAccionesAlmacenamiento(option - 1);
                }
                else if (option != 9)
                {
                    System.out.println("La opcion ingresada no existe.");
                }
            }
            System.out.println(FrontController.storageView());

        }
    }

    static void menuAccionesAlmacenamiento (int indexPokemon)
    {
        int option = 0;
        while (option != 9)
        {
            System.out.println("1. Ver datos del pokemon");
            System.out.println("2. Agregar al squad");
            System.out.println("9. Salir");
            option = keyboard.nextInt();
            switch (option)
            {
                case 1:
                    FrontController.getPokemonDataStorage(indexPokemon);
                    break;
                case 2:
                    FrontController.addPokemonToSquad(indexPokemon);
                    break;
                case 9:
                    System.out.println("Saliendo");
                    break;
            }
        }
    }
}