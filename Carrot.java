import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Carrot extends Item {
    public Carrot(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 128;
        this.h = 189;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon carrot = new ImageIcon("carrot.png");
        Image pic = carrot.getImage();
        g.drawImage(pic, x, y, this);
       
    }
    public String toString(){
        return "Carrot";
    }

}
