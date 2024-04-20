import java.awt.Color;
import java.awt.Graphics;

public class Garden {
    public int HEIGHT = 1000;
    public int WIDTH = 1000;
    public Garden(int n){

    }

    public void gardenGrowingAnimation(){
        // different stages of the plants could be animated to display their health
    }
    public void plant(Graphics g){
        
    }
    public void growPlants(){
        // the logic that determines whether a plant will grow or wither based on the user interaction/sorting
    }
    public void draw(Graphics g){
        // blue background...you guys did that out already!
        g.setColor(new Color(0,0,150));
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

}
