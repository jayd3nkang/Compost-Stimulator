import java.awt.Graphics;

public interface Goods {
  //methods needed in every class that implements goods
  public void draw(Graphics g);
  public int isCompostable();
  public int getClassification();
  public void setClassification(int c);
  public String toString();
  public void drawSmall(Graphics g);
}
