import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class banana extends Item{
    private int classification = -1;

    public banana(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 201;
        this.h = 148;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("banana.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Banana";
    }
    public int isCompostable(){
        return 1;
    }
    public int getClassification(){
        return classification;
    }
    public void setClassification(int c){
        this.classification = c;
    }
}
