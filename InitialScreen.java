import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialScreen extends Screen
{
    public InitialScreen(){    
        super(); 
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new Level());
    }
}
