import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class was created in order to count down the time between
 * 2 enemy touchings. The hero can lose live only every 3 secs
 * 
 * @author Seretis Kleanthis
 * @version 1
 * @date 9/6/2022
 */
public class TouchingTimer extends Actor{
    private static final int TIME = 3;
    private static final int COUNTER = 55;
    private static TouchingTimer singleInstance = null;
    private static int timer;
    private boolean isCountingDown = false;
    /**
     * Constructor for objects of class Timer
     */
    private TouchingTimer(){
        restartTimer();
    }
    // Get the instance
    public static TouchingTimer getInstance(){
        if(singleInstance == null)
            singleInstance = new TouchingTimer();
        return singleInstance;
    }
    // act counting down till 0
    public void act(){
        if(isCountingDown){
            timer--;
            if(timer < 1)
                stopTimer();
        }
    }
    // Starts the timer
    public void startTimer(){
        restartTimer();
        isCountingDown = true;
    }
    // Stops the timer
    public void stopTimer(){
        isCountingDown = false;
    }
    // Restarts the counter
    public void restartTimer(){
        timer = TIME * COUNTER;
    }
    // isCountingDown getter
    public boolean isCountingDown(){
        return isCountingDown;
    }
}
