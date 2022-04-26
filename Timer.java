import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class based on Singleton pattern for the timer
 * 
 * @author Seretis Kleanthis 
 * @version 24/04/2022
 */
public class Timer extends Actor{
    private static final int TIME = 6;
    private static final int COUNTER = 55;
    private static Timer singleInstance = null;
    private static int timer;
    // Constructor
    private Timer(){
        timer = TIME * COUNTER;
        updateImage();
    }
    // Get the instance
    public static Timer getInstance(){
        if(singleInstance == null)
            singleInstance = new Timer();
        return singleInstance;
    }
    // Update timer
    public static void updateTime(int seconds){
        timer += (seconds * COUNTER);
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
        setImage(new GreenfootImage("Time: "+ timer/COUNTER, 20, Color.BLACK, Color.YELLOW));
    }
    // Game over
    private void gameOver(){
        getWorld().removeObjects(getWorld().getObjects(Sand.class));
        getWorld().removeObjects(getWorld().getObjects(Trophy.class));
        getWorld().removeObjects(getWorld().getObjects(Hero.class));
        Greenfoot.playSound("buzzer-gameover.wav");
        Greenfoot.setWorld(new GameOverScreen());
    }
}
