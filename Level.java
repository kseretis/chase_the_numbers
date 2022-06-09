import greenfoot.*;
import java.util.*;

/**
 * Main level class. Is being recreated dynamically at the begging
 * of each level
 * 
 * @author Seretis Kleanthis 
 * @version 3
 * @date 7/6/2022
 */
public class Level extends Screen{
    public static final int INIT_LEVEL = 1;
    public static final int MAXIMUM_LEVEL = 2;
    private static final int MINIMUM_X_SPAWING_POSITION = 50;
    private static final int MAXIMUM_X_SPAWING_POSITION = WIDTH - 50;
    private static final int MINIMUM_Y_SPAWING_POSITION = 50;
    private static final int MAXIMUM_Y_SPAWING_POSITION = HEIGHT - 100;
    private static final int LIVES_Y_POSITION = 65;
    private static final int LIVES_X_POSITION = 220;
    private static int level = INIT_LEVEL;
    private static int numberOfTrophies = 5;
    private List<GreenfootImage> backgrounds = new ArrayList<>();
    /**
     * Constructor for objects of class Level
     */
    public Level(){    
        super(); 
        readBackgroundImgs();
        setRandombackground();
        prepare();
    }
    // Prepare the level
    private void prepare(){
        // Setup board
        addObject(new ScoreBoard(), 90, 70);
        addObject(Timer.getInstance(), 65, 65);
        
        // Setup blackboard
        addObject(new Blackboard(), 690, 70);
        addObject(MathProblem.getInstance(), 690, 65);
        
        // Generate math problem
        //MathModel model = MathProblem.getLevelMathProblem();
        spawnNumbers(MathProblem.getLevelMathProblem());
        
        // Instantiate Hero
        //Hero hero = Hero.getInstance();
        addObject(Hero.getInstance(),750,753);
        addObject(TouchingTimer.getInstance(), 0, 0);
        
        generateLives();
        
        
        
        // Spawn enemies
        spawnEnemies();
        setPaintOrder(Enemy.class, Number.class);
    }
    // Reads backgrounds
    private void readBackgroundImgs(){
        backgrounds.add(new GreenfootImage("grass.png"));
        backgrounds.add(new GreenfootImage("sand.png"));
        backgrounds.add(new GreenfootImage("rock.png"));
    }
    // Sets random background
    private void setRandombackground(){
        setBackground(backgrounds.get(getRandomNumber(0, 2)));
    }
    // Gets rancom number in range
    private int getRandomNumber(int min, int max){
        return Greenfoot.getRandomNumber(max - min + 1) + min;
    }
    // Spawns new numbers
    private void spawnNumbers(MathModel model){
        for(Number number: model.getNumbers()){
            getRandomNumber(50, WIDTH);
            addObject(number, getRandomNumber(MINIMUM_X_SPAWING_POSITION, MAXIMUM_X_SPAWING_POSITION), 
                                getRandomNumber(MINIMUM_Y_SPAWING_POSITION, MAXIMUM_Y_SPAWING_POSITION));
            while(number.isTouchingNumber() || number.isTouchingBoard()){
                removeObject(number);
                addObject(number, getRandomNumber(MINIMUM_X_SPAWING_POSITION, MAXIMUM_X_SPAWING_POSITION), 
                                    getRandomNumber(MINIMUM_Y_SPAWING_POSITION, MAXIMUM_Y_SPAWING_POSITION));
            }
        }
    }
    // Spawns enemies based on level
    private void spawnEnemies(){
        spawnEnemy(new Zombie(getRandomNumber(0, 1)));
        if(level > 1)
            spawnEnemy(new Robot(getRandomNumber(0, 1)));
        if(level > 2)
            spawnEnemy(new Zombie(getRandomNumber(0, 1)));
        if(level > 3)
            spawnEnemy(new Robot(getRandomNumber(0, 1)));
        if(level > 4)
            spawnEnemy(new Zombie(getRandomNumber(0, 1)));
    }
    // Spawn single enemy if it's not touching another one
    private void spawnEnemy(Enemy enemy){
        addObject(enemy, getRandomNumber(MINIMUM_X_SPAWING_POSITION, MAXIMUM_X_SPAWING_POSITION), 
                            getRandomNumber(MINIMUM_Y_SPAWING_POSITION, MAXIMUM_Y_SPAWING_POSITION));
        while(enemy.isTouchingSameObject() || enemy.isTouchingBoard() || enemy.isTouchingHero()){
            removeObject(enemy);
            int x = getRandomNumber(MINIMUM_X_SPAWING_POSITION, MAXIMUM_X_SPAWING_POSITION);
            int y = getRandomNumber(MINIMUM_Y_SPAWING_POSITION, MAXIMUM_Y_SPAWING_POSITION);
            addObject(enemy, getRandomNumber(MINIMUM_X_SPAWING_POSITION, MAXIMUM_X_SPAWING_POSITION), 
                                getRandomNumber(MINIMUM_Y_SPAWING_POSITION, MAXIMUM_Y_SPAWING_POSITION));
        }
    }
    private void generateLives(){
        int x = LIVES_X_POSITION;
        for(Live live: Hero.getInstance().getLives()){
            addObject(live, x, LIVES_Y_POSITION);
            x+=100;
        }
    }
    /**********************************************
     * Static Section
     **********************************************/
    // Update the level
    public static void updateLevel(){
        level++;
        Timer.getInstance().restartTimer();
    }
    // Get the level
    public static int getLevel(){
        return level;
    }
    // Restart the level
    public static void restartLevels(){
        level = 1;
    }
}
