import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class plasticStraw extends Item implements Goods{
    private int classification = -1;

    public plasticStraw(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 70;
        this.h = 198;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("plasticStraw.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Plastic Straw";
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
