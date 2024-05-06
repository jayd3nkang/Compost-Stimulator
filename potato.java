import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class potato extends Item implements Goods{
    private int classification = -1;

    public potato(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 167;
        this.h = 80;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("potato.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Potato";
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