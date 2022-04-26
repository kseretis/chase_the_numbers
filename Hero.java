import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends SmoothMover{
    private static final int SPEED = 2;         //Normal speed
    private static final int SLOW_SPEED = 1;    //Sand speed
    private static Hero singleInstance = null;  //Hero instance
    private Counter trophyCounter;              //Ballons counter
    private GreenfootImage image1;              //Images
    private GreenfootImage image2;              //Images
    private GreenfootImage image3;              //Images
    private GreenfootImage image4;              //Images
    private boolean goLeft;                     //Moving left(true). moving right(false)
    
    public Hero(){
        // trophyCounter = getWorld().getObjects(Counter.class).get(0);
        image1 = new GreenfootImage("Hero0.png");
        image2 = new GreenfootImage("Hero1.png");
        image3 = new GreenfootImage("Hero3.png");
        image4 = new GreenfootImage("Hero4.png");
        setImage(image1);
    }
    
    public static Hero getInstance(){
        if(singleInstance == null)
            singleInstance = new Hero();
        return singleInstance;
    }
    
    public void act(){
        checkKeyPress();
        switchImages();
        lookForTrophy();
        startNextLevel();
    }
    
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
    
    public void moveCharacter(int x, int y){
        if(x != 0 || y != 0)
            setLocation(getX()+x, getY()+y);
    }
    
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
    
    public void lookForTrophy(){
        if(isTouching(Trophy.class)){
            removeTouching(Trophy.class);
            getWorld().getObjects(Counter.class).get(0).add(1);
            // trophyCounter.add(1);
            Greenfoot.playSound("mixkit-arrow-whoosh-1491.wav");
            Timer.getInstance().updateTime(3);
        }
    }
    
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
    
    public static int getSpeed(){
        return SPEED;
    }
    
    public boolean isTouchingSand(){
        return isTouching(Sand.class) ? true : false;
    }
    
    public boolean isLevelPassed(){
        return getWorld().getObjects(Counter.class).get(0).getValue() >= Level.getBallonsNeeded() ? true : false; 
    }
    
}
