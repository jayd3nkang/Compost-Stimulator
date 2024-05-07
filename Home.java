import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Home extends Main implements ActionListener{
  static JFrame popUpControl;
  JButton button = new JButton();

  // code related to cycle of day/night
  // determines the movement of the sun and moon, as well as the color of the sky
  int rColor = 10;
  int gColor = 33;
  int bColor = 42;
  double xSun;
  double ySun;
  double xMoon;
  double yMoon;
  static int dayCounter;
  static day index;

  // fields associated with keeping track of the user's score each day, their total score which is a sum of every day that has passed,
  // and the transition between the different parts of the game
  public static int score;
  public static int totalScore;
  public static Boolean cycleEnd = false;
  public static boolean gardenButtonStatus = true;
  boolean sunDown;
  public static boolean play;

  double[] starX = new double[200];
  double[] starY = new double[200];
  double[] starR = new double[200];


  // code related to keeping the garden
  int plantNumber = 1;
  public static Item[] list = new Item[8];
  public static flower[] plants = new flower[6];
  //int score;

  // the timer for the loading screen and the boolean that determines if the player is past the main menu
  int loadingTimer;
  boolean mainMenu;

  public class myRunnable implements Runnable{
    public void run(){
      sunDown = false;
      play = true;
      loadingTimer = 0;
      mainMenu = false;

      while(true){
        if (gardenButtonStatus && loadingTimer > 500 && !mainMenu){
          cycle();
          if(xSun >= 525 && (int)ySun == 799){
            gardenButtonStatus = false;
            pop.setVisible(true);
            frame.setVisible(false);
          }
        }
        if(!gardenButtonStatus && loadingTimer > 500 && !mainMenu){
          cycleEnd = true;
          if(xSun >= 500 && (int)ySun == 799){
            xSun--;
          }
        }
        loadingTimer++;
        repaint();
        try{
          Thread.sleep(10);
        }
      catch(InterruptedException e){}
    }
      }

  }
  //setting up the size, thread and variables so
  //the cycle change can happen
  public Home(){
    plants[0] = new flower(25, 305, 0);
    plants[1] = new flower(130, 365, 0);
    plants[2] = new flower(290, 325, 0);
    plants[3] = new flower(480, 310, 0);
    plants[4] = new flower(680, 315, 0);
    plants[5] = new flower(855, 325, 0);
  }
  public Home(JFrame f, JButton start){
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
    startButton.setVisible(mainMenu);
    startButton.addActionListener(this);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource() == startButton){
      mainMenu = false;
      startButton.setVisible(false);
    }

  }
  //setting up the canvas 

  //drawing the components that need to be drawn
  public void paintComponent(Graphics g){
    //drawing the sky color
    g.setColor(new Color(rColor, gColor, bColor));
    g.fillRect(0,0, 1000, 1000);

    //setting the images for the sun, moon, and home
    ImageIcon sunPic = new ImageIcon("sun.png");
    ImageIcon housePic = new ImageIcon("house.png");
    ImageIcon moonPic = new ImageIcon("moon.png");
    Image iconSun = sunPic.getImage();
    Image iconHouse = housePic.getImage();
    Image iconMoon = moonPic.getImage();


    //drawing the stars
    g.setColor(Color.WHITE);
    for (int i = 0; i < starX.length; i++){
      g.fillOval((int)starX[i],(int) (starY[i]), 5, 5);
    }

    //drawing sun, moon, and home
    g.drawImage(iconHouse,0,0,this);
    g.drawImage(iconSun, (int) (xSun - 100), (int)(ySun - 101) + 1000,this);
    g.drawImage(iconMoon, (int) (xMoon + 933),(int) (yMoon - 77.5) ,this);
    index.paint(g);
    ImageIcon JEM = new ImageIcon("jemScreen.png");
    Image loadingScreen = JEM.getImage();
    ImageIcon menuIcon = new ImageIcon("startScreen.png");
    Image startSreen = menuIcon.getImage();
    if (loadingTimer < 500 && !mainMenu) {
      g.drawImage(loadingScreen, 0, 0, this);
      g.setColor(Color.WHITE);
      if (loadingTimer > 200) g.fillOval(460, 700, 20, 20);
      if (loadingTimer > 300) g.fillOval(490, 700, 20, 20);
      if (loadingTimer > 400) g.fillOval(520, 700, 20, 20);
      if (loadingTimer == 499) {
        mainMenu = true;
        startButton.setVisible(true);
      }
    }
    if (mainMenu) {
      g.drawImage(startSreen, 0, -100, this);
    }
  }


  //method that changes from day to night 
  public void cycle(){
    if (!sunDown) {
      xSun += 5;
      xMoon -= 5;
      for (int i = 0; i < starX.length; i++){
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
        starX[i] += 5;
        starY[i] = 1000 - (Math.sqrt(Math.pow(starR[i], 2) - Math.pow((starX[i] - 500), 2))); 
      }
      if (xSun <= -100) sunDown = false;
  }
  yMoon = (ySun * -1) + 1000;
  if (xSun <= 500 && !sunDown && xSun % 2 == 0) {
    rColor += 1;
    gColor += 1;
    bColor += 2;
  }
  if (xSun > 500 && !sunDown && xSun % 2 == 0) {
    rColor -= 1;
    gColor -= 1;
    bColor -= 2;
  }
  if (yMoon <= 500 && xSun <= 500) play = false;
}
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

}

//creates a class to draw and chagne the day visual output on Home Screen
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
