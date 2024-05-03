import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class Home extends Main{
  static JFrame popUpControl;
  JButton button = new JButton();

  // code related to cycle of day/night
  int rColor = 10;
  int gColor = 33;
  int bColor = 42;
  double xSun;
  public static double ySun;
  double xMoon;
  double yMoon;

  // double startXSun = 0.0;
  // double startXMoon = 0.0;
  // double startYSun = -628.0;
  // double startYMoon = 1628.0;

  // double xSunCal;
  // double ySunCal;
  // double xMoonCal;
  // double yMoonCal;

  static int counter;
  int count;
  public static Boolean cycleEnd = false;
  public static boolean gardenButtonStatus = true;
  boolean sunDown;
  public static boolean play;
  // double starSize[];
  // double starX[];
  // double starY[];
  // double starR[];


  // code related to keeping the garden
  int plantNumber = 1;
  public static Item[] list = new Item[8];
  public flower[] plants = new flower[6];
  int score;

  //using graphics to change the background sky color constantly 
  //as of 4/19/24, 21:52, it can only go through one cycle of
  //day and night.
  public class myRunnable implements Runnable{
    public void run(){
      sunDown = false;
      play = true;
      
      while(true){
        // System.out.println("x sun = " + xSun);
        // System.out.println("y sun = " + ySun);
        // System.out.println(gardenButtonStatus);
        if (gardenButtonStatus){
          cycle();
          if(xSun >= 525 && (int)ySun == 799){
            gardenButtonStatus = false;
          }
        }
        if(!gardenButtonStatus){
          // play = false;
          cycleEnd = true;
          if(xSun >= 500 && (int)ySun == 799){
            ySun++;
            //gardenButtonStatus = true;
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
  //setting up the size, thread and variables so
  //the cycle change can happen
  //haven't implemented the moving of sun and car moving yet
  public Home(){
    plants[0] = new flower(15, 370, 0);
    plants[1] = new flower(100, 430, 0);
    plants[2] = new flower(270, 378, 0);
    plants[3] = new flower(470, 380, 0);
    plants[4] = new flower(670, 380, 0);
    plants[5] = new flower(830, 380, 0);
  }
  public Home(JFrame f){
    this();
    System.out.println("HOLA");
    this.setPreferredSize(new Dimension(1000,1000));
    Thread main = new Thread(new myRunnable());
    main.start();
    counter = 0;

    // starX = new double[50];
    // starY = new double[50];
    // starR = new double[50];
    // starSize = new double[50];

    // for (int i = 0; i < starR.length; i++){
    //   starX[i] = Math.random() * 1000;
    //   starY[i] = (Math.random() * 1000) + 1000;
    //   starR[i] = Math.random() * 250000 + 10000;
    //   starSize[i] = Math.random() * 10;
    // }

    // plants[0] = new flower(15, 370, 0);
    // plants[1] = new flower(100, 430, 0);
    // plants[2] = new flower(270, 378, 0);
    // plants[3] = new flower(470, 380, 0);
    // plants[4] = new flower(670, 380, 0);
    // plants[5] = new flower(830, 380, 0);
    popUpControl = f;  
  }
//setting up the canvas 

  //drawing the components that need to be drawn
  public void paintComponent(Graphics g){
    //xSun = homeXSun;
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


    g.drawImage(iconHouse,0,0,this);
    g.drawImage(iconSun, (int) (xSun - 100), (int)(ySun - 101) + 1000,this);
    g.drawImage(iconMoon, (int) (xMoon + 933),(int) (yMoon - 77.5) ,this);
  }

  //method that changes from day to night 
  public void cycle(){
    if (!sunDown) {
      xSun += 5;
      xMoon -= 5;

    }

    // if((int)ySun == 799){
    //   ySun = 800.0;
    // }
    // else{
    //   ySun = -1 * (Math.sqrt(640000 - Math.pow((xSun - 500), 2)));

    // }
    //System.out.println("before y: " + ySun);
    ySun = -1 * (Math.sqrt(640000 - Math.pow((xSun - 500), 2)));
    System.out.println("after y: " + ySun);



  if (xSun >= 1000) sunDown = true;

  if (sunDown) {
      xSun -= 5;
      xMoon += 5;
      // if((int)ySun == 799){
      //   ySun = 800.0;
      // }
      // else{
      //  ySun = (Math.sqrt(640000 - Math.pow((xSun - 500), 2)));
      // }
      double temp = ySun;
      System.out.println("beforeeeeee y: " + ySun + " " + temp);
      ySun = (Math.sqrt(640000 - Math.pow((xSun - 500), 2)));
      //ySun = temp;
      System.out.println("aferterrrr y: " + ySun);


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
  //if(yMoonCal <= 500 && xSunCal <= 500) play = false;
}
  public void checkScore(Item[] list){
    score = 0;
    for (int i = 0; i < list.length; i++){
      if (list[i].l == list[i].p) {
        score++;
        for (int j = 0; j < plants.length; j++){
          plants[j].state = score;
          //System.out.println(plants[j].state);
        }
      }
    }

    // plantNumber is an int denoting which plant is being drawn
   // System.out.println("Score: " + score);
    if (score >= 5) {
      // for (int j = 0; j < plants.length; j++){
      //   for (int k = 0; k < plantNumber; k++){
      //   if (k == 0) {plants[j].x = 15; plants[j].y = 370;}
      //   if (k == 1) {plants[j].x = 100; plants[j].y = 430;}
      //   if (k == 2) {plants[j].x = 270; plants[j].y = 380;}
      //   if (k == 3) {plants[j].x = 380; plants[j].y = 380;}
      //   if (k == 4) {plants[j].x = 670; plants[j].y = 380;}
      //   if (k == 5) {plants[j].x = 830; plants[j].y = 380;}
      //   plants[j].draw(getGraphics());
      //   }
      // }
      for (int i = 0; i < plants.length; i++){
        plants[i].state = score;
      }
    }
    else for (int i = 0; i < plants.length; i++){
      plants[i].state--;
    }
    // for(int i = 0; i < plants.length; i++){
    //   plants[i].draw(getGraphics());
    // }
  }


  // gets the new list of random items each cycle
  public static void getList(Item[] items){
    for (int i = 0; i < list.length; i++){
      list[i] = items[i];
    }
  }
  public void setGardenButtonStatus(boolean tf){
    this.gardenButtonStatus = tf;
  }

}