/**
 * Write a description of class MoovingObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface MovingObject  {
    public abstract void randomMove(int speed);
    public abstract void switchImage(String imagePrefix);
    public abstract boolean isTouchingSameObject();
}
