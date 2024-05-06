import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class coffeebean extends Item implements Goods{
    private int classification = -1;

    public coffeebean(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 109;
        this.h = 79;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("coffeeBean.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Coffeebean";
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