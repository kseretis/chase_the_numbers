import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The initial screen of the game
 * 
 * @author Seretis Kleanthis 
 * @version 24/04/2022
 */
public class InitialScreen extends Screen{
    // Constructor
    public InitialScreen(){    
        super(); 
    }
    // Act
    public void act(){
        if(Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new Level());
    }
}
