import greenfoot.*;
/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Enemy{
    private static final String IMAGE_PREFIX = "Zombie\\Zombie_";
    private static final int SPEED = 1;

    public void act(){
        switchImage();
        randomMove();
    }

    public Zombie(){
        super();
    }

    @Override
    public void switchImage() {
        setImage(new GreenfootImage(buildStringPath(IMAGE_PREFIX)));
        updateSwitchingImgCounter();
    }

    @Override
    public void randomMove() {
        super.randomMove();
    }
}
