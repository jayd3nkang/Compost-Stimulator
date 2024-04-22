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
        // this.plant = new ImageIcon("sprout.png");
    //     if (this.state < 3) {
    //         this.y -= 180;
    //         plant = new ImageIcon("deadFlower.png"); 
    // }

    //     if (this.state > 4) {
    //         this.y -= 180;
    //         plant = new ImageIcon("flower.png"); 
    //         //System.out.println("DLFKJSDFLJSDLF");
    //     }
        //this.flower = this.plant.getImage(); 
        
    }
    public void drawSprout(Graphics g){
        plant = new ImageIcon("sprout.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawHealthy(Graphics g){
        plant = new ImageIcon("flower.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawUnhealthy(Graphics g){
        plant = new ImageIcon("deadFlower.png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
}
