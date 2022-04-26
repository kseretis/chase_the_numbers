import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The screen that is being appeard when you lose
 * 
 * @author Seretis Kleanthis 
 * @version 24/04/2022
 */
public class GameOverScreen extends Screen{
    // Constructor
    public GameOverScreen(){    
        super(); 
        Timer.restartTimer();
        Level.restartLevels();
    }
    // Act
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new Level());
        }  
    }
}
