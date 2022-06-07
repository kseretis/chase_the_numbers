/**
 * This model has created to represent the instance of every single Enemy
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SmoothMover{
    private static final int SPEED = 2;
    //private static final String IMAGE_PREFIX = "Enemies\\Citizen_";
    private static final String IMAGE_FRONT = "front_";
    private static final String IMAGE_BACK = "back_";
    private static final String IMAGE_LEFT = "left_";
    private static final String IMAGE_RIGHT = "right_";
    private static final String IMAGE_SUFFIX = ".png";
    private int frontImgCounter = 0;
    private int backImgCounter = 0;
    private int leftImgCounter = 0;
    private int rightImgCounter = 0;

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(){
    }
}
