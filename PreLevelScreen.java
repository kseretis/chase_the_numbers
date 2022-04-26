import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Screen is being appeared between the levels
 * 
 * @author Seretis Kleanthis 
 * @version 24/04/2022
 */
public class PreLevelScreen extends Screen{
    // Constructor
    public PreLevelScreen(){    
        super(); 
    }
    // Act
    public void act(){
        if(Greenfoot.isKeyDown("Enter"))
            Greenfoot.setWorld(new Level());
    }
}
