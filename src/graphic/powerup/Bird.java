package graphic.powerup;

import graphic.Balloon;
import org.newdawn.slick.*;
import org.newdawn.slick.Sound;

/**
 * Created with IntelliJ IDEA.
 * User: user360
 * Date: 3/02/14
 * Time: 12:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bird extends Powerup{
    Animation bird;
    Image[] birdimages;

    private Sound death, birdsound;

    public Bird() throws SlickException {
        super("data/image/goldbird.png");
        birdimages = new Image[]{ new Image("data/image/bird1.png"), new Image("data/image/bird2.png") };
        bird = new Animation(birdimages,50);
        death = new Sound("data/sound/effects/gameover1.wav");
        birdsound = new Sound("data/sound/effects/bird_screech.ogg");
    }

    public Bird(String imagePath) throws SlickException {
        super(imagePath);
    }

    public Bird(float x, float y, String imagePath) throws SlickException {
        super(x, y, imagePath);
    }

    @Override
    public void onCollideWithBalloon(Balloon balloon) {
        sceneHandler.removeSceneObject(this);
        //balloon.setLives(balloon.getLives() - 1);
        balloon.setFuel(balloon.getFuel() - 100);
        balloon.setFlashRate(120);
        balloon.setFlashed(true); death.play(); birdsound.play();
    }
    @Override
    public void move(int delta) {
        x += delta/1000 - 14;
    }



    @Override
    public void render(GameContainer gc, Graphics graphics){
        bird.draw(x - 20, y - 20);
    }
}