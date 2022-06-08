/**
 * An interface for moving objects
 * 
 * @author Seretis Kleanthis
 * @version 1
 * @date 8/6/2022
 */
public interface MovingObject  {
    public abstract void randomMove(int speed);
    public abstract void switchImage(String imagePrefix);
    public abstract boolean isTouchingSameObject();
    public abstract boolean isTouchingBoard();
    public abstract boolean isTouchingHero();
}
