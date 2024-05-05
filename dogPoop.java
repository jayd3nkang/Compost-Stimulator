import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class dogPoop extends Item{
    private int classification = -1;

    public dogPoop(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 128;
        this.h = 130;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("dogPoop.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Dog poop";
    }
    @Override

    public int isCompostable(){
        return 0;
    }
    @Override

    public int getClassification(){
        return classification;
    }
    @Override
    public void setClassification(int c){
        this.classification = c;
    }
}
