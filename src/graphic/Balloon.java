package graphic;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */

import org.newdawn.slick.*;

/**
 * Balloon Sprite, Player of the game
 */
public class Balloon extends SceneObject{

    /*speed of balloon*/
    private float loonspeed = 0;

    /*game time*/
    private float gameTime = 0.0f;

    protected int fuel = 1000;

    public Balloon() throws SlickException {
        super("data/image/balloon.png", true);
    }

    public Balloon(float x, float y) throws SlickException {
        super(x, y, "data/image/balloon.png", false);
    }


    /**reset the ballon to coordinates
     *
     * @param x     reset balloon x coordinate
     * @param y     reset balloon y coordinate
     */
    public void reset(float x, float y) {
        this.x = x;
        this.y = y;
        loonspeed = 0;
    }

    /** set the y-speed of the balloon
     *
     * @param speed the desired y-speed
     */
    public void setSpeed(float speed){
        loonspeed = speed;
    }

    /**get the speed of balloon
     *
     * @return returns a float of the balloons y-speed
     */
    public float getSpeed(){
        return loonspeed;
    }

    /**move the balloon
     *
     * @param offsetX  the amount you want to move the balloons x-coordinate
     * @param offsetY  the amount you want to move the balloons y-coordinate
     */
    public void move(float offsetX, float offsetY){
        x += offsetX;
        y += offsetY;
    }

    /**render the balloon
     *
     */
    public void render(){
        image.drawCentered(x, y);
    }

    /**print the stats of balloon for error checking
     *
     * @param g     Graphics object
     * @param x     x-coordinate you want to print the stats
     * @param y     y-coordinate you want to print the stats
     */
    public void printStats(Graphics g, int x, int y) {
        g.drawString("Balloon X: " + getX(), x, y);
        g.drawString("Balloon Y: " + getY(), x, y+20);
        g.drawString("Speed: " + getSpeed(), x, y+40);

    }

    /**update the balloon
     *
     * @param gameContainer     the game container
     * @param delta             delta
     */
    @Override
    public void update(GameContainer gameContainer, int delta){
        float deltaTime = delta / 1000.0f;
        gameTime += deltaTime;
        Input input = gameContainer.getInput();
        updatePlayer(deltaTime, input);
    }

    /**update the player based on inputs
     *
     * @param deltaTime     deltatime (delta / 1000)
     * @param input         Input object
     */
    private void updatePlayer(float deltaTime, Input input)
    {
        if ((input.isKeyDown(Input.KEY_SPACE) || input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) && fuel > 0)
        {
            fuel--;
            setSpeed(getSpeed() - (deltaTime * 500.0f));
            move(0.0f, getSpeed() * deltaTime);
        }
        else
        {
            setSpeed(getSpeed() + (deltaTime * 500.0f));
            move(0.0f, getSpeed() * deltaTime);
        }
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public void move(int delta) {}

    @Override
    public boolean isReadyForDisposal() {
        return false;
    }
}

