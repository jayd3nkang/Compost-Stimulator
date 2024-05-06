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
        nextCycle.setIcon(compostIcon);
        endSummary = input2;
        endSummary.addActionListener(this);
        endSummary.setIcon(compostIcon);
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
        int showScore = 0;
        ImageIcon summary = new ImageIcon("summaryBackground.png");
        Image eodSum = summary.getImage();
        ImageIcon check = new ImageIcon("right.png");
        Image right = check.getImage();
        ImageIcon ex = new ImageIcon("wrong.png");
        Image wrong = ex.getImage();
        g.drawImage(eodSum, 200, 25, this);
        list[0].x = 250;
        list[1].x = 520;
        list[2].x = 250;
        list[3].x = 520;
        list[4].x = 250;
        list[5].x = 520;
        list[6].x = 250;
        list[7].x = 520;
        list[0].y = 140;
        list[1].y = 140;
        list[2].y = 270;
        list[3].y = 270;
        list[4].y = 400;
        list[5].y = 400;
        list[6].y = 530;
        list[7].y = 530;
        for (int i = 0; i < list.length; i++){
          list[i].drawSmall(g);
          if (list[i].l == list[i].p) {
            g.drawImage(right, list[i].x + 150, list[i].y + 24, this);
            showScore++;
          }
          else {
            g.drawImage(wrong, list[i].x + 150, list[i].y + 24, this);
          }
        }
        g.setFont(new Font("Comic Sans MS",Font.PLAIN,40));
          g.setColor(Color.BLACK);
          g.drawString(showScore + " / 8", 680, 760);
      }
    }
  @Override
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == nextCycle){

      list[buttonPressed].changeLocation(1);
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
        list[i].x = 320;
        list[i].y = 180;
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
      
    }
    buttonPressed++;
  }

  public void drawStageOne(Graphics g){
    for(int i = 0; i < plants.length; i++){
      if(Home.totalScore < 0){
        plants[i].drawUnhealthy(g);
      }
      if (Home.totalScore >= 0 && Home.totalScore <=7){
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
