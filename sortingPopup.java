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

public class sortingPopup extends Home implements ActionListener{
    Boolean sorted = false;
    // list of items to be sorted every cycle
    public static Item[] list;

    JButton compostButton;
    JButton trashButton;

    int counter = 0;
    public static Boolean popEnd = false;

    int location;
    int buttonPressed = 0;
    //double placeboC = 0.0;

  public sortingPopup(JButton input, JButton input2){
    compostButton = input;
    trashButton = input2;



    ImageIcon compostIcon = new ImageIcon("compostButton.png");
    ImageIcon trashIcon = new ImageIcon("otherButton.png");

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
        while(true){
            // sorting();
            repaint();
            if (counter >= 7) {
              popEnd = true;
              pop.setVisible(false);
              garden.setVisible(true);
              counter = 0;
              generateNewList();
        }
            try{
          Thread.sleep(10);
        }
      catch(InterruptedException e){}
    }
      }
     
  }


  public Item randomItem(){
    int r = (int) (Math.random() * 40) + 1;
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
    if (r == 15) {i = new teabag(380, 200);};
    if (r == 16) {i = new coffeebean(380, 200);};
    if (r == 17) {i = new bandaid(380, 250);};
    if (r == 18) {i = new bread(380, 250);};
    if (r == 19) {i = new chair(380, 250);};
    if (r == 20) {i = new cheese(380, 250);};
    if (r == 21) {i = new cherry(380, 250);};
    if (r == 22) {i = new chess(380, 250);};
    if (r == 23) {i = new chocolate(380, 250);};
    if (r == 24) {i = new coffeeCup(380, 250);};
    if (r == 25) {i = new dogPoop(380, 250);};
    if (r == 26) {i = new fish(380, 250);};
    if (r == 27) {i = new fork(380, 250);};
    if (r == 28) {i = new waterBottle(380, 200);};
    if (r == 29) {i = new lawEssay(380, 200);};
    if (r == 30) {i = new napkin(380, 200);};
    if (r == 31) {i = new newspaper(380, 200);};
    if (r == 32) {i = new paperStraw(380, 200);};
    if (r == 33) {i = new plasticBag(380, 250);};
    if (r == 34) {i = new plasticStraw(380, 250);};
    if (r == 35) {i = new rose(380, 250);};
    if (r == 36) {i = new shirt(380, 250);};
    if (r == 37) {i = new strawberry(380, 250);};
    if (r == 38) {i = new takeout(380, 250);};
    if (r == 39) {i = new pills(380, 250);};
    if (r == 40) {i = new pizzaBox(380, 250);};

    return i;
  }

  public void paintComponent(Graphics g){
    g.setColor(new Color(200,210,200));
    g.fillRect(0, 0, 800, 500);
    list[counter].draw(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource() == compostButton){
      counter++;
    }
    if(e.getSource() == trashButton){
      counter++;
    }

  }
  //creates a new set of items for the user(s) to sort through
  public void generateNewList(){
    Item[] toReturn = new Item[8];
    for(int i = 0; i < toReturn.length; i++){
      toReturn[i] = randomItem();
    }
    for(int i = 0; i < toReturn.length; i++){
      this.list[i] = toReturn[i];
    }
  }

}
