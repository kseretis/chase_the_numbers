import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class created for the trophies with numbers as images
 * 
 * @author Seretis Kleanthis 
 * @version 2
 * @date 24/04/2022
 */
public class Number extends SmoothMover implements MovingObject{
    private static final String IMAGE_PREFIX = "Numbers\\";
    private static final String IMAGE_SUFFIX = ".png";
    private static final int SPEED = 1;
    private int movingCounter = 0;
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
    public void act(){
        if(Level.getLevel() > Level.HEIGHT)
            randomMove(SPEED);
    }
    // Returns the image's number of the tropgy
    public int getNumber(){
        return number;
    }
    // Returns if hero is touching the correct trophy    
    public boolean isTheCorrectAnswer(int answer){
        return this.problem.getSolution() == answer ? true : false;
    }
    /**
     * Implementing abstract methods from MovingObject interface
     */
    // Random move
    public void randomMove(int speed){
        if(movingCounter < 100)
            setLocation(getX() + speed, getY());
        else if(movingCounter < 200)
            setLocation(getX() - speed, getY());
        else
            movingCounter = 0;
        movingCounter++;
    }
    // Image Switch
    public void switchImage(String imagePrefix){}
    // Touching same object getter    
    public boolean isTouchingSameObject(){
        return isTouching(Number.class) ? true : false;
    }
}
