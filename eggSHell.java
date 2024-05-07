import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class eggSHell extends Item implements Goods{
    private int classification = -1;

    public eggSHell(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 150;
        this.h = 96;
        this.p = 1;
    }

    // public void draw(Graphics g){
    //     //System.out.println("hello");
    // }

   // @Override
    public void draw(Graphics g) {
        ImageIcon object = new ImageIcon("eggSHell.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("eggSHell.png");
        Image pic = object.getImage().getScaledInstance((int)(w/1.6), (int)(h/1.6), Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        // BufferedImage resized = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        // Graphics2D graphics2d = resized.createGraphics();
        // graphics2d.drawImage(pic, x, y, 50, 50, this);
        g.drawImage(object.getImage(), x, y, this);
    }
    public String toString(){
        return "Eggshell";
    }
    public int isCompostable(){
        return 1;
    }
    public int getClassification(){
        return classification;
    }
    public void setClassification(int c){
        this.classification = c;
    }
}