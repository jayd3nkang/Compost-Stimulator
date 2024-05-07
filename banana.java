import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class banana extends Item implements Goods{
    private int classification = -1;

    public banana(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 201;
        this.h = 148;
        this.p = 1;
    }

    @Override
    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("banana.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("banana.png");
        Image pic = object.getImage().getScaledInstance(99, 99, Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        // BufferedImage resized = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        // Graphics2D graphics2d = resized.createGraphics();
        // graphics2d.drawImage(pic, x, y, 50, 50, this);
        g.drawImage(object.getImage(), x, y, this);
    }
    public String toString(){
        return "Banana";
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
