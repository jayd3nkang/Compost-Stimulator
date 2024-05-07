import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

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
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("coffeeCup.png");
        Image pic = object.getImage().getScaledInstance((int)(w/1.6), (int)(h/1.6), Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
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
