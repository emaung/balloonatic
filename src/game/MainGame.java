package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * User: Tin Htoo Aung
 * Date: 14/01/14
 * Time: 1:25 PM
 */

/**
 * Starter class fo the game
 */
public class MainGame extends StateBasedGame {

    public MainGame() {
        super(Game.TITLE);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new MainState());
        enterState(0);
    }

    // Main entry point for the game, set up the app and its window etc
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new MainGame());
        app.setDisplayMode(Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT, false);
        app.setVSync(Game.VSYNC);
        app.setShowFPS(Game.DEBUG.SHOW_FPS);
        app.start();
    }
}
