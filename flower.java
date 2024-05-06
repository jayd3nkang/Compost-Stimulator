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

    
    
    public flower(int ex, int why, int s){
        this.x = ex;
        this.y = why;
        this.state = s;
        
    }
    public void drawSprout(Graphics g){
        ImageIcon plant = new ImageIcon("flower1(1).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawSproutS2(Graphics g){
        ImageIcon plant = new ImageIcon("flower1(2).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawSproutS3(Graphics g){
        ImageIcon plant = new ImageIcon("flower1(3).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }


    public void drawFlowerS2(Graphics g){
        ImageIcon plant = new ImageIcon("flower2(1).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y, this);
    }
    public void drawFlowerS2S2(Graphics g){
        ImageIcon plant = new ImageIcon("flower2(2).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y, this);
    }
    public void drawFlowerS2S3(Graphics g){
        ImageIcon plant = new ImageIcon("flower2(3).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y, this);
    }
    



    public void drawFlowerS3(Graphics g){
        ImageIcon plant = new ImageIcon("flower3.png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y ,this);
    }
    public void drawFlowerS4(Graphics g){
        ImageIcon plant = new ImageIcon("flower4.png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y, this);
    }
    public void drawHealthy(Graphics g){
        ImageIcon plant = new ImageIcon("flower5.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawUnhealthy(Graphics g){
        ImageIcon plant = new ImageIcon("deadFlower.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
}
