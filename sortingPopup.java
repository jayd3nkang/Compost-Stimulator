import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingPopUp extends Home implements ActionListener{
    //static JFrame frame;
    Boolean sorted = false;
    //Carrot carrot;
    // list of items to be sorted every cycle
    public static Item[] list;

    JButton compostButton;
    JButton trashButton;

    int counter = 0;
    public static Boolean popEnd = false;

    int location;
    int buttonPressed = 0;
    //double placeboC = 0.0;

  public SortingPopUp(JButton input, JButton input2){
    compostButton = input;
    trashButton = input2;



    ImageIcon compostIcon = new ImageIcon("compostButton.png");
    ImageIcon trashIcon = new ImageIcon("trashButton.png");

    compostButton.addActionListener(this);
    compostButton.setIcon(compostIcon);
    trashButton.addActionListener(this);
    trashButton.setIcon(trashIcon);

    this.setPreferredSize(new Dimension(800,600));

    list = new Item[8];
    for(int i = 0; i < list.length; i++){
      list[i] = randomItem();
    }
    Home.getList(list);

    Thread main = new Thread(new myRunnable());
    main.start();
  }

  public class myRunnable implements Runnable{
    public void run(){
        // every cycle, 8 items will need to be sorted
        // popup goes through every item with a description of all the items
        // list = new Item[8];
        // for (int i = 0; i < list.length; i++){
        //     list[i] = randomItem();
        // }
        while(!popEnd){
            // sorting();
            repaint();
            if (counter >= 7) {
              popEnd = true;
              pop.setVisible(false);
              garden.setVisible(true);
              counter = 0;
              list = generateNewList();
        }
            try{
          Thread.sleep(10);
        }
      catch(InterruptedException e){}
    }
      }
     
  }
  // public void sorting(){
  //   // check if the user is clicking the right button
  // }

  public Item randomItem(){
    int r = (int) (Math.random() * 16) + 1;
    Item i = new Item();
    if (r == 1) {i = new Carrot(380, 250);};
    if (r == 2) {i = new banana(380, 250);};
    if (r == 3) {i = new battery(380, 250);};
    if (r == 4) {i = new halfApizza(380, 250);};
    if (r == 5) {i = new Cup(380, 250);};
    if (r == 6) {i = new spinAch(380, 250);};
    if (r == 7) {i = new Orange(380, 250);};
    if (r == 8) {i = new potato(380, 250);};
    if (r == 9) {i = new Twig(380, 250);};
    if (r == 10) {i = new eggSHell(380, 250);};
    if (r == 11) {i = new cig(380, 250);};
    if (r == 12) {i = new Chips(380, 200);};
    if (r == 13) {i = new book(380, 200);};
    if (r == 14) {i = new can(380, 200);};
    if (r == 15) {i = new CSteabag(380, 200);};
    if (r == 16) {i = new coffeebean(380, 200);};
    return i;
  }

  public void paintComponent(Graphics g){
    g.setColor(new Color(200,210,200));
    g.fillRect(0, 0, 800, 500);
    list[counter].draw(g);
    //System.out.println("counter is: " + counter);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //int counter = 0;
    // TODO Auto-generated method stub
    if(e.getSource() == compostButton){
      //placeboC+=0.5;
      counter++;
      //list[buttonPressed].changeLocation(1);
      System.out.println("compost button clicked");
    }
    if(e.getSource() == trashButton){
      counter++;
      System.out.println("trash button clicked");
      //list[buttonPressed].changeLocation(0);
    }

    // if(e.getSource() == nextDay){
    //   System.out.println("HELLo");
    // }
    //buttonPressed++;
  }

  //creates a new set of items for the user(s) to sort through
  public Item[] generateNewList(){
    Item[] toReturn = new Item[8];
    for(int i = 0; i < toReturn.length; i++){
      toReturn[i] = randomItem();
    }

    return toReturn;
  }

}
