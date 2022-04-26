import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PreLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreLevelScreen extends Screen{
    /**
     * Constructor for objects of class PreLevel.
     * 
     */
    public PreLevelScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("Enter"))
            Greenfoot.setWorld(new Level());
    }
}
