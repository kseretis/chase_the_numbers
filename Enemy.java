/**
 * This model has created to represent the instance of every single Enemy
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends SmoothMover implements MovingObject{
    private static final int MAXIMUM_IMAGES = 8;
    private static final String IMAGE_LEFT = "left_";
    private static final String IMAGE_RIGHT = "right_";
    private static final String IMAGE_SUFFIX = ".png";
    private int movingCounter;
    private int switchingImgCounter = 0;
    private boolean movingRight;

    /**
     * Constructor for objects of class Enemy
     */
    public Enemy(int movingCounter){
        this.movingCounter = getRandomDirection(movingCounter);
        //TODO random movement right or left
    }
    
    public int getRandomDirection(int direction){
        return direction == 0 ? 0 : 100;
    }

    public boolean isMovingRight(){
        return movingRight;
    }
    
    public String buildStringPath(String imagePrefix){
        return movingRight ? imagePrefix + IMAGE_RIGHT + switchingImgCounter + IMAGE_SUFFIX
                            : imagePrefix + IMAGE_LEFT + switchingImgCounter + IMAGE_SUFFIX;
    }

    public void updateSwitchingImgCounter(){
        switchingImgCounter = switchingImgCounter < MAXIMUM_IMAGES ? switchingImgCounter+1 : 0;
    }
    
    public void switchImage(){}
    
    public void randomMove(int speed){ //FIXME
        if(movingCounter < 100){
            setLocation(getX() + speed, getY());
            movingRight = true;
        }
        else if(movingCounter < 200){
            setLocation(getX() - speed, getY());
            movingRight = false;
        }
        else
            movingCounter = 0;
        movingCounter++;
    }

}
