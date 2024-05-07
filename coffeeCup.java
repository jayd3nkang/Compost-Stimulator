import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class coffeeCup extends Item implements Goods{
    private int classification = -1;

    public coffeeCup(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 106;
        this.h = 158;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("coffeeCup.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("coffeeCup.png");
        Image pic = object.getImage().getScaledInstance((int)(w/1.6), (int)(h/1.6), Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        // BufferedImage resized = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        // Graphics2D graphics2d = resized.createGraphics();
        // graphics2d.drawImage(pic, x, y, 50, 50, this);
        g.drawImage(object.getImage(), x, y, this);
    }
    public String toString(){
        return "Coffee cup";
    }
    @Override

    public int isCompostable(){
        return 1;
    }
    @Override

    public int getClassification(){
        return classification;
    }
    @Override
    public void setClassification(int c){
        this.classification = c;
    }
}
