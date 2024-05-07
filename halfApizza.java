import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class halfApizza extends Item implements Goods{
    private int classification = -1;

    public halfApizza(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 180;
        this.h = 181;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("halfApizza.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("halfApizza.png");
        Image pic = object.getImage().getScaledInstance((int)(w/1.6), (int)(h/1.6), Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        g.drawImage(object.getImage(), x, y, this);
    }
    public String toString(){
        return "Pizza";
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