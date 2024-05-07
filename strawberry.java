import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class strawberry extends Item implements Goods{
    private int classification = -1;

    public strawberry(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 95;
        this.h = 149;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("strawberry.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
    }

    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("strawberry.png");
        Image pic = object.getImage().getScaledInstance((int)(w/1.6), (int)(h/1.6), Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        g.drawImage(object.getImage(), x, y, this);
    }

    public String toString(){
        return "Strawberry";
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
