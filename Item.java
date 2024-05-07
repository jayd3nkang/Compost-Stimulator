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

    public int isCompostable(){
        return 0;
    }
    public void setClassification(int c){
    }
    public int getClassification(){
        return -1;
    }
    // draw method will be different for every object
    public void draw(Graphics g){
    }
    public void drawSmall(Graphics g){
        
    }
    // default is false but each object can have its own compostability
    // public void isCompostable(){
    //     // 0 means its not compostable, 1 means it is compostable
    //     // later on we can use this to check if object location matches its preferred location (i.e. l=0 and p=0) to see if the
    //     // player is doing well. we can take this further and determine use the ratio of items overall sorted correctly rather than 
    //     // updating every time an item is sorted (check the whole array of items).
    //     this.p = 0;
    // }
    public void changeLocation(int loc){
        this.l = loc;
    }
    
}
