import greenfoot.*;
/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Enemy{
    private static final String IMAGE_PREFIX = "Robot\\Robot_";
    private static final int SPEED = 3;

    public void act(){
        switchImage();
        randomMove();
    }

    public Robot(int random){
        super(random);
    }

    @Override
    public void switchImage(){
        setImage(new GreenfootImage(buildStringPath(IMAGE_PREFIX)));
        updateSwitchingImgCounter();
    }
    
    public void randomMove(){
        super.randomMove(SPEED);
    }
}
