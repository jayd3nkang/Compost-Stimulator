import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

class Home extends Main{
  //sets up frame and 
  static JFrame popUpControl;

  int rColor = 10;
  int gColor = 33;
  int bColor = 42;

  double xSun;
  double ySun;
  double xMoon;
  double yMoon;


  static int dayCounter;
  static day index;

  //sets up things related to cycle change, plants growing, and moving from garden to home and vice versa
  int count;
  public static int score;
  public static int totalScore;
  public static Boolean cycleEnd = false;
  public static boolean gardenButtonStatus = true;
  boolean sunDown;
  public static boolean play;

  //sets up stars for night cycle
  double[] starX = new double[200];
  double[] starY = new double[200];
  double[] starR = new double[200];


  // code related to keeping the garden
  int plantNumber = 1;
  public static Item[] list = new Item[8];
  public flower[] plants = new flower[6];

  public class myRunnable implements Runnable{
    public void run(){
      //initial setup for cycle and different screens
      sunDown = false;
      play = true;

      //1. constantly checks if the conditions to change from home screen to 
      //garden screen is met. If it is, then changes couple booleans to show 
      //the correct screen on display 
      //2. While checking the correct display, also checks the cycle and at appropriate times 
      //changes the cycles
      while(true){

        if (gardenButtonStatus){
          cycle();
          if(xSun >= 525 && (int)ySun == 799){
            gardenButtonStatus = false;
            pop.setVisible(true);
            frame.setVisible(false);
          }
        }
        if(!gardenButtonStatus){
          cycleEnd = true;
          if(xSun >= 500 && (int)ySun == 799){
            xSun--;
            //score = 0;
          }
        }
        count++;
        repaint();
        try{
          Thread.sleep(10);
        }
      catch(InterruptedException e){}
    }
      }

  }

  //sets up flower's initial x and y positions
  public Home(){
    plants[0] = new flower(25, 305, 0);
    plants[1] = new flower(130, 365, 0);
    plants[2] = new flower(290, 325, 0);
    plants[3] = new flower(480, 310, 0);
    plants[4] = new flower(680, 315, 0);
    plants[5] = new flower(855, 325, 0);
  }
  //sets up crucial aspects of the game; size, starts thread, index and etc
  public Home(JFrame f){
    this();
    this.setPreferredSize(new Dimension(1000,1000));
    Thread main = new Thread(new myRunnable());
    main.start();
    dayCounter = 1;
    index = new day(750, 100, dayCounter);
    popUpControl = f;  
    for (int i = 0; i < starX.length; i++){
      starX[i] = Math.random() * 1600;
      starY[i] = Math.random() * 1600;
      starR[i] = Math.sqrt(Math.pow(starX[i], 2) + Math.pow(starY[i], 2));
    } 
  }

  //drawing the components that need to be drawn
  //draws the sun, moon, house, and stars
  public void paintComponent(Graphics g){
    //drawing the sky color
    g.setColor(new Color(rColor, gColor, bColor));
    g.fillRect(0,0, 1000, 1000);

    //drawing the sun and home
    ImageIcon sunPic = new ImageIcon("sun.png");
    ImageIcon housePic = new ImageIcon("house.png");
    ImageIcon moonPic = new ImageIcon("moon.png");
    Image iconSun = sunPic.getImage();
    Image iconHouse = housePic.getImage();
    Image iconMoon = moonPic.getImage();


    g.setColor(Color.WHITE);
    for (int i = 0; i < starX.length; i++){
      g.fillOval((int)starX[i],(int) (starY[i]), 5, 5);
    }
    g.drawImage(iconHouse,0,0,this);
    g.drawImage(iconSun, (int) (xSun - 100), (int)(ySun - 101) + 1000,this);
    g.drawImage(iconMoon, (int) (xMoon + 933),(int) (yMoon - 77.5) ,this);
    index.paint(g);

  }


  //method that changes from day to night 
  public void cycle(){
    if (!sunDown) {
      xSun += 5;
      xMoon -= 5;
      for (int i = 0; i < starX.length; i++){
        // starVX[i] = 1000 - starY[i];
        // starVY[i] = starX[i] - 500;
        starX[i] -= 5;
        starY[i] = 1000 + (Math.sqrt(Math.pow(starR[i], 2) - Math.pow((starX[i] - 500), 2))); 
      }
    }
    ySun = -1 * (Math.sqrt(640000 - Math.pow((xSun - 500), 2)));

  if (xSun >= 1000) sunDown = true;

  if (sunDown) {
      xSun -= 5;
      xMoon += 5;
   
      ySun = (Math.sqrt(640000 - Math.pow((xSun - 500), 2)));
      for (int i = 0; i < starX.length; i++){
        // starVX[i] = 1000 - starY[i];
        // starVY[i] = starX[i] - 500;
        starX[i] += 5;
        starY[i] = 1000 - (Math.sqrt(Math.pow(starR[i], 2) - Math.pow((starX[i] - 500), 2))); 
      }

      if (xSun <= 0) sunDown = false;
  }

  yMoon = (ySun * -1) + 1000;
  if (xSun <= 500 && !sunDown && xSun % 2 == 0) {
    rColor += 2;
    gColor += 2;
    bColor += 4;
  }
  if (xSun > 500 && !sunDown && xSun % 2 == 0) {
    rColor -= 2;
    gColor -= 2;
    bColor -= 4;
  }

  if (yMoon <= 500 && xSun <= 500) play = false;
}

  //checks the score for this round and total accumulation of rounds played
  //used later to the draw the different states of flowers
  public int checkScore(){
    score = 0;
    for(int i = 0; i < list.length; i++){
      if(sortingPopup.list[i].getClassification() == sortingPopup.list[i].isCompostable()){
        score++;
      }
      else{
        totalScore--;
      }
    }
    totalScore+=score;
    return score;
  }


  // gets the new list of random items each cycle
  public static void getList(Item[] items){
    for (int i = 0; i < list.length; i++){
      list[i] = items[i];
    }
  }

//creating a class to that shows the day player is on
}
class day{
  public int x;
  public int y;
  public int i;
  public String a;

  public day(int pX, int pY, int day){
      this.x = pX;
      this.y = pY;
      this.i = day;
  }
  public void paint(Graphics g){
      g.setColor(Color.WHITE);
      g.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
      this.a = "Day ";
      this.a += this.i;
      g.drawString(this.a, this.x, this.y);
  }
}

