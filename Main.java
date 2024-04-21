import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JPanel{
  public static void main(String[] args){
    JFrame frame = new JFrame();
    Home ex = new Home();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(ex);
    frame.pack();
    frame.setVisible(true);
    ex.changeDay = true;

    while (!Home.cycleEnd){
      System.out.println("ha");
    }
    JFrame pop = new JFrame();
    sortingPopup popup = new sortingPopup();
    pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pop.setContentPane(popup);
    pop.pack();
    pop.setVisible(Home.cycleEnd);
    }
}