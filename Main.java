import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JPanel {
  static JFrame frame = new JFrame();
  static JFrame pop = new JFrame();
  //static JButton button;
  public static void main(String[] args){
    Home ex = new Home();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(ex);
    frame.pack();
    frame.setVisible(true);
    ex.changeDay = true;

    while (!Home.cycleEnd){
      System.out.println("ha");
    }



    JButton compostButton = new JButton();
    JButton trashButton = new JButton();
    sortingPopup popup = new sortingPopup(compostButton, trashButton);

    pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pop.setContentPane(popup);
    pop.setLayout(null);
    

    compostButton.setBounds(50,450,265,160);
    trashButton.setBounds(450,450,265,160);
    pop.add(compostButton);
    pop.add(trashButton);
    //button.addActionListener(popup);

    pop.pack();
    pop.setVisible(Home.cycleEnd);
    }

    public static void popupEnd(boolean popEnd){
      pop.setVisible(!popEnd);
    }
   
}