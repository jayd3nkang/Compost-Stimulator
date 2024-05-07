import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class Garden extends Home{
    static JFrame frame;
    public int HEIGHT = 1000;
    public int WIDTH = 1000;
    int location;
    int buttonPressed = 0;
    int progression = 0;
    boolean gardenButtonPressed = true;
    int scores;
    JButton nextCycle;
    JButton endSummary;
    boolean showSummary;

    //sets up the endscreen, buttons for going to garden and nexy day
    public Garden(JButton input, JButton input2){
        this.setPreferredSize(new Dimension(1000,1000));
        Thread main = new Thread(new myRunnable());
        main.start();
        nextCycle = input;
        nextCycle.addActionListener(this);
        ImageIcon compostIcon = new ImageIcon("nextDayButton.png");
        ImageIcon toGarden = new ImageIcon("toGardenButton.png");
        nextCycle.setIcon(compostIcon);
        endSummary = input2;
        endSummary.addActionListener(this);
        endSummary.setIcon(toGarden);
        showSummary = true;
    }

    //constantly runs to draw needed graphics for garden
    public class myRunnable implements Runnable{
        public void run(){
            
            while(true){
                repaint();
                try{
              Thread.sleep(300);
            }
          catch(InterruptedException e){}
        }
          }
         
      }
      //draws the needed components for garden
      //draws the garden itself, the plants, and end of day summary 
    public void paintComponent(Graphics g){

        g.setColor(new Color(0,0,150));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        ImageIcon compost = new ImageIcon("compost.png");
        Image garden = compost.getImage();
        g.drawImage(garden, 0, 0, this);
        if (showSummary) {
          ImageIcon summary = new ImageIcon("summaryBackground.png");
          Image eodSum = summary.getImage();
          ImageIcon check = new ImageIcon("right.png");
          Image right = check.getImage();
          ImageIcon ex = new ImageIcon("wrong.png");
          Image wrong = ex.getImage();
          g.drawImage(eodSum, 200, 25, this);
          sortingPopup.list[0].x = 250;
          sortingPopup.list[1].x = 520;
          sortingPopup.list[2].x = 250;
          sortingPopup.list[3].x = 520;
          sortingPopup.list[4].x = 250;
          sortingPopup.list[5].x = 520;
          sortingPopup.list[6].x = 250;
          sortingPopup.list[7].x = 520;
          sortingPopup.list[0].y = 140;
          sortingPopup.list[1].y = 140;
          sortingPopup.list[2].y = 270;
          sortingPopup.list[3].y = 270;
          sortingPopup.list[4].y = 400;
          sortingPopup.list[5].y = 400;
          sortingPopup.list[6].y = 530;
          sortingPopup.list[7].y = 530;
          for (int i = 0; i < list.length; i++){
            list[i].drawSmall(g);
            if (sortingPopup.list[i].getClassification() == sortingPopup.list[i].isCompostable()) {
              g.drawImage(right, sortingPopup.list[i].x + 150, sortingPopup.list[i].y + 24, this);
            }
            else {
              g.drawImage(wrong, sortingPopup.list[i].x + 150, sortingPopup.list[i].y + 24, this);
            }
          }
          g.setFont(new Font("Comic Sans MS",Font.PLAIN,40));
            g.setColor(Color.BLACK);
            g.drawString(scores + " / 8", 680, 760);
        }
        
        scores = Home.score;
        
      //depending on the progression, game draws different state of the flower
      //gives an windy (swinging) effect but progression does not affect the flower growth
      //also shows the end of summary after sorting is done
      if(progression == 0){
        drawStageOne(g);
      }
      
      if(progression == 1){
        drawStageTwo(g);
      }
      
      if(progression == 2){
        drawStageThree(g);
      }
      progression++;
      if(progression > 2){
        progression = 0;
      }
      if (showSummary) {
        ImageIcon summary = new ImageIcon("summaryBackground.png");
        Image eodSum = summary.getImage();
        ImageIcon check = new ImageIcon("right.png");
        Image right = check.getImage();
        ImageIcon ex = new ImageIcon("wrong.png");
        Image wrong = ex.getImage();
        g.drawImage(eodSum, 200, 25, this);
        sortingPopup.list[0].x = 250;
        sortingPopup.list[1].x = 520;
        sortingPopup.list[2].x = 250;
        sortingPopup.list[3].x = 520;
        sortingPopup.list[4].x = 250;
        sortingPopup.list[5].x = 520;
        sortingPopup.list[6].x = 250;
        sortingPopup.list[7].x = 520;
        sortingPopup.list[0].y = 140;
        sortingPopup.list[1].y = 140;
        sortingPopup.list[2].y = 270;
        sortingPopup.list[3].y = 270;
        sortingPopup.list[4].y = 400;
        sortingPopup.list[5].y = 400;
        sortingPopup.list[6].y = 530;
        sortingPopup.list[7].y = 530;
        for (int i = 0; i < list.length; i++){
          sortingPopup.list[i].drawSmall(g);
          if (sortingPopup.list[i].getClassification() == sortingPopup.list[i].isCompostable()) {
            g.drawImage(right, sortingPopup.list[i].x + 150, sortingPopup.list[i].y + 24, this);
          }
          else {
            g.drawImage(wrong, sortingPopup.list[i].x + 150, sortingPopup.list[i].y + 24, this);
          }
        }
        g.setFont(new Font("Comic Sans MS",Font.PLAIN,40));
          g.setColor(Color.BLACK);
          g.drawString(scores + " / 8", 680, 760);
      }
    }
    //checks if the next day button has been pressed 
    //if true, then does multiple operations to prepare for the next cycle
  @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == nextCycle){

      sortingPopup.list[buttonPressed].changeLocation(1);
      seeGarden = false;
      Main.frame.setVisible(true);
      Main.seeG(seeGarden);
      Home.play = true;
      Home.gardenButtonStatus = true;
      buttonPressed  = 0;
      Home.dayCounter++;
      Home.index.i = dayCounter;
      showSummary = true;
      nextCycle.setVisible(false);
      endSummary.setVisible(true);
      for (int i = 0; i < list.length; i++) {
        sortingPopup.list[i].x = 320;
        sortingPopup.list[i].y = 180;
      }

    }

    //checks if garden button has been pressed 
    //if true, then closes end of day summary window and shows garden
    if(e.getSource() == endSummary){
      showSummary = false;
      endSummary.setVisible(false);
      nextCycle.setVisible(true);
      sortingPopup.list = new Item[8];
              for(int i = 0; i < list.length; i++){
              sortingPopup.list[i] = sortingPopup.randomItem();
              }
              sortingPopup.getList(list);
    }
    buttonPressed++;
  }

  //code below draws different stages of each flower stage depnding on how well the player composts.
  // Each flower stage  has three different stages to give it a wind effect
  public void drawStageOne(Graphics g){
    for(int i = 0; i < plants.length; i++){
      if(Home.totalScore < 0){
        plants[0].y = 415;
        plants[1].y = 475;
        plants[2].y = 425;
        plants[3].y = 410;
        plants[4].y = 435;
        plants[5].y = 445;
        plants[i].drawUnhealthy(g);
      }
      if (Home.totalScore >= 0 && Home.totalScore <=8){
        plants[0].y = 515;
        plants[1].y = 575;
        plants[2].y = 525;
        plants[3].y = 510;
        plants[4].y = 535;
        plants[5].y = 545;
        plants[i].drawSprout(g);
      }
      if(Home.totalScore > 8 && Home.totalScore <= 16){
        plants[i].drawFlowerS2(g);
      }
      if(Home.totalScore > 16 && Home.totalScore <= 24)
      if (scores > 5){
        plants[i].drawFlowerS3(g);
      }
      if(Home.totalScore > 24 && Home.totalScore <= 32){
        plants[i].drawFlowerS4(g);
      }
      if(Home.totalScore > 32){
        plants[i].drawHealthy(g);
      }
    }
  }

  public void drawStageTwo(Graphics g){
    for(int i = 0; i < plants.length; i++){
      if(Home.totalScore < 0){
        plants[i].drawUnhealthyS2(g);
      }
      if (Home.totalScore >= 0 && Home.totalScore <=8){
        plants[i].drawSproutS2(g);
      }
      if(Home.totalScore > 8 && Home.totalScore <= 16){
        plants[i].drawFlowerS2S2(g);
      }
      if(Home.totalScore > 16 && Home.totalScore <= 24)
      if (scores > 5){
        plants[i].drawFlowerS3S2(g);
      }
      if(Home.totalScore > 24 && Home.totalScore <= 32){
        plants[i].drawFlowerS4S2(g);
      }
      if(Home.totalScore > 32){
        plants[i].drawHealthyS2(g);
      }
    }
  }

  public void drawStageThree(Graphics g){
    for(int i = 0; i < plants.length; i++){
      if(Home.totalScore < 0){
        plants[i].drawUnhealthyS3(g);
      }
      if (Home.totalScore >= 0 && Home.totalScore <=8){
        plants[i].drawSproutS3(g);
      }
      if(Home.totalScore > 8 && Home.totalScore <= 16){
        plants[i].drawFlowerS2S3(g);
      }
      if(Home.totalScore > 16 && Home.totalScore <= 24)
      if (scores > 5){
        plants[i].drawFlowerS3S3(g);
      }
      if(Home.totalScore > 24 && Home.totalScore <= 32){
        plants[i].drawFlowerS4S3(g);
      }
      if(Home.totalScore > 32){
        plants[i].drawHealthyS3(g);
      }
    }
  }
  

}
