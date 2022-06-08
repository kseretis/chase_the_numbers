import greenfoot.*;
/**
 * It's an Enemy based instance
 * 
 * @author Seretis Kleanthis  
 * @version 2
 * @date 8/6/2022
 */
public class Robot extends Enemy{
    private static final String IMAGE_PREFIX = "Robot\\Robot_";
    private static final int SPEED = 3;

    public void act(){
        switchImage(IMAGE_PREFIX);
        randomMove(SPEED);
    }

    public Robot(int random){
        super(random);
    }
}
