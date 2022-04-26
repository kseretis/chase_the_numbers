import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends Screen{

    /**
     * Constructor for objects of class WinScreen.
     * 
     */
    public WinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super();
        Timer.restartTimer();
        Level.restartLevels();
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space"))
            Greenfoot.setWorld(new Level());
    }
}
