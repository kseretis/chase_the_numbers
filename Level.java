import greenfoot.*;
import java.util.*;

/**
 * Main level class. Is being recreated dynamically at the begging
 * of each level
 * 
 * @author Seretis Kleanthis 
 * @version 4
 * @date 10/6/2022
 */
public class Level extends Screen{
    public static final int INIT_LEVEL = 1;
    public static final int MAXIMUM_LEVEL = 10;
    private static final int MINIMUM_X_SPAWING_POSITION = 50;
    private static final int MAXIMUM_X_SPAWING_POSITION = WIDTH - 50;
    private static final int MINIMUM_Y_SPAWING_POSITION = 150;
    private static final int MAXIMUM_Y_SPAWING_POSITION = HEIGHT - 200;
    private static final int LIVES_Y_POSITION = 65;
    private static final int LIVES_X_POSITION = 255;
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
        addObject(new Blackboard(), 640, 70);
        addObject(MathProblem.getInstance(), 620, 65);
        
        // Initialize Zones
        Zones.getInstance().restartZonesAvailability();
        
        // Generate math problem
        spawnNumbers(MathProblem.getLevelMathProblem());
        
        // Instantiate Hero, touching timer and lives
        addObject(Hero.getInstance(),750,753);
        addObject(TouchingTimer.getInstance(), 0, 0);
        spawnLives();
        
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
    // Gets random number in range
    private int getRandomNumber(int min, int max){
        return Greenfoot.getRandomNumber(max - min + 1) + min;
    }
    // Spawns new numbers
    private void spawnNumbers(MathModel model){
        for(Number number: model.getNumbers()){
            Zone availableZone = Zones.lookForNumberRandomAvailableZone();
            addObject(number, getRandomNumber(availableZone.getStartingX(), availableZone.getEndingX()), 
                                getRandomNumber(availableZone.getStartingY(), availableZone.getEndingY()));
            availableZone.setIsAvailableForNumber(false);
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
        if(level > 5)
            spawnEnemy(new Zombie(getRandomNumber(0, 1)));
    }
    // Spawn single enemy if it's not touching another one
    private void spawnEnemy(Enemy enemy){
        Zone availableZone = Zones.lookForEnemyRandomAvailableZone();
        addObject(enemy, getRandomNumber(availableZone.getStartingX(), availableZone.getEndingX()), 
                            getRandomNumber(availableZone.getStartingY(), availableZone.getEndingY()));
        availableZone.setIsAvailableForEnemy(false);
    }
    // Spawn lives at the top of the screen
    private void spawnLives(){
        int x = LIVES_X_POSITION;
        for(Live live: Hero.getInstance().getLives()){
            addObject(live, x, LIVES_Y_POSITION);
            x+=90;
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
