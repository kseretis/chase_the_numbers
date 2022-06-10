/**
 * This class is created to hold the data for the model zone
 * Contains the rabges of the positions X-Y
 * 
 * @author Seretis Kleanthis
 * @version 1
 * @date 10/6/2022
 */
public class Zone {
    private static int STARTING_X = 100;
    private static int MID_X = 400;
    private static int ENDING_X = 700;
    private int startingX;
    private int endingX;
    private int startingY;
    private int endingY;
    private boolean leftOrRight; //true for left, false for right
    private boolean isAvailable;
    private boolean isAvailableForNumber;
    
    public Zone(int startingY, int endingY, boolean leftOrRight){
        this.startingY = startingY;
        this.endingY = endingY;
        this.leftOrRight = leftOrRight;
        setUpZoneLeftOrRight();
        this.isAvailable = true;
        this.isAvailableForNumber = true;
    }
    // 100-400px for left, 400-700px for right
    private void setUpZoneLeftOrRight(){
        this.startingX = leftOrRight ? STARTING_X : MID_X;
        this.endingX = leftOrRight ? MID_X : ENDING_X; 
    }
    
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
    
    public boolean isAvailable(){
        return isAvailable;
    }
    
    public int getStartingX(){
        return startingX;
    }
    
    public int getEndingX(){
        return endingX;
    }
    
    public int getStartingY(){
        return startingY;
    }
    
    public int getEndingY(){
        return endingY;
    }
    
    public void setIsAvailableForNumber(boolean isAvailableForNumber){
        this.isAvailableForNumber = isAvailableForNumber;
    }
    
    public boolean isAvailableForNumber(){
        return isAvailableForNumber;
    } 
}
