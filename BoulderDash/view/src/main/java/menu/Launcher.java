package menu;

import menu.Game;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class Launcher {
    public static void main(String[] args){
         Game game = new Game("Boulder Dash", 1152,832);
         game.start();
         new sound(100000,1);

    }
}
