import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The winning screen
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 8/6/2022
 */
public class WinScreen extends Screen{
    /**
     * Constructor for objects of class WinScreen
     */
    public WinScreen(){    
        super();
        restartGame();
    }
    // Act
    public void act(){
        if(Greenfoot.isKeyDown("space"))
            Greenfoot.setWorld(new Level());
    }
    // Restart game
    public void restartGame(){
        Timer.restartTimer();
        Level.restartLevels();
        MathProblem.restartMathProblem();
    }
}
