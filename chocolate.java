import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class chocolate extends Item{

    public chocolate(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 167;
        this.h = 134;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("chocolate.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Chocolate";
    }
}
