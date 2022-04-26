import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class based on Singleton pattern, created for the main character of the game
 * 
 * @author Seretis Kleanthis 
 * @version 24/04/2022
 */
public class Hero extends SmoothMover{
    private static final int SPEED = 2;         //Normal speed
    private static final int SLOW_SPEED = 1;    //Sand speed
    private static Hero singleInstance = null;  //Hero instance
    private GreenfootImage image1;              //Images
    private GreenfootImage image2;              //Images
    private GreenfootImage image3;              //Images
    private GreenfootImage image4;              //Images
    private boolean goLeft;                     //Moving left(true). moving right(false)
    // Constructor
    private Hero(){
        image1 = new GreenfootImage("Hero0.png");
        image2 = new GreenfootImage("Hero1.png");
        image3 = new GreenfootImage("Hero3.png");
        image4 = new GreenfootImage("Hero4.png");
        setImage(image1);
    }
    // Get instance of the hero
    public static Hero getInstance(){
        if(singleInstance == null)
            singleInstance = new Hero();
        return singleInstance;
    }
    // act
    public void act(){
        checkKeyPress();
        switchImages();
        lookForTrophy();
        startNextLevel();
    }
    // Check which key is being pressed
    public void checkKeyPress(){
        int dx = 0, dy = 0;
        
        if(Greenfoot.isKeyDown("left")){
            dx = !isTouchingSand() ? dx-SPEED : dx-SLOW_SPEED;
            goLeft = true;
        }
        if(Greenfoot.isKeyDown("right")){
            dx = !isTouchingSand() ? dx+SPEED : dx+SLOW_SPEED;
            goLeft = false;
        }
        if(Greenfoot.isKeyDown("up")){
            dy = !isTouchingSand() ? dy-SPEED : dy-SLOW_SPEED;
        }
        if(Greenfoot.isKeyDown("down")){
            dy = !isTouchingSand() ? dy+SPEED : dy+SLOW_SPEED;
        }
        moveCharacter(dx, dy);
    }
    // If a key is pressed the character moves
    public void moveCharacter(int x, int y){
        if(x != 0 || y != 0)
            setLocation(getX()+x, getY()+y);
    }
    // Images switching
    public void switchImages(){
        if(goLeft)
            if(getImage() == image3)
                setImage(image4);
            else
                setImage(image3);
        else
            if(getImage() == image1)
                setImage(image2);
            else
                setImage(image1);
    }
    // Looking for ballons, if he finds one, he eat it
    public void lookForTrophy(){
        if(isTouching(Trophy.class)){
            removeTouching(Trophy.class);
            getWorld().getObjects(Counter.class).get(0).add(1);
            Greenfoot.playSound("mixkit-arrow-whoosh-1491.wav");
            Timer.updateTime(3);
        }
    }
    // Start the next level
    public void startNextLevel(){
        if(isLevelPassed()){
            getWorld().getObjects(Counter.class).get(0).setValue(0);
            Level.updateLevel();
            if(Level.getLevel() > 2)
                Greenfoot.setWorld(new WinScreen());
            else
                Greenfoot.setWorld(new PreLevelScreen());            
        }
    }
    // Touching sand    
    public boolean isTouchingSand(){
        return isTouching(Sand.class) ? true : false;
    }
    // Level passed, based on ballons needed per level
    public boolean isLevelPassed(){
        return getWorld().getObjects(Counter.class).get(0).getValue() >= Level.getBallonsNeeded() ? true : false; 
    }
}
