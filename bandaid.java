import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class bandaid extends Item implements Goods{
    private int classification = -1;

    public bandaid(int x, int y){
        this.x = x;
        this.y = y;
        this.w = 187;
        this.h = 91;
        this.p = 1;
    }

    public void draw(Graphics g){
        ImageIcon object = new ImageIcon("bandaid.png");
        Image pic = object.getImage();
        g.drawImage(pic, x, y, this);
    }
    public void drawSmall(Graphics g){
        ImageIcon object = new ImageIcon("bandaid.png");
        Image pic = object.getImage().getScaledInstance((int)(w/1.6), (int)(h/1.6), Image.SCALE_SMOOTH);
        object = new ImageIcon(pic, object.getDescription());
        g.drawImage(object.getImage(), x, y, this);
    }
    public String toString(){
        return "Band-Aid";
    }
    @Override

    public int isCompostable(){
        return 0;
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

