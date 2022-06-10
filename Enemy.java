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
    public static final int MAXIMUM_ENEMIES = 6;
    private int movingCounter;
    private int switchingImgCounter = 0;
    private boolean isMovingRight;
    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(int randomNumber){
        this.movingCounter = getRandomDirection(randomNumber);
     }
    // Returns 0 or 100 for random number received. So, left or right
    public int getRandomDirection(int direction){
        return direction == 0 ? 0 : 100;
    }
    // isMovingRight getter
    public boolean isMovingRight(){
        return isMovingRight;
    }
    // Builds string path
    public String buildStringPath(String imagePrefix){
        return isMovingRight ? imagePrefix + IMAGE_RIGHT + switchingImgCounter + IMAGE_SUFFIX
                            : imagePrefix + IMAGE_LEFT + switchingImgCounter + IMAGE_SUFFIX;
    }
    // Updates the image counter
    public void updateSwitchingImgCounter(){
        switchingImgCounter = switchingImgCounter < MAXIMUM_IMAGES ? switchingImgCounter+1 : 0;
    }
    /**
     * Implementing abstract methods from MovingObject interface
     */
    // Random move
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
    // Image Switch
    public void switchImage(String imagePrefix){
        setImage(new GreenfootImage(buildStringPath(imagePrefix)));
        updateSwitchingImgCounter();
    }
    // Touching same object getter
    public boolean isTouchingSameObject(){
        return isTouching(Enemy.class);
    }
}
