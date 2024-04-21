import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class battery extends Item{

    public battery(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 101;
        this.h = 92;
    }

    public void draw(Graphics g){
        ImageIcon carrot = new ImageIcon("battery.png");
        Image pic = carrot.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
}