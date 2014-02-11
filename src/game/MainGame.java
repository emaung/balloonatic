package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import util.GameFont;
import util.ScoreBoard;

/**
 * User: Tin Htoo Aung
 * Date: 14/01/14
 * Time: 1:25 PM
 */

/**
 * Starter class fo the game
 */
public class MainGame extends StateBasedGame {

    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    public MainGame() {
        super(Game.TITLE);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new MenuState());
        addState(new MainState());
        addState(new HighScoreState());
        addState(new EnterNameState());
        addState(new EnterCheatcodeState());
        addState(new SettingsState());
        enterState(Game.STATE.MENU);
    }

    // Main entry point for the game, set up the app and its window etc u
    public static void main(String[] args) throws SlickException {

        AppGameContainer app = new AppGameContainer(new MainGame());
        app.setDisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT, true);
        app.setVSync(Game.VSYNC);
        app.setFullscreen(false);
        //app.setShowFPS(Game.DEBUG.SHOW_FPS);
        app.start();
    }
}