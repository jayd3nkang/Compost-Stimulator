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
              Thread.sleep(100);
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

        System.out.println("this round score" + scores + " total " + totalScore);
        
      
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
        if(Home.totalScore >= 30){
          plants[i].drawHealthy(g);
        }
       //if (scores <= 5 && scores >= 3) {plants[i].drawSprout(g);}
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
          g.setFont(new Font("Comic Sans MS",Font.PLAIN,40));
          g.setColor(Color.BLACK);
          g.drawString(showScore + " / 8", 680, 760);
        }
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
      
    }
    if(e.getSource() == endSummary){
      showSummary = false;
      endSummary.setVisible(false);
      nextCycle.setVisible(true);
      
    }
    buttonPressed++;
  }
  

}
