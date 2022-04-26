import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends Screen
{

    /**
     * Constructor for objects of class GameOverScreen.
     * 
     */
    public GameOverScreen(){    
        super(); 
        Timer.restartTimer();
        Level.restartLevels();
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new Level());
        }
            
    }
}
