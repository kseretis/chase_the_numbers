import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trophy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trophy extends SmoothMover{
    private static final int RANGE = 10;
    // public static int POINTS;
    private int movingCounter = 0;

    public void act(){
        if(Level.getLevel() == 2)
            randomMove();
    }
    
    public void randomMove(){
        if(movingCounter < 100)
            setLocation(getX() + 1, getY());
        else if(movingCounter < 200)
            setLocation(getX() - 1, getY());
        else
            movingCounter = 0;
        movingCounter++;
    }
    
    public boolean isTouchingSand(){
        return isTouching(Sand.class) ? true : false;
    }
}
