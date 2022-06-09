import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class holds the live system implementation
 * 
 * @author Seretis Kleanthis    
 * @version 1
 * @date 9/6/2022
 */
public class Live extends Actor{
    private static final String FULL_HEART = "heart";
    private static final String EMPTY_HEART = "empty_heart";
    private static final String SUFFIX = ".png";
    private boolean isFull;
    /**
     * Constructor for objects of class Live
     */
    public Live(){
        this.isFull = true;
    }
    // act
    public void act(){
        setImage(getHeartStatus());
        getImage().scale(60, 60);
    }
    // Full or empty live getter
    public boolean isFull(){
        return isFull;
    }
    // Full or empty live setter
    public void setIsFull(boolean isFull){
        this.isFull = isFull;
    }
    // String getter for applying the image 
    private String getHeartStatus(){
        return isFull() ? FULL_HEART + SUFFIX : EMPTY_HEART + SUFFIX;
    }
}
