import greenfoot.*;
/**
 * It's an Enemy based instance
 * 
 * @author Seretis Kleanthis  
 * @version 2
 * @date 8/6/2022
 */
public class Zombie extends Enemy{
    private static final String IMAGE_PREFIX = "Zombie\\Zombie_";
    private static final int SPEED = 1;
    /**
     * Constructor for objects of class Zombie
     */
    public Zombie(int random){
        super(random);
    }
    // act
    public void act(){
        switchImage(IMAGE_PREFIX);
        randomMove(SPEED);
    }   
}
