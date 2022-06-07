import greenfoot.*;

/**
 * Main level class. Is being recreated dynamically at the begging
 * of each level
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 5/6/2022
 */
public class Level extends Screen{
    public static final int INIT_LEVEL = 1;
    public static final int MAXIMUM_LEVEL = 2;
    private static int level = INIT_LEVEL;
    private static int numberOfTrophies = 6;
    // Constructor
    public Level(){    
        super(); 
        prepare();
    }
    // Prepare the level
    private void prepare(){
        //Spawn sands
        /*Sand sand = new Sand();
        addObject(sand,627,656);
        Sand sand2 = new Sand();
        addObject(sand2,450,556);
        Sand sand3 = new Sand();
        addObject(sand3,648,421);
        Sand sand4 = new Sand();
        addObject(sand4,407,306);
        Sand sand5 = new Sand();
        addObject(sand5,241,448);
        Sand sand6 = new Sand();
        addObject(sand6,105,726);
        Sand sand7 = new Sand();
        addObject(sand7,84,284);
        Sand sand8 = new Sand();
        addObject(sand8,286,98);
        Sand sand9 = new Sand();
        addObject(sand9,625,198);
        Sand sand10 = new Sand();
        addObject(sand10,370,758);*/
        
        //Set math problem
        addObject(MathProblem.getInstance(), 650, 34);
        //Spawn numbers
        MathModel model = MathProblem.getLevelMathProblem();
        spawnNewTrophies(model);

        //Create Hero, timer and counter instance
        //Counter counter = new Counter();
        //addObject(counter,69,66);
        Hero hero = Hero.getInstance();
        addObject(hero,750,753);
        Timer timer = Timer.getInstance();
        addObject(timer,70,34);
        //Hero over sand
        setPaintOrder(Hero.class, Sand.class);
    }
    
    public void spawnNewTrophies(MathModel model){
        for(Trophy tr: model.getTrophyAnswers()){
            addObject(tr, Greenfoot.getRandomNumber(WIDTH), Greenfoot.getRandomNumber(HEIGHT));
            while(tr.isTouchingSand()){
                removeObject(tr);
                addObject(tr, Greenfoot.getRandomNumber(WIDTH), Greenfoot.getRandomNumber(HEIGHT));
            } 
        }
    } 
    /**
     * Static Section
     */
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
