import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * A class based on Singleton pattern for the timer
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 8/6/2022
 */
public class Timer extends Actor{
    private static final String GAME_OVER_SOUND = "buzzer-gameover.wav";
    private static final int TIME = 30;
    private static final int COUNTER = 55;
    private static Timer singleInstance = null;
    private static int timer;
    private static final Color backgroundColor = new Color(236, 239, 241);
    /**
     * Constructor for objects of class Timer
     */
    private Timer(){
        restartTimer();
        updateImage();
    }
    // Get the instance
    public static Timer getInstance(){
        if(singleInstance == null)
            singleInstance = new Timer();
        return singleInstance;
    }
    // Restar timer
    public static void restartTimer(){
        timer = TIME * COUNTER;
    }
    // Act
    public void act(){
        timer--;
        if(timer % 55 == 0)
            updateImage();
        if(timer < 1)
            gameOver();
    }
    // Update Image
    private void updateImage(){
        String scoreBoardText = "Time: "+ timer/COUNTER + "\nLevel: " + Level.getLevel();
        setImage(new GreenfootImage(scoreBoardText, 20, Color.BLACK, backgroundColor));
    }
    // Game over
    private void gameOver(){
        Greenfoot.playSound(GAME_OVER_SOUND);
        Greenfoot.setWorld(new GameOverScreen());
    }
}
