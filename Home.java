import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.URL;

class Home{
  public Home(){
    JPanel panel = new JPanel();
    ImageIcon img = new ImageIcon("finalProjectHome.png");
    JLabel jlpic = new JLabel(img);

    panel.add(jlpic);
  }

  public static void main(String[] args){
    Home ex = new Home();
  }
}