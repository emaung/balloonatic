package graphic;

/**
 * User: Tin Htoo Aung
 * Date: 23/01/14
 * Time: 3:02 PM
 */

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * This is an abstract class for sprites. For backgrounds please use <code>Background</code> instead.
 */
public abstract class Sprite {

    /**
     * Position of Sprite on x coordinate
     */
    protected float x;

    /**
     * Position of Sprite on y coordinate
     */
    protected float y;

    /**
     * Image reference to render this
     */
    protected Image image;

    /**
     * Current scale of this
     */
    protected float scale;

    /**
     * Can a player collide with this object.
     */
    protected boolean isCollidable;


    /**
     * Constructor
     * @param imagePath path to sprite image
     * @throws SlickException
     */
    protected Sprite(String imagePath, boolean collidable) throws SlickException {
        this.image = new Image(imagePath);
        this.x = 0;
        this.y = 0;
        this.isCollidable = collidable;
    }

    /**
     * Contructor
     * @param x Position of Sprite on x coordinate
     * @param y Position of Sprite on y coordinate
     * @param imagePath Path to image to render as Sprite
     * @throws SlickException
     */
    protected Sprite(float x, float y, String imagePath, boolean collidable) throws SlickException {
        this.x = x;
        this.y = y;
        this.image = new Image(imagePath);
    }

    /**
     * Get position of Sprite on x coordinate
     * @return position of Sprite on x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Set position of Sprite on x coordinate
     * @param x position of Sprite on x coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get position of Sprite on y coordinate
     * @return position of Sprite on y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * Set position of Sprite on y coordinate
     * @param y position of Sprite on y coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Get <code>Image</code> reference of this
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     * Render sprite on screen
     * @param graphics graphics object attached to current scene
     */
<<<<<<< HEAD
    public void render(Graphics graphics){
        image.drawCentered(x, y);
=======
    public void render(GameContainer gc, Graphics graphics){
        image.draw(x, y);
>>>>>>> 70a1f06005447c8b3479380e47712e1562744bf8
    }

    /**
     * Get scale of this sprite
     * @return scale of this sprite
     */
    public float getScale() {
        return scale;
    }

    /**
     * Set scale of this sprite
     * @param scale scale of this sprite
     */
    public void setScale(float scale) {
        image = image.getScaledCopy(scale);
        this.scale = scale;
    }

    public void update(int delta){}
}
