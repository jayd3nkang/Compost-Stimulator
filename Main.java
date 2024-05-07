import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// the MusicPlayer class references https://www.muradnabizade.com/backgroundmusicjava
class MusicPlayer {
  void playMusic(String musicLoc){
    try {
      File musicPath = new File(musicLoc);
        if(musicPath.exists()){ 
          AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
          Clip clip = AudioSystem.getClip();
          clip.open(audioInput);
          clip.loop(Clip.LOOP_CONTINUOUSLY);
          clip.start();
        }
        else{
          System.out.println("Couldn't find Music file");
        }
      }
        catch (Exception ex){
          ex.printStackTrace();
        }
     }
}

class Main extends JPanel {

  // initiates all of the JFrames that show up for different parts of the game
  static JFrame frame = new JFrame();
  static JFrame pop = new JFrame();
  static JFrame garden = new JFrame();
  static Home ex;
  static boolean seeGarden;
  static JButton startButton = new JButton();
  //static JButton button;
  public static void main(String[] args){
    
    seeGarden = false;
    startButton.setBorderPainted(false);
    startButton.setOpaque(false);
    startButton.setFocusable(false);
    startButton.setIcon(new ImageIcon("startButton.png"));

    String filePath = "childhood-afternoons-lloom-main-version-25583-03-11.wav";
    MusicPlayer play = new MusicPlayer();
    play.playMusic(filePath);

    homeSetUp();
    while (!Home.cycleEnd){
      System.out.print("");
    }
    popUpScreenSetUp();

    }

    // public static void popupEnd(boolean popEnd){
    //   pop.setVisible(!popEnd);
    // }
    public static void seeG(boolean seeGarden){
      garden.setVisible(seeGarden);
    }

    public static void homeSetUp(){
      ex = new Home(pop, startButton);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(ex);
      frame.setLayout(null);
      frame.pack();
      frame.setVisible(true);
      startButton.setBounds(425,500,200,100);
      frame.add(startButton);
    }
    public static void popUpScreenSetUp(){
      JButton compostButton = new JButton();
      JButton trashButton = new JButton();
      sortingPopup popup = new sortingPopup(compostButton, trashButton);
  
      pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pop.setContentPane(popup);
      pop.setLayout(null);
      
  
      compostButton.setBounds(50,450,245,137);
      compostButton.setBorderPainted(false);
      compostButton.setFocusable(false);
      compostButton.setBackground(new Color(241,246,220));
      trashButton.setBounds(450,450,247,143);
      trashButton.setBorderPainted(false);
      trashButton.setFocusable(false);
      trashButton.setBackground(new Color(241,246,220));
      pop.add(compostButton);
      pop.add(trashButton);
      //button.addActionListener(popup);
  
      pop.pack();
  
      JButton newCycleButton = new JButton();
      newCycleButton.setBounds(650, 80, 250, 140);
      newCycleButton.setBorderPainted(false);
      newCycleButton.setOpaque(false);
      newCycleButton.setBackground(new Color(152,231,177));
      newCycleButton.setFocusable(false);
      newCycleButton.setVisible(false);
      JButton endSummaryButton = new JButton();
      endSummaryButton.setBounds(220,680,250,140);
      endSummaryButton.setBorderPainted(false);
      endSummaryButton.setOpaque(false);
      endSummaryButton.setBackground(new Color(241,246,220));
      endSummaryButton.setFocusable(false);
      Garden gar = new Garden(newCycleButton, endSummaryButton);
      garden.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      garden.setContentPane(gar);
      garden.setLayout(null);
      garden.add(newCycleButton);
      garden.add(endSummaryButton);
      garden.pack();
    }

}