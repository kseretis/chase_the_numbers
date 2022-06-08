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
    private static int level = INIT_LEVEL;
    private static final int MINIMUM_SPAWING_POSITION = 50;
    private static final int MAXIMUM_SPAWING_POSITION = WIDTH - 50;
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
        addObject(new Board(), 90, 70);
        addObject(Timer.getInstance(), 65, 65);
        
        // Setup blackboard
        addObject(new Blackboard(), 690, 70);
        addObject(MathProblem.getInstance(), 690, 65);
        
        // Generate math problem
        MathModel model = MathProblem.getLevelMathProblem();
        spawnNumbers(model);
        
        // Instantiate Hero
        Hero hero = Hero.getInstance();
        addObject(hero,750,753);
        
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
            addObject(number, getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION), 
                                getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION));
            while(number.isTouchingSameObject()){
                removeObject(number);
                addObject(number, getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION), 
                                    getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION));
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
        addObject(enemy, getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION), 
                            getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION));
        while(enemy.isTouchingSameObject()){
            removeObject(enemy);
            addObject(enemy, getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION), 
                                getRandomNumber(MINIMUM_SPAWING_POSITION, MAXIMUM_SPAWING_POSITION));
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
        Timer.getInstance().restartTimer();
    }
}
