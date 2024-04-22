import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class flower extends Main{
    int x;
    int y;
    int state;
    public flower(int ex, int why, int s){
        this.x = ex;
        this.y = why;
        this.state = s;
    }
    public void draw(Graphics g){
        ImageIcon plant = new ImageIcon("flower.png");
        ImageIcon unhealthyPlant = new ImageIcon("carrot.png");
        Image flower = plant.getImage();
        if (this.state < 0) {flower = unhealthyPlant.getImage();}
        g.drawImage(flower, x, y, this);
    }
}
