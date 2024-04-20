import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JPanel{
  public static void main(String[] args){
    JFrame frame = new JFrame();
    Home ex = new Home();
    frame.setContentPane(ex);
    frame.pack();
    frame.setVisible(true);

    ex.changeDay = true;
    }
}