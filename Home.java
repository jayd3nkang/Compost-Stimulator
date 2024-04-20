//import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
// import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

class Home extends JPanel{
  static JFrame frame;
  JButton button = new JButton();
  int rColor = 10;
  int gColor = 33;
  int bColor = 42;
  boolean changeDay;
  boolean changeNight;
  static int counter;

  //using graphics to change the background sky color constantly 
  //as of 4/19/24, 21:52, it can only go through one cycle of
  //day and night. When attempting the second cycle the rbg goes out of bounds 
  public class myRunnable implements Runnable{
    public void run(){
      while(true){
        //System.out.println("qwerqwerqwerqwer");
        dayToNight();
        nightToDay();
        repaint();
        try{
          Thread.sleep(100);
        }
      catch(InterruptedException e){}
    }
      }
     
  }
  //setting up the size, thread and variables so
  //the cycle change can happen
  //haven't implemented the moving of sun and car moving yet
  public Home(){
    this.setPreferredSize(new Dimension(1000,1000));
    Thread main = new Thread(new myRunnable());
    main.start();
    changeDay = false;
    changeNight = false;
    counter = 0;
  }
//setting up the canvas 
  public static void main(String[] args){
    Home ex = new Home();
    frame = new JFrame("New");
    frame.setContentPane(ex);
    frame.pack();
    frame.setVisible(true);

    //System.out.println("BEFORE: " + ex.changeDay);
    ex.changeDay = true;
    //System.out.println("AFTER: " + ex.changeDay);
  }

  //drawing the components that need to be drawn
  public void paintComponent(Graphics g){
    //drawing the sky color
    g.setColor(new Color(rColor, gColor, bColor));
    g.fillRect(0,0, 1000, 1000);

    //drawing the sun and home
    ImageIcon sunPic = new ImageIcon("sun.png");
    ImageIcon housePic = new ImageIcon("house.png");
    Image iconSun = sunPic.getImage();
    Image iconHouse = housePic.getImage();
   
    g.drawImage(iconHouse,0,0,this);
    g.drawImage(iconSun, 100,100,this);

    //System.out.println("PLS WORK");

  }

  //method that changes from day to night 
  public void dayToNight(){
    //only allowing to change colors to night 
    //only if it is already day(hence !changeNight) and 
    //the user wants to day (hence the changeDay)
    if(!changeNight && changeDay){
      this.rColor+=3;
      this.gColor+=3;
      this.bColor+=3;
    }
    counter++;

    if(counter > 68){
      changeDay = false;
      changeNight = true;
      counter = 0;
      //System.out.println("THE IF STATEMENT IS WORKING");
      //System.exit(1);
    }
    //System.out.println("hello");
  }

  //method that changes from night to day
  public void nightToDay(){
    //only allowing to change colors to day 
    //only if it is already night(hence !changeDay) and
    //the user wants it to day (hence the changeNight)
    if(!changeDay && changeNight){
      this.rColor-=3;
      this.gColor-=3;
      this.bColor-=3;
    }

    if(counter > 68){
      changeNight = false;
      changeDay = true;
      counter = 0;
    }

    counter++;
  }
}