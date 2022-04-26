import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends Screen{
    private static int level = 1;
    private static int ballonsNeeded = 5;
    // Constructor
    public Level(){    
        super(); 
        prepare();
    }
    // Prepare the level
    private void prepare(){
        //Spawn sands
        Sand sand = new Sand();
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
        addObject(sand10,370,758);
        //Spawn ballons
        checkLevel();
        //Create Hero, timer and counter instance
        Counter counter = new Counter();
        addObject(counter,69,66);
        Hero hero = Hero.getInstance();
        addObject(hero,750,753);
        Timer timer = Timer.getInstance();
        addObject(timer,70,34);
        //Hero over sand
        setPaintOrder(Hero.class, Sand.class);
    }
    // Check the level and modifies the needed ballons
    public void checkLevel(){
        if(level == 1){
            ballonsNeeded = 5;
            createNewballons(ballonsNeeded);
        }
        else{
            ballonsNeeded++;
            createNewballons(ballonsNeeded);
        }
    }
    // Create new ballons that don't touch the sand
    public void createNewballons(int num){
        for(int i=0; i<num; i++){
            Trophy trophy = new Trophy();
            addObject(trophy, Greenfoot.getRandomNumber(WIDTH), Greenfoot.getRandomNumber(HEIGHT));
            while(trophy.isTouchingSand()){
                removeObject(trophy);
                addObject(trophy, Greenfoot.getRandomNumber(WIDTH), Greenfoot.getRandomNumber(HEIGHT));
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
    // Get the needed ballons
    public static int getBallonsNeeded(){
        return ballonsNeeded;
    }
}
