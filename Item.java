import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Item extends Main{
    public int x;
    public int y;
    public int w;
    public int h;
    // l for location to check if it is in the compost or the trash
    public int l;
    // p for preferred location to see if the actual location is the same as the preferred location (compost or trash)
    public int p;
    // draw method will be different for every object
    public void draw(Graphics g){
    }
    // default is false but each object can have its own compostability
    public int isCompostable(){
        // 0 means its not compostable, 1 means it is compostable
        // later on we can use this to check if object location matches its preferred location (i.e. l=0 and p=0) to see if the
        // player is doing well. we can take this further and determine use the ratio of items overall sorted correctly rather than 
        // updating every time an item is sorted (check the whole array of items).
        return 0;
    }
    //public void followsMouse(){};
    // returns the left-most x value of the object
    // public int getX(){
    //     return this.x;
    // }
    // // returns the bottom (upper) most y value of the object
    // public int getY(){
    //     return this.y;
    // }
    // // returns the width of the object
    // public int getWidth(){
    //     return this.w;
    // }
    // // returns the height of the object
    // public int getHeight(){
    //     return this.h;
    // }
    // changes the x value (for moving on screen)
    // public void setX(int ex){
    //     this.x = ex;
    // }
    // // changes the y value
    // public void setY(int why){
    //     this.y = why;
    // }
    //public abstract void draw(Graphics g);
    // checks if the mouse click is within the hitbox of the object
    // public Boolean getHitBox(int mx, int my){
    //     if ((mx >= this.x && mx <= this.x + this.getWidth()) && (my >= this.y && my <= this.y + this.getHeight())) return true;
    //     return false;
    // }
}
