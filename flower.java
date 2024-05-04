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
    public int state;
    ImageIcon plant;
    
    
    public flower(int ex, int why, int s){
        this.x = ex;
        this.y = why;
        this.state = s;
        
    }
    public void drawSprout(Graphics g){
        plant = new ImageIcon("flower1.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawFlowerS2(Graphics g){
        plant = new ImageIcon("flower2.png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y, this);
    }
    public void drawFlowerS3(Graphics g){
        plant = new ImageIcon("flower3.png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y ,this);
    }
    public void drawFlowerS4(Graphics g){
        plant = new ImageIcon("flower4.png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y, this);
    }
    public void drawHealthy(Graphics g){
        plant = new ImageIcon("flower5.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawUnhealthy(Graphics g){
        plant = new ImageIcon("deadFlower.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
}
