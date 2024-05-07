import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class battery extends Item implements Goods{
    private int classification = -1;

    public battery(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 101;
        this.h = 92;
    }

    public void draw(Graphics g){
        ImageIcon carrot = new ImageIcon("battery.png");
        Image pic = carrot.getImage();
        g.drawImage(pic, x, y, this);
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("battery.png");
        Image pic = object.getImage().getScaledInstance((int)(w/1.6), (int)(h/1.6), Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        g.drawImage(object.getImage(), x, y, this);
    }
    public String toString(){
        return "Battery";
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