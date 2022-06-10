/**
 * Write a description of class Zone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public Zone(int startingY, int endingY, boolean leftOrRight){
        this.startingY = startingY;
        this.endingY = endingY;
        this.leftOrRight = leftOrRight;
        setUpZoneLeftOrRight();
        this.isAvailable = true;
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
}
