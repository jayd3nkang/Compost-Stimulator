import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class flower extends Main{
    int x;
    int y;
    public int state;

    
    //sets ups up flower's initial x, y positions and state
    public flower(int ex, int why, int s){
        this.x = ex;
        this.y = why;
        this.state = s;
        
    }

    //creating methods to draw srpout stages 
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

    //creating methods to draw blossoming stages 
    public void drawFlowerS2(Graphics g){
        ImageIcon plant = new ImageIcon("flower2(1).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-50, this);
    }
    public void drawFlowerS2S2(Graphics g){
        ImageIcon plant = new ImageIcon("flower2(2).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-50, this);
    }
    public void drawFlowerS2S3(Graphics g){
        ImageIcon plant = new ImageIcon("flower2(3).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-50, this);
    }
    


    //creating methods to draw almost fully blossomed stages 
    public void drawFlowerS3(Graphics g){
        ImageIcon plant = new ImageIcon("flower3(1).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-100,this);
    }
    public void drawFlowerS3S2(Graphics g){
        ImageIcon plant = new ImageIcon("flower3(2).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-100, this);
    }
    public void drawFlowerS3S3(Graphics g){
        ImageIcon plant = new ImageIcon("flower3(3).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-100,this);
    }


    //creating methods to draw the one stage before a fully blossomed flower stages 
    public void drawFlowerS4(Graphics g){
        ImageIcon plant = new ImageIcon("flower4(1).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-110, this);
    }
    public void drawFlowerS4S2(Graphics g){
        ImageIcon plant = new ImageIcon("flower4(2).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-110, this);
    }
    public void drawFlowerS4S3(Graphics g){
        ImageIcon plant = new ImageIcon("flower4(3).png");
        Image flower = plant.getImage();
        g.drawImage(flower, x, y-110, this);
    }

     //creating methods to draw the fully blossomed stages 
    public void drawHealthy(Graphics g){
        ImageIcon plant = new ImageIcon("flower5(1).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y-200, this);
    }
    public void drawHealthyS2(Graphics g){
        ImageIcon plant = new ImageIcon("flower5(2).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y-200, this);
    }
    public void drawHealthyS3(Graphics g){
        ImageIcon plant = new ImageIcon("flower5(3).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y-200, this);
    }

    //creating methods to draw dead flower stages
    public void drawUnhealthy(Graphics g){
        ImageIcon plant = new ImageIcon("deadFlower(3).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawUnhealthyS2(Graphics g){
        ImageIcon plant = new ImageIcon("deadFlower(2).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
    public void drawUnhealthyS3(Graphics g){
        ImageIcon plant = new ImageIcon("deadFlower(1).png");
        Image flower = plant.getImage();   
        g.drawImage(flower, x, y, this);
    }
}
