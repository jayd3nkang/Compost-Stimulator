import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class book extends Item implements Goods{
    private int classification = -1;

    public book(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 152;
        this.h = 182;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("book.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
        //System.out.println("hello");
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("book.png");
        Image pic = object.getImage().getScaledInstance(99, 99, Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        // BufferedImage resized = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        // Graphics2D graphics2d = resized.createGraphics();
        // graphics2d.drawImage(pic, x, y, 50, 50, this);
        g.drawImage(object.getImage(), x, y, this);
    }
    public String toString(){
        return "Book";
    }
    public int isCompostable(){
        return 0;
    }
    public int getClassification(){
        return classification;
    }
    public void setClassification(int c){
        this.classification = c;
    }
}