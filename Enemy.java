import greenfoot.*;
/**
 * This model has created to represent the instance of every single Enemy
 * 
 * @author Seretis Kleanthis  
 * @version 2
 * @date 8/6/2022
 */
public class Enemy extends SmoothMover implements MovingObject{
    private static final int MAXIMUM_IMAGES = 8;
    private static final String IMAGE_LEFT = "left_";
    private static final String IMAGE_RIGHT = "right_";
    private static final String IMAGE_SUFFIX = ".png";
    private int movingCounter;
    private int switchingImgCounter = 0;
    private boolean isMovingRight;

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(int randomNumber){
        this.movingCounter = getRandomDirection(randomNumber);
        //TODO random movement right or left
    }
    
    public int getRandomDirection(int direction){
        return direction == 0 ? 0 : 100;
    }

    public boolean isMovingRight(){
        return isMovingRight;
    }
    
    public String buildStringPath(String imagePrefix){
        return isMovingRight ? imagePrefix + IMAGE_RIGHT + switchingImgCounter + IMAGE_SUFFIX
                            : imagePrefix + IMAGE_LEFT + switchingImgCounter + IMAGE_SUFFIX;
    }

    public void updateSwitchingImgCounter(){
        switchingImgCounter = switchingImgCounter < MAXIMUM_IMAGES ? switchingImgCounter+1 : 0;
    }
    /**
     * Implementing abstract methods from MovingObject interface
     */
    public void randomMove(int speed){ //FIXME
        if(movingCounter < 100){
            setLocation(getX() + speed, getY());
            isMovingRight = true;
        }
        else if(movingCounter < 200){
            setLocation(getX() - speed, getY());
            isMovingRight = false;
        }
        else
            movingCounter = 0;
        movingCounter++;
    }
    
    public void switchImage(String imagePrefix){
        setImage(new GreenfootImage(buildStringPath(imagePrefix)));
        updateSwitchingImgCounter();
    }
    
    public boolean isTouchingSameObject(){
        return this.isTouching(Enemy.class) ? true : false;
    }
}
