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

public class Garden extends Home implements ActionListener{
    static JFrame frame;
    public int HEIGHT = 1000;
    public int WIDTH = 1000;
    JButton nextCycle;
    int location;
    int buttonPressed = 0;
    int progression = 0;
    boolean gardenButtonPressed = true;
   // Item[] copyList = new Item[8];
    int scores;

    JButton endSummary;
    boolean showSummary;

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
    public class myRunnable implements Runnable{
        public void run(){
            
            while(true){
                // sorting();
                repaint();
                try{
              Thread.sleep(300);
              //System.out.println(score);
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
        System.out.println("Scores: " + scores + " Total Score " + Home.totalScore);
        
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
  @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == nextCycle){

      sortingPopup.list[buttonPressed].changeLocation(1);
      System.out.println("compost button clicked");
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
        // for (int r = 0; r < 40; r++){
        //   if (r == 1) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 2) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 3) {list[i].x = 320; list[i].y = 200;}
        //   if (r == 4) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 5) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 6) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 7) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 8) {list[i].x = 350; list[i].y = 180;}
        //   if (r == 9) {list[i].x = 310; list[i].y = 180;}
        //   if (r == 10) {list[i].x = 320; list[i].y = 200;}
        //   if (r == 11) {list[i].x = 350; list[i].y = 200;}
        //   if (r == 12) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 13) {list[i].x = 330; list[i].y = 180;}
        //   if (r == 14) {list[i].x = 350; list[i].y = 180;}
        //   if (r == 15) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 16) {list[i].x = 320; list[i].y = 200;}
        //   if (r == 17) {list[i].x = 320; list[i].y = 200;}
        //   if (r == 18) {list[i].x = 330; list[i].y = 200;}
        //   if (r == 19) {list[i].x = 350; list[i].y = 180;}
        //   if (r == 20) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 21) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 22) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 23) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 24) {list[i].x = 350; list[i].y = 180;}
        //   if (r == 25) {list[i].x = 350; list[i].y = 180;}
        //   if (r == 26) {list[i].x = 320; list[i].y = 200;}
        //   if (r == 27) {list[i].x = 330; list[i].y = 180;}
        //   if (r == 28) {list[i].x = 330; list[i].y = 180;}
        //   if (r == 29) {list[i].x = 330; list[i].y = 180;}
        //   if (r == 30) {list[i].x = 350; list[i].y = 180;}
        //   if (r == 31) {list[i].x = 310; list[i].y = 180;}
        //   if (r == 32) {list[i].x = 330; list[i].y = 180;}
        //   if (r == 33) {list[i].x = 310; list[i].y = 180;}
        //   if (r == 34) {list[i].x = 310; list[i].y = 180;}
        //   if (r == 35) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 36) {list[i].x = 310; list[i].y = 180;}
        //   if (r == 37) {list[i].x = 320; list[i].y = 180;}
        //   if (r == 38) {list[i].x = 330; list[i].y = 180;}
        //   if (r == 39) {list[i].x = 320; list[i].y = 200;}
        //   if (r == 40) {list[i].x = 310; list[i].y = 180;}
        // }
      }

    }
    if(e.getSource() == endSummary){
      showSummary = false;
      endSummary.setVisible(false);
      nextCycle.setVisible(true);
      sortingPopup.list = new Item[8];
              for(int i = 0; i < list.length; i++){
              sortingPopup.list[i] = sortingPopup.randomItem();
              }
              sortingPopup.getList(list);
      // sortingPopup.generateNewList();
      // sortingPopup.updateHomeList();
      
    }
    buttonPressed++;
  }

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
      if (Home.totalScore >= 0 && Home.totalScore <=7){
        plants[0].y = 515;
        plants[1].y = 575;
        plants[2].y = 525;
        plants[3].y = 510;
        plants[4].y = 535;
        plants[5].y = 545;
        // plants[0].x = 535;
        // plants[1].x = 575;
        // plants[2].x = 545;
        // plants[3].x = 530;
        // // plants[4].x = 535; this one is fine
        // plants[5].x = 545;
        plants[i].drawSprout(g);
      }
      if(Home.totalScore > 7 && Home.totalScore <= 14){
        plants[i].drawFlowerS2(g);
      }
      if(Home.totalScore > 14 && Home.totalScore <= 21)
      if (scores > 5){
        plants[i].drawFlowerS3(g);
      }
      if(Home.totalScore > 21 && Home.totalScore <= 29){
        plants[i].drawFlowerS4(g);
      }
      if(Home.totalScore > 29){
        plants[i].drawHealthy(g);
      }
    }
  }

  public void drawStageTwo(Graphics g){
    for(int i = 0; i < plants.length; i++){
      if(Home.totalScore < 0){
        plants[i].drawUnhealthyS2(g);
      }
      if (Home.totalScore >= 0 && Home.totalScore <=7){
        plants[i].drawSproutS2(g);
      }
      if(Home.totalScore > 7 && Home.totalScore <= 14){
        plants[i].drawFlowerS2S2(g);
      }
      if(Home.totalScore > 14 && Home.totalScore <= 21)
      if (scores > 5){
        plants[i].drawFlowerS3S2(g);
      }
      if(Home.totalScore > 21 && Home.totalScore <= 29){
        plants[i].drawFlowerS4S2(g);
      }
      if(Home.totalScore > 29){
        plants[i].drawHealthyS2(g);
      }
    }
  }

  public void drawStageThree(Graphics g){
    for(int i = 0; i < plants.length; i++){
      if(Home.totalScore < 0){
        plants[i].drawUnhealthyS3(g);
      }
      if (Home.totalScore >= 0 && Home.totalScore <=7){
        plants[i].drawSproutS3(g);
      }
      if(Home.totalScore > 7 && Home.totalScore <= 14){
        plants[i].drawFlowerS2S3(g);
      }
      if(Home.totalScore > 14 && Home.totalScore <= 21)
      if (scores > 5){
        plants[i].drawFlowerS3S3(g);
      }
      if(Home.totalScore > 21 && Home.totalScore <= 29){
        plants[i].drawFlowerS4S3(g);
      }
      if(Home.totalScore > 29){
        plants[i].drawHealthyS3(g);
      }
    }
  }
  

}
