import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class shirt extends Item{

    public shirt(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 228;
        this.h = 187;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("shirt.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public String toString(){
        return "Shirt";
    }
}
