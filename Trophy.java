import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class created for the trophies
 * 
 * @author Seretis Kleanthis 
 * @version 24/04/2022
 */
public class Trophy extends SmoothMover{
    private int movingCounter = 0;
    // Act
    public void act(){
        if(Level.getLevel() == 2)
            randomMove();
    }
    // Random move
    public void randomMove(){
        if(movingCounter < 100)
            setLocation(getX() + 1, getY());
        else if(movingCounter < 200)
            setLocation(getX() - 1, getY());
        else
            movingCounter = 0;
        movingCounter++;
    }
    // Touching a sand object
    public boolean isTouchingSand(){
        return isTouching(Sand.class) ? true : false;
    }
}
