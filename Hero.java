import greenfoot.*;
import java.util.*;
/**
 * A class based on Singleton pattern, created for the main character of the game
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 24/4/2022
 */
public class Hero extends SmoothMover{
    private static final int SPEED = 3;         //Normal speed
    private static final int SLOW_SPEED = 1;    //Sand speed
    private static final int MAXIMUM_IMAGE_NUMBER = 30;
    private static final String IMAGE_PREFIX = "Citizen_";
    private static final String IMAGE_FRONT = "front_";
    private static final String IMAGE_BACK = "back_";
    private static final String IMAGE_LEFT = "left_";
    private static final String IMAGE_RIGHT = "right_";
    private static final String IMAGE_SUFFIX = ".png";
    //private static final String IMAGE_NAME = "Citizen_Walk_000";
    
    private static Hero singleInstance = null;  //Hero instance
    private GreenfootImage heroImage;
    private int frontImgCounter = 0;
    
    
    private GreenfootImage image1;              //Images
    private GreenfootImage image2;              //Images
    private GreenfootImage image3;              //Images
    private GreenfootImage image4;              //Images
    private boolean goLeft;                     //Moving left(true). moving right(false)
    // Constructor
    private Hero(){
        //image1 = new GreenfootImage("Hero0.png"); //TODELETE
        //image2 = new GreenfootImage("Hero1.png"); //TODELETE
        //image3 = new GreenfootImage("Hero3.png"); //TODELETE
        //image4 = new GreenfootImage("Hero4.png"); //TODELETE
        setImage(new GreenfootImage(IMAGE_PREFIX + IMAGE_LEFT + frontImgCounter + IMAGE_SUFFIX));
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
        //switchImages();
        lookForTrophy();
        //startNextLevel();
    }
    // Checks which key is being pressed
    private void checkKeyPress(){
        int dx = 0, dy = 0;
        
        if(Greenfoot.isKeyDown("left")){
             dx = !isTouchingSand() ? dx-SPEED : dx-SLOW_SPEED;
            goLeft = true;
            setImage(new GreenfootImage(IMAGE_PREFIX + IMAGE_LEFT + frontImgCounter + IMAGE_SUFFIX));
            frontImgCounter = frontImgCounter < MAXIMUM_IMAGE_NUMBER ? frontImgCounter++ : 0 ;
            //moveCharacter(dx, dy);
        }
        if(Greenfoot.isKeyDown("left")){
            dx = !isTouchingSand() ? dx-SPEED : dx-SLOW_SPEED;
            goLeft = true;
            setImage(new GreenfootImage(IMAGE_PREFIX + IMAGE_LEFT + frontImgCounter + IMAGE_SUFFIX));
            frontImgCounter = frontImgCounter < MAXIMUM_IMAGE_NUMBER ? frontImgCounter++ : 0 ;
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
        moveCharacter(dx, dy);
    }
    // If a key is pressed the character moves
    private void moveCharacter(int x, int y){
        if(x != 0 || y != 0)
            setLocation(getX()+x, getY()+y);
    }
    // Images switching
    private void switchImages(){
        /*if(goLeft)
            if(getImage() == image3)
                setImage(image4);
            else
                setImage(image3);
        else
            if(getImage() == image1)
                setImage(image2);
            else
                setImage(image1);*/
        while(Greenfoot.isKeyDown("left")){
            setImage(new GreenfootImage(IMAGE_PREFIX + IMAGE_LEFT + frontImgCounter + IMAGE_SUFFIX));
            frontImgCounter = frontImgCounter < MAXIMUM_IMAGE_NUMBER ? frontImgCounter++ : 0 ;
        }
    }
    private void switchImages2(){
 
        
        
    }
    // Looking for ballons, if he finds one, he eat it
    private void lookForTrophy(){
        if(isTouching(Trophy.class)){  
            Trophy trophy = (Trophy)getOneIntersectingObject(Trophy.class);
            if(isLevelPassed(trophy))
                startNextLevel();
            removeTouching(Trophy.class);
            Greenfoot.playSound("mixkit-arrow-whoosh-1491.wav");
            //Timer.updateTime(3);
        }
    }
    // Start the next level
    private void startNextLevel(){
        //getWorld().getObjects(Counter.class).get(0).setValue(0); //FIXME
        Level.updateLevel();
        if(Level.getLevel() > Level.MAXIMUM_LEVEL){
            Greenfoot.playSound("win.wav");
            MathProblem.getInstance().updateMathProblem();
            Greenfoot.setWorld(new WinScreen());
        }
        else{
            Greenfoot.playSound("level-passed.wav");
            MathProblem.getInstance().updateMathProblem();
            Greenfoot.setWorld(new PreLevelScreen());
        }            
    }
    // Touching sand    
    public boolean isTouchingSand(){
        return isTouching(Sand.class) ? true : false;
    }
    // Level passed, based on ballons needed per level
    private boolean isLevelPassed(Trophy trophy){ 
        return trophy.isTheCorrectAnswer(trophy.getNumber());
    }
}
