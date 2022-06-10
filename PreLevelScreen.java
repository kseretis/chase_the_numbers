import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Screen is being appeared between the levels
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 8/6/2022
 */
public class PreLevelScreen extends Screen{
    /**
     * Constructor for objects of class PreLevelScreen
     */
    public PreLevelScreen(){    
        super(); 
    }
    // Act
    public void act(){
        checkKeyDown(new Level());
    }
}
