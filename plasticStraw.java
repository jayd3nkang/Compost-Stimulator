import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class plasticStraw extends Item{

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
}