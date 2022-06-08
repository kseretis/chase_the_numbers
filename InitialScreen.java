import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The initial screen of the game
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 8/6/2022
 */
public class InitialScreen extends Screen{
    /**
     * Constructor for objects of class InitialScreen
     */
    public InitialScreen(){    
        super(); 
    }
    // Act
    public void act(){
        if(Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new Level());
    }
}
