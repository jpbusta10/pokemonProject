package Controllers;

import model.Game;

import java.io.*;

public class FileController {
    private static FileOutputStream fileOutputStream;
    private static ObjectOutputStream objectOutputStream;
    private static FileInputStream fileInputStream;
    private static ObjectInputStream objectInputStream;
    private static String fileName = "savedGame.bin";

    public static void saveGame(Game myGame){
        try{
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(myGame);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static Game loadGame(){
        Game mygame = null;
        try{
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            mygame = (Game) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return mygame;
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}
