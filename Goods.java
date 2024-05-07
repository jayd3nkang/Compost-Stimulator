import java.awt.Graphics;

public interface Goods {
  public void draw(Graphics g);
  public int isCompostable();
  public int getClassification();
  public void setClassification(int c);
  public String toString();
}
