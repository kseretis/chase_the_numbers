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
    private static final int SPEED = 3;
    private static final int MAXIMUM_IMAGE_NUMBER = 29;
    private static final String IMAGE_PREFIX = "Hero\\Citizen_";
    private static final String IMAGE_FRONT = "front_";
    private static final String IMAGE_BACK = "back_";
    private static final String IMAGE_LEFT = "left_";
    private static final String IMAGE_RIGHT = "right_";
    private static final String IMAGE_SUFFIX = ".png";
    private static final String WIN_SOUND = "win.wav";
    private static final String LEVEL_PASSED_SOUND = "level-passed.wav";
    private static final String EAT_NUMBER_SOUND = "whoosh.wav";
    private static final String TOUCHING_ENEMY_SOUND = "ouch.wav";
    private static final String GAME_OVER_SOUND = "buzzer-gameover.wav";
    private static Hero singleInstance = null;  //Hero instance
    private static final int MAXIMUM_LIVES = 3;
    private int frontImgCounter = 0;
    private int backImgCounter = 0;
    private int leftImgCounter = 0;
    private int rightImgCounter = 0;
    private List<Live> lives = new ArrayList<>();
    private int livesLeft;
    /**
     * Constructor for objects of class Hero
     */
    private Hero(){
        setImage(new GreenfootImage(IMAGE_PREFIX + IMAGE_LEFT + frontImgCounter + IMAGE_SUFFIX));
        generateLives();
        this.livesLeft = livesLeft();
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
        checkIfTouchingEnemy();
        lookForNumber();
        checkIfLostAllLives();
    }
    // Checks which key is being pressed
    private void checkKeyPress(){
        int dx = 0, dy = 0;
        if(Greenfoot.isKeyDown("left")){ //FIXME
            dx = dx-SPEED;
            switchImage(IMAGE_LEFT, leftImgCounter);
            leftImgCounter = updateImgCounter(leftImgCounter);
        }
        if(Greenfoot.isKeyDown("right")){
            dx = dx+SPEED;
            switchImage(IMAGE_RIGHT, rightImgCounter);
            rightImgCounter = updateImgCounter(rightImgCounter);
        }
        if(Greenfoot.isKeyDown("up")){
            dy = dy-SPEED;
            switchImage(IMAGE_BACK, backImgCounter);
            backImgCounter = updateImgCounter(backImgCounter);
        }
        if(Greenfoot.isKeyDown("down")){
            dy = dy+SPEED;
            switchImage(IMAGE_FRONT, frontImgCounter);
            frontImgCounter = updateImgCounter(frontImgCounter);
        }
        moveCharacter(dx, dy);
    }
    // If a key is pressed the character moves
    private void moveCharacter(int x, int y){
        if(x != 0 || y != 0)
            setLocation(getX()+x, getY()+y);
    }
    // Image switching
    private void switchImage(String direction, int counter){
        setImage(new GreenfootImage(IMAGE_PREFIX + direction + counter + IMAGE_SUFFIX));
    }
    // Update Image counter
    private int updateImgCounter(int counter){
        return counter < MAXIMUM_IMAGE_NUMBER ? counter+1 : 0;
    }
    // Looking for ballons, if he finds one, he eat it
    private void lookForNumber(){
        if(isTouching(Number.class)){  
            Number number = (Number)getOneIntersectingObject(Number.class);
            if(isLevelPassed(number))
                startNextLevel();
            removeTouching(Number.class);
            Greenfoot.playSound(EAT_NUMBER_SOUND);
        }
    }
    // Start the next level
    private void startNextLevel(){
        Level.updateLevel();
        MathProblem.getInstance().updateMathProblem();
        obtainLive();
        
        String sound = Level.getLevel() > Level.MAXIMUM_LEVEL ? WIN_SOUND : LEVEL_PASSED_SOUND;
        Screen newScreen = Level.getLevel() > Level.MAXIMUM_LEVEL ? new WinScreen() : new PreLevelScreen();
        
        Greenfoot.playSound(sound);
        Greenfoot.setWorld(newScreen);
    }
    // Level passed, based on ballons needed per level
    private boolean isLevelPassed(Number number){ 
        return number.isTheCorrectAnswer(number.getNumber());
    }
    // Check if touching enemy
    private void checkIfTouchingEnemy(){
        if(isTouchingEnemy()){
            if(!TouchingTimer.getInstance().isCountingDown()){
                TouchingTimer.startTimer();
                Greenfoot.playSound(TOUCHING_ENEMY_SOUND);
                loseLive();
            }
        }
        int transparency = TouchingTimer.isCountingDown() ? 50 : 255;
        getImage().setTransparency(transparency);
    }
    // touching enemy getter
    private boolean isTouchingEnemy(){
        return isTouching(Enemy.class);
    }
    // Generates the initial 3 lives
    private void generateLives(){
        for(int i = 0; i<MAXIMUM_LIVES; i++)
            lives.add(new Live());
    }
    // Resets the hero's lives
    public void resetHeroLives(){
        livesLeft = MAXIMUM_LIVES;
        for(Live live: lives)
            live.setIsFull(true);
    }
    // Lives getter
    public List<Live> getLives(){
        return lives;
    }
    // Return how many lives left
    private int livesLeft(){
        int livesLeft = 0;
        for(Live live: lives)
            if(live.isFull())
                livesLeft++;
        return livesLeft;
    }
    // Lose live and triggers the live to change the image
    private void loseLive(){
        this.livesLeft--;
        lives.get(this.livesLeft).setIsFull(false);
    }
    // Obtain one live for the correct answer
    private void obtainLive(){
        if(livesLeft < MAXIMUM_LIVES){
            lives.get(livesLeft).setIsFull(true);
            livesLeft++;
        }
    }
    // Checks the lives list if it's null or empty
    private boolean hasLostAllLives(){
        return livesLeft() < 1;
    }
    // Checks if hero has lost all of his lives
    private void checkIfLostAllLives(){
        if(hasLostAllLives())
            gameOver();
    }
    // Triggers game over screen
    private void gameOver(){
        Greenfoot.playSound(GAME_OVER_SOUND);
        Greenfoot.setWorld(new GameOverScreen());
    }
}
