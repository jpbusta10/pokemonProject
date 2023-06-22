import Controllers.ApiController;
import Controllers.FrontController;
import Controllers.JsonController;
import model.Pokemon;
import model.biomes.Biome;


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
        System.out.println("1.nuevo juego");
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
            System.out.println("9. salir");
            int option = 0;
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    menuCazarPokemones();
                    break;
                case 2:
                    menuCampeonato();
                    break;
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
            System.out.println("1: VOLCAN");
            System.out.println("2: PLAYA");
            System.out.println("3: MONTANA");
            System.out.println("4: CUEVA");
            System.out.println("5: BOSQUE");
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
            System.out.println("1: Capturar el pokemon");
            System.out.println("2: Continuar Explorando");
            System.out.println("3: Salir");
            opcion = keyboard.nextInt();
            switch (opcion){
                case 1:
                    System.out.println(FrontController.catchpokemon());
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
        System.out.println(FrontController.getPokemonSalvaje());
        System.out.println("Empiezas tu\n");
        System.out.println("Que Pokemon deseas usar?\n");
        System.out.println(FrontController.getMyPokemons());
        System.out.println("PRECIONA 0/1/2 PARA ELEGIR EL POKEMON RESPECTIVAMENTE");
        opcion = keyboard.nextInt();
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
}