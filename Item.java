import java.awt.Color;
import java.awt.Graphics;

public class Item extends Main{
    public int x;
    public int y;
    public int w;
    public int h;
    // draw method will be different for every object
    public void draw(Graphics g){}
    // default is false but each object can have its own compostability
    public Boolean isCompostable(){
        return false;
    }
    public void followsMouse(){};
    // returns the left-most x value of the object
    public int getX(){
        return this.x;
    }
    // returns the bottom (upper) most y value of the object
    public int getY(){
        return this.y;
    }
    // returns the width of the object
    public int getWidth(){
        return this.w;
    }
    // returns the height of the object
    public int getHeight(){
        return this.h;
    }
    // changes the x value (for moving on screen)
    public void setX(int ex){
        this.x = ex;
    }
    // changes the y value
    public void setY(int why){
        this.y = why;
    }
    // checks if the mouse click is within the hitbox of the object
    public Boolean getHitBox(int mx, int my){
        if ((mx >= this.x && mx <= this.x + this.getWidth()) && (my >= this.y && my <= this.y + this.getHeight())) return true;
        return false;
    }
}
