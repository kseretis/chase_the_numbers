import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor{
    private static final int TIME = 5;
    private static final int COUNTER = 55;
    private static Timer singleInstance = null;
    private static int timer;
    
    private Timer(){
        timer = TIME * COUNTER;
        updateImage();
    }
    
    public static Timer getInstance(){
        if(singleInstance == null)
            singleInstance = new Timer();
        return singleInstance;
    }
    
    public static void updateTime(int seconds){
        timer += (seconds * COUNTER);
    }
    
    public static void restartTimer(){
        timer = TIME * COUNTER;
    }
    
    public void act(){
        timer--;
        if(timer % 55 == 0)
            updateImage();
        if(timer < 1)
            gameOver();
    }
    
    private void updateImage(){
        setImage(new GreenfootImage("Time: "+ timer/COUNTER, 20, Color.BLACK, Color.YELLOW));
    }
    
    private void gameOver(){
        getWorld().removeObjects(getWorld().getObjects(Sand.class));
        getWorld().removeObjects(getWorld().getObjects(Trophy.class));
        getWorld().removeObjects(getWorld().getObjects(Hero.class));
        Greenfoot.playSound("buzzer-gameover.wav");
        Greenfoot.setWorld(new GameOverScreen());
        
    }
}
