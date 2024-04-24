import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class Home extends Main{
  static JFrame frame;
  JButton button = new JButton();
  int rColor = 10;
  int gColor = 33;
  int bColor = 42;
  int xSun;
  int ySun;
  int xMoon;
  int yMoon;
  boolean changeDay;
  boolean changeNight;
  static int counter;
  int count;
  public static Boolean cycleEnd = false;
  int plantNumber = 1;
  public static Item[] list = new Item[8];
  public flower[] plants = new flower[6];
  int score;

  //using graphics to change the background sky color constantly 
  //as of 4/19/24, 21:52, it can only go through one cycle of
  //day and night.
  public class myRunnable implements Runnable{
    public void run(){
      while(true){
        //System.out.println("qwerqwerqwerqwer");
        if (!cycleEnd)
        {dayToNight();
        nightToDay();}
        count++;
        repaint();
        try{
          //always 30
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
    this.setPreferredSize(new Dimension(1000,1000));
    Thread main = new Thread(new myRunnable());
    main.start();
    changeDay = false;
    changeNight = false;
    counter = 0;
    xSun = -175;
    ySun = 200;
    xMoon = -175;
    yMoon = 200;

    plants[0] = new flower(15, 370, 0);
    plants[1] = new flower(100, 430, 0);
    plants[2] = new flower(270, 378, 0);
    plants[3] = new flower(380, 380, 0);
    plants[4] = new flower(670, 380, 0);
    plants[5] = new flower(830, 380, 0);
  
  }
//setting up the canvas 

  //drawing the components that need to be drawn
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

   
    g.drawImage(iconHouse,0,0,this);
    g.drawImage(iconSun, xSun,ySun,this);
    g.drawImage(iconMoon, xMoon, yMoon,this);


    ImageIcon compost = new ImageIcon("compost.png");
    Image garden = compost.getImage();
    if (sortingPopup.popEnd) {
      g.drawImage(garden, 0, 0, this);
      checkScore(list);
      // plants[0].draw(g);
      // plants[1].draw(g);
      // plants[2].draw(g);
      // plants[3].draw(g);
      // plants[4].draw(g);
      // plants[5].draw(g);
      for(int i = 0; i < plants.length; i++){
        if (score < 3){
          plants[i].drawUnhealthy(g);
        }
        if (score > 5){
          plants[i].drawHealthy(g);
        }
       if (score <= 5 && score >= 3) {plants[i].drawSprout(g);}
        plantNumber++;
      }
    }
  }

  //method that changes from day to night 
  public void dayToNight(){
    //only allowing to change colors to night 
    //only if it is already day(hence !changeNight) and 
    //the user wants to day (hence the changeDay)
    if(!changeNight && changeDay){
      this.rColor+=2;
      this.gColor+=2;
      this.bColor+=2;

      xSun += 8;
      ySun -= 3;
      counter++;
    }
    if(xSun > 1050){
      xSun = -175;
      ySun = 200;
    }
    //this is the mechanics that indicates that day to night cycle has ended 
    if(counter > 75){
      changeDay = false;
      changeNight = true;
      counter = 0;
      //System.exit(1);
    }
   
  }

  //method that changes from night to day
  public void nightToDay(){
    //only allowing to change colors to day 
    //only if it is already night(hence !changeDay) and
    //the user wants it to day (hence the changeNight)
    if(!changeDay && changeNight){
      this.rColor-=2;
      this.gColor-=2;
      this.bColor-=2;
      xSun += 8; 
      ySun += 3;
      xMoon += 8;
      yMoon -= 3;
      // System.out.println(counter + "night");
      // System.out.println(xSun);
      //System.out.println(rColor + " " + gColor + " " + bColor + " night");
      //System.out.println(counter + " night");
      counter++;
    }

    if(xSun > 1050){
      xSun = -175;
      ySun = 200;
    }

    if(xMoon > 420){
      xMoon += 8;
      yMoon += 3;
      
    }
    if(xMoon > 1050){
      xMoon = -175;
      yMoon = 200;
    }

    //this is the mechanics that indicates that night to day cycle has ended 
    if(counter > 75){
      changeNight = false;
      changeDay = true;
      counter = 0;
      cycleEnd = true;
      //System.exit(1);
    }


  }

  public void checkScore(Item[] list){
    int x = 0;
    int y = 0;
    score = 0;
    for (int i = 0; i < list.length; i++){
      if (list[i].l == list[i].p) {
        score++;
        for (int j = 0; j < plants.length; j++){
          plants[j].state = score;
          System.out.println(plants[j].state);
        }
      }
    }

    // plantNumber is an int denoting which plant is being drawn
    System.out.println("Score: " + score);
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

}