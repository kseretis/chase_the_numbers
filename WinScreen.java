import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The winning screen
 * 
 * @author Seretis Kleanthis 
 * @version 24/04/2022
 */
public class WinScreen extends Screen{
    // Constructor
    public WinScreen(){    
        super();
        Timer.restartTimer();
        Level.restartLevels();
    }
    // Act
    public void act(){
        if(Greenfoot.isKeyDown("space"))
            Greenfoot.setWorld(new Level());
        //TODO restart conmponets
    }
}
