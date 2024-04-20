import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class sortingPopup extends Main{
    static JFrame frame;
  JButton button = new JButton();
  public sortingPopup(){
    this.setPreferredSize(new Dimension(1000,1000));
    Thread main = new Thread(new myRunnable());
    main.start();
  }
  public class myRunnable implements Runnable{
    public void run(){
      while(true){
        //System.out.println("qwerqwerqwerqwer");
        repaint();
        try{
          Thread.sleep(100);
        }
      catch(InterruptedException e){}
    }
      }
     
  }

  public void sorting(){

  }

  public void paintComponent(Graphics g){
    
  }

}
