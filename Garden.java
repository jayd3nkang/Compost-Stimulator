import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Garden extends Home implements ActionListener{ 
    static JFrame frame;
    public int HEIGHT = 1000;
    public int WIDTH = 1000;
    JButton nextCycle;
    int location;
    int buttonPressed = 0;
    boolean gardenButtonPressed = true;
    public Garden(JButton input){
        this.setPreferredSize(new Dimension(1000,1000));
        Thread main = new Thread(new myRunnable());
        main.start();
        nextCycle = input;
        nextCycle.addActionListener(this);
        ImageIcon compostIcon = new ImageIcon("nextDayButton.png");
        nextCycle.setIcon(compostIcon);
    }
    public class myRunnable implements Runnable{
        public void run(){
            
            while(true){
                // sorting();
                repaint();
                try{
              Thread.sleep(100);
            }
          catch(InterruptedException e){}
        }
          }
         
      }
    public void paintComponent(Graphics g){
        // blue background...you guys did that out already!
        g.setColor(new Color(0,0,150));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        ImageIcon compost = new ImageIcon("compost.png");
        Image garden = compost.getImage();

        g.drawImage(garden, 0, 0, this);
        checkScore(list);
      
      for(int i = 0; i < plants.length; i++){
        if (score < 3){
          plants[i].drawUnhealthy(g);
        }
        if (score > 5){
          plants[i].drawHealthy(g);
        }
       if (score <= 5 && score >= 3) {plants[i].drawSprout(g);}
      }
    }
    @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == nextCycle){

      list[buttonPressed].changeLocation(1);
      System.out.println("compost button clicked");
      seeGarden = false;
      Main.seeG(seeGarden);
      Home.play = true;
      Home.gardenButtonStatus = true;
      buttonPressed  = 0;
      
    }
    buttonPressed++;
  }
  

}
