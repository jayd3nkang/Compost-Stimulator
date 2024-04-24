import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class potato extends Item{

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
    // public void isCompostable(){
    //     this.p = 1;
    // }
}