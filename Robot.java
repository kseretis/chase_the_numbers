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
    private static final int SPEED = 2;
    /**
     * Constructor for objects of class Robot
     */
    public Robot(int random){
        super(random);
    }
    // act
    public void act(){
        switchImage(IMAGE_PREFIX);
        randomMove(SPEED);
    }
}
