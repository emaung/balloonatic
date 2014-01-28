package graphic;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 23/01/14
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * This class represent a Background Image of the game.
 *
 * For creation of game characters, please use <code>Sprite</code>
 */
public class Background extends Sprite {


    public Background(float x, float y, String imagePath, String collisionImage, boolean collidable) throws SlickException {
        super(x, y, imagePath, collisionImage, collidable);
    }

    /**
     * Constructor
     * @param imagePath path to image of this Background
     * @throws SlickException
     */
    protected Background(String imagePath, boolean collidable) throws SlickException {
        super(imagePath,collidable);
    }

    /**
     * Contructor
     * @param x x position
     * @param y y position
     * @param imagePath path to image of this Background
     * @throws SlickException
     */
    protected Background(float x, float y, String imagePath, boolean collidable) throws SlickException {
        super(x, y, imagePath, collidable);
    }

    /**
     * //TODO
     */
    public void restToEnd(){
        //TODO
    }

    /*move the background*/
    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /*reset the background to appropriate position on screen*/
    public void resetToEnd() {
        this.x = 1400.0f;
        this.y = 0;
    }

    public void render() {
        image.draw(x, y);
    }

    @Override
    public void checkCollide(String name, float imagex, float imagey, Graphics g, Balloon balloon, int x, int y) {
        g.setColor(Color.black);
        g.drawOval(balloon.getX(), balloon.getY(), 2, 2);
        g.drawOval(balloon.getX(), balloon.getY()+50, 2, 2);
        g.drawOval(balloon.getX(), balloon.getY()-50, 2, 2);
        g.drawOval(balloon.getX()-30, balloon.getY()-20, 2, 2);
        g.drawOval(balloon.getX()+30, balloon.getY()-20, 2, 2);
        //g.drawString(name, x, y-20);
        //g.drawString(""+balloonColliding(balloon.getX(), balloon.getY(), (int)imagex, (int)imagey),x,y);


        if(balloonColliding(balloon.getX(), balloon.getY(), (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX(), balloon.getY()+50, (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX(), balloon.getY()-50, (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX()-30, balloon.getY()-20, (int)imagex, (int)imagey).equals("255, 0, 0") ||
                balloonColliding(balloon.getX()+30, balloon.getY()-20, (int)imagex, (int)imagey).equals("255, 0, 0")) collider = true;


        else collider = false;
    }

    /**checks to see the colour of the pixel associated with coordinates - used for collisions
     *
     * @param bx    the x coordinate of the pixel you want to check
     * @param by    the y coordinate of the pixel you want to check
     * @param imagex the images x coordinate you want to check against the collision image
     * @param imagey the images y coordinate you want to check against the collision image
     * @return  a string of the rgb value of the pixel, eg "255, 255, 255"
     */
    public String balloonColliding(float bx, float by, int imagex, int imagey){

        if(by <= 0) return "0, 0, 0";
        String rgb = "";
        rgb += collisionImage.getColor((int)bx-imagex, (int)by-imagey).getRed() + ", ";
        rgb += collisionImage.getColor((int)bx-imagex, (int)by-imagey).getGreen() + ", ";
        rgb += collisionImage.getColor((int)bx-imagex, (int)by-imagey).getBlue();

        return rgb;
    }
}
