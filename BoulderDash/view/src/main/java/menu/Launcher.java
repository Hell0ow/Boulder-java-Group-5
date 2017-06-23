package menu;

import menu.Game;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class Launcher {
	
    public static void runMenu(){
         Game game = new Game("Boulder Dash", 1152,832);
         game.start();
         Sound.music("D:/CESI année 1/Projet/Java/Sound/Boulder_Dash_Theme.wav", 100000, 3);
    }
}
