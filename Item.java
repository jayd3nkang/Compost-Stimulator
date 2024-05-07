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


public  class Item extends Main{
    //public abstract  classification;
    public int x;
    public int y;
    public int w;
    public int h;
    // l for location to check if it is in the compost or the trash
    public int l;
    // p for preferred location to see if the actual location is the same as the preferred location (compost or trash)
    public int p = 0;

    //Every subclass of Item is an item that can be compostable or not
    public int isCompostable(){
        return 0;
    }
    //changes the classification (depending on the button pressed and it's own value of isCompostable)
    public void setClassification(int c){
    }
    //returns what the classification Item has been assigned
    public int getClassification(){
        return -1;
    }
    // draw method will be different for every object
    public void draw(Graphics g){
    }
    //draw a smaller of the item
    public void drawSmall(Graphics g){
        
    }
    //changes the location of the item
    public void changeLocation(int loc){
        this.l = loc;
    }
    
}
