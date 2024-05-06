import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JPanel {
  static JFrame frame = new JFrame();
  static JFrame pop = new JFrame();
  static JFrame garden = new JFrame();
  static Home ex;
  static boolean seeGarden;
  //static JButton button;
  public static void main(String[] args){
    seeGarden = false;

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
      ex = new Home(pop);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(ex);
      frame.pack();
      frame.setVisible(true);
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
      endSummaryButton.setBounds(220,650,250,140);
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