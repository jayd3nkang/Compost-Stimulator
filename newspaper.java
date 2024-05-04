import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class newspaper extends Item{

    public newspaper(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 309;
        this.h = 208;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("newspaper.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Newspaper";
    }
}
