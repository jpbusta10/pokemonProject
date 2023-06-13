package Controllers;
import model.Game;
public class FrontController {
    private Game myGame;

    public FrontController() {

    }

    public void NewGame(String name){
        this.myGame = new Game();
    }
}
