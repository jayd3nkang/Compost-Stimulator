import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class eggSHell extends Item{

    public eggSHell(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 150;
        this.h = 96;
        this.p = 1;
    }

    // public void draw(Graphics g){
    //     //System.out.println("hello");
    // }

   // @Override
    public void draw(Graphics g) {
        ImageIcon object = new ImageIcon("eggSHell.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
    public String toString(){
        return "Eggshell";
    }
}