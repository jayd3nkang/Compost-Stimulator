import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class sortingPopup extends Home{
    static JFrame frame;
    // list of items to be sorted every cycle
    Item[] list;
  JButton button = new JButton();
  public sortingPopup(){
    this.setPreferredSize(new Dimension(800,500));
    Thread main = new Thread(new myRunnable());
    main.start();
  }
  public class myRunnable implements Runnable{
    public void run(){
        // every cycle, 8 items will need to be sorted
        // popup goes through every item with a description of all the items
        list = new Item[8];
        for (int i = 0; i < list.length; i++){
            list[i] = randomItem();
        }
        while(true){
            sorting();
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

  public Item randomItem(){
    int r = (int) (Math.random() * 40) + 1;
    Item i = new Carrot(0, 0, 2, 2);
    return i;
  }

  public void paintComponent(Graphics g){
    g.setColor(new Color(40,60,40));
    g.fillRect(0, 0, 800, 500);

  }

}
