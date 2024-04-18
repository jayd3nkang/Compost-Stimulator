import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;

class Home{
  JFrame frame;
  int gColor = 206;
  public Home(){
    //this.setPreferredSize(new Dimension(1000,1000));
    ImageIcon house = new ImageIcon("house.png");
    JLabel label = new JLabel();
    label.setIcon(house);
    frame = new JFrame();
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000,1000);
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(135,gColor,235));
    frame.add(label);
  }

  // public void dayToNight(){
  //   for(int i = 0; i < 100; i++){
  //     frame.getContentPane().setBackground(new Color(135, gColor + i, 235));
  //   }
  // }
}