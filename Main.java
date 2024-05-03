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
    // if(sortingPopup.popEnd != false){
      
    //   //System.out.println("HELLOOOO");
    // }
    // //frame.setVisible(false);
    //System.out.println("LETS GO" + "\n");
    //popUpScreenSetUp();

    // while(!ex.getGardenButtonStatus()){
    //   System.out.print("");
    // }
    // System.out.println("world says hello");
    // while(true){
    //   if(!ex.getGardenButtonStatus()){
    //     pop.setVisible(true);
    //   }
    //   else{
    //     pop.setVisible(false);
    //   }
    // }
    
    }

    public static void popupEnd(boolean popEnd){
      pop.setVisible(!popEnd);
    }
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
      SortingPopUp popup = new SortingPopUp(compostButton, trashButton);
  
      pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pop.setContentPane(popup);
      pop.setLayout(null);
      
  
      compostButton.setBounds(50,450,265,160);
      trashButton.setBounds(450,450,265,160);
      pop.add(compostButton);
      pop.add(trashButton);
      //button.addActionListener(popup);
  
      pop.pack();
  
      JButton newCycleButton = new JButton();
      newCycleButton.setBounds(500, 200, 400, 200);
      Garden gar = new Garden(newCycleButton);
      garden.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      garden.setContentPane(gar);
      garden.setLayout(null);
      garden.add(newCycleButton);
      garden.pack();
    }

   
}