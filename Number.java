import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class created for the trophies with numbers as images
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 24/04/2022
 */
public class Number extends SmoothMover{
    private static final String IMAGE_PREFIX = "Numbers\\";
    private static final String IMAGE_SUFFIX = ".png";
    private MathModel problem;
    private int number;
    /**
     * Constructor for objects of class Trophy
     */
    public Number(MathModel problem, int number){
        this.problem = problem;
        this.number = number;
        setImage(new GreenfootImage(IMAGE_PREFIX + this.number + IMAGE_SUFFIX));
        getImage().scale(60, 60);
    }
    // Act
    public void act(){}
    // Returns the image's number of the tropgy
    public int getNumber(){
        return number;
    }
    // Returns if hero is touching the correct trophy    
    public boolean isTheCorrectAnswer(int answer){
        return this.problem.getSolution() == answer ? true : false;
    }
}
