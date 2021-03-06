import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A super class that holds the numbers of the screen size
 * 
 * @author Seretis Kleanthis 
 * @version 3
 * @date 8/6/2022
 */
public class Screen extends World implements ScreenActions{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    /**
     * Constructor for objects of class Screen
     */
    public Screen(){    
        super(WIDTH, HEIGHT, 1); 
    }
    /**
     * Implementing ScreenActions' methods
     */
    public void checkKeyDown(Screen newScreen){
        if(Greenfoot.isKeyDown("enter") || Greenfoot.isKeyDown("space"))
            Greenfoot.setWorld(newScreen);
    }
    
    public void restartGame(){
        Timer.restartTimer();
        Level.restartLevels();
        MathProblem.restartMathProblem();
        Hero.getInstance().resetHeroLives();
        TouchingTimer.restartTimer();
    }
}
